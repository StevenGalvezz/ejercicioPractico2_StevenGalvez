/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
/**
 *
 * @author Juan
 */

@Data
@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id_pelicula en BD

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion; // Sinopsis

    @Column(length = 50)
    private String genero; // Acción, Drama, Comedia...

    private int duracion; // en minutos

    @Column(length = 300)
    private String imagenUrl; // URL póster

    private boolean activo = true; // en cartelera o no

    public Pelicula() {
    }

    public Pelicula(String titulo, String genero, int duracion, boolean activo) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.activo = activo;
    }
}
