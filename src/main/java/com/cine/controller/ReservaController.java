/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.controller;

import com.cine.domain.Reserva;
import com.cine.service.ReservaService;
import com.cine.service.UsuarioService;
import com.cine.service.FuncionService;
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
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FuncionService funcionService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var reservas = reservaService.getReservas();
        model.addAttribute("reservas", reservas);
        model.addAttribute("usuarios", usuarioService.getUsuarios(true));
        model.addAttribute("funciones", funcionService.getFunciones());
        model.addAttribute("totalReservas", reservas.size());
        return "/reserva/listado";
    }

    @GetMapping("/nuevo")
    public String reservaNueva(Reserva reserva, Model model) {
        model.addAttribute("usuarios", usuarioService.getUsuarios(true));
        model.addAttribute("funciones", funcionService.getFunciones());
        return "/reserva/modifica";
    }

    @PostMapping("/guardar")
    public String reservaGuardar(Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String reservaEliminar(Reserva reserva) {
        reservaService.delete(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/modificar/{id}")
    public String reservaModificar(Reserva reserva, Model model) {
        reserva = reservaService.getReserva(reserva);
        model.addAttribute("reserva", reserva);
        model.addAttribute("usuarios", usuarioService.getUsuarios(true));
        model.addAttribute("funciones", funcionService.getFunciones());
        return "/reserva/modifica";
    }
}
