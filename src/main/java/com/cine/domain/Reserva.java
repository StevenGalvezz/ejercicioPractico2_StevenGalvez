/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import lombok.Data;
/**
 *
 * @author Juan
 */

@Data
@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idReserva;

    // Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Relación con Función
    @ManyToOne
    @JoinColumn(name = "funcion_id", nullable = false)
    private Funcion funcion;

    private int cantidadAsientos;

    private double total;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReserva;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EstadoReserva estado; // RESERVADA o CANCELADA

    public Reserva() {
        this.fechaReserva = Calendar.getInstance().getTime();
        this.estado = EstadoReserva.RESERVADA;
    }

    public Reserva(Usuario usuario, Funcion funcion, int cantidadAsientos) {
        this.usuario = usuario;
        this.funcion = funcion;
        this.cantidadAsientos = cantidadAsientos;
        this.total = funcion.getPrecio() * cantidadAsientos;
        this.fechaReserva = Calendar.getInstance().getTime();
        this.estado = EstadoReserva.RESERVADA;
    }

    // Enum para el estado
    public enum EstadoReserva {
        RESERVADA, CANCELADA
    }
}
