/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
/**
 *
 * @author Juan
 */

@Data
@Entity
@Table(name = "funciones")
public class Funcion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id función

    @ManyToOne(optional = false)
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula; // Relación con Pelicula

    @Column(nullable = false)
    private java.sql.Date fecha; // Fecha de la función

    @Column(nullable = false)
    private java.sql.Time hora; // Hora de la función

    @Column(length = 50)
    private String sala; // Sala o auditorio

    @Column(nullable = false)
    private double precio; // Precio por asiento

    @Column(name = "total_asientos", nullable = false)
    private int totalAsientos; // Total asientos disponibles en sala

    // Relación OneToMany con Reserva: una función puede tener muchas reservas
    @OneToMany(mappedBy = "funcion", cascade = CascadeType.ALL)
    private List<Reserva> reservas;
}
