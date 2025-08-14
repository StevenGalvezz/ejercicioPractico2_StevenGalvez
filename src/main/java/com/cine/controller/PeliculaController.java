/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.controller;

import com.cine.domain.Pelicula;
import com.cine.service.PeliculaService;
// import com.cine.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author Juan
 */

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    /*
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    */

    @GetMapping("/listado")
    public String listado(Model model) {
        var peliculas = peliculaService.getPeliculas(true); // solo activas
        model.addAttribute("peliculas", peliculas);
        model.addAttribute("totalPeliculas", peliculas.size());
        return "/pelicula/listado";
    }

    @GetMapping("/nuevo")
    public String peliculaNueva(Pelicula pelicula) {
        return "/pelicula/modifica";
    }

    @PostMapping("/guardar")
    // public String peliculaGuardar(Pelicula pelicula, @RequestParam("imagenFile") MultipartFile imagenFile) {
    public String peliculaGuardar(Pelicula pelicula) {
        /*
        if (!imagenFile.isEmpty()) {
            peliculaService.save(pelicula);
            pelicula.setImagenUrl(firebaseStorageService.cargaImagen(imagenFile, "pelicula", pelicula.getId()));
        }
        */
        peliculaService.save(pelicula);
        return "redirect:/pelicula/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String peliculaEliminar(Pelicula pelicula) {
        peliculaService.delete(pelicula);
        return "redirect:/pelicula/listado";
    }

    @GetMapping("/modificar/{id}")
    public String peliculaModificar(Pelicula pelicula, Model model) {
        pelicula = peliculaService.getPelicula(pelicula);
        model.addAttribute("pelicula", pelicula);
        return "/pelicula/modifica";
    }
}

