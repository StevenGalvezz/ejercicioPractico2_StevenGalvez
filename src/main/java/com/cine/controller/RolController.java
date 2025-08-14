/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.controller;

import com.cine.domain.Rol;
import com.cine.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author Juan
 */

@Controller
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var roles = rolService.getRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("totalRoles", roles.size());
        return "/rol/listado";
    }

    @GetMapping("/nuevo")
    public String rolNuevo(Rol rol) {
        return "/rol/modifica";
    }

    @PostMapping("/guardar")
    public String rolGuardar(Rol rol) {
        rolService.save(rol);
        return "redirect:/rol/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String rolEliminar(Rol rol) {
        rolService.delete(rol);
        return "redirect:/rol/listado";
    }

    @GetMapping("/modificar/{id}")
    public String rolModificar(Rol rol, Model model) {
        rol = rolService.getRol(rol);
        model.addAttribute("rol", rol);
        return "/rol/modifica";
    }
}
