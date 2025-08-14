/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.controller;

import com.cine.domain.Funcion;
import com.cine.service.FuncionService;
import com.cine.service.PeliculaService;
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
@RequestMapping("/funcion")
public class FuncionController {

    @Autowired
    private FuncionService funcionService;

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var funciones = funcionService.getFunciones();
        model.addAttribute("funciones", funciones);
        model.addAttribute("peliculas", peliculaService.getPeliculas(true));
        model.addAttribute("totalFunciones", funciones.size());
        return "/funcion/listado";
    }

    @GetMapping("/nuevo")
    public String funcionNueva(Funcion funcion, Model model) {
        model.addAttribute("peliculas", peliculaService.getPeliculas(true));
        return "/funcion/modifica";
    }

    @PostMapping("/guardar")
    public String funcionGuardar(Funcion funcion) {
        funcionService.save(funcion);
        return "redirect:/funcion/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String funcionEliminar(Funcion funcion) {
        funcionService.delete(funcion);
        return "redirect:/funcion/listado";
    }

    @GetMapping("/modificar/{id}")
    public String funcionModificar(Funcion funcion, Model model) {
        funcion = funcionService.getFuncion(funcion);
        model.addAttribute("funcion", funcion);
        model.addAttribute("peliculas", peliculaService.getPeliculas(true));
        return "/funcion/modifica";
    }
}
