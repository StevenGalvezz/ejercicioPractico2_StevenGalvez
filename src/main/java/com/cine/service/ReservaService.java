/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.service;

import com.cine.domain.Reserva;
import java.util.List;
/**
 *
 * @author Juan
 */

public interface ReservaService {

    // Lista de reservas
    public List<Reserva> getReservas();

    // Obtiene una reserva por id (a partir del objeto)
    public Reserva getReserva(Reserva reserva);

    // Guarda o actualiza una reserva
    public void save(Reserva reserva);

    // Elimina una reserva
    public void delete(Reserva reserva);

    // Consulta por cantidad de asientos reservados en rango y ordenadas por fecha de reserva
    public List<Reserva> findByCantidadAsientosBetweenOrderByFechaReserva(int min, int max);

    // Consulta usando JPQL
    public List<Reserva> metodoJPQL(int min, int max);

    // Consulta usando SQL Nativo
    public List<Reserva> metodoNativo(int min, int max);
}

