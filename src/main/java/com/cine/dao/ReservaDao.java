/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.dao;

import com.cine.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
/**
 *
 * @author Juan
 */
public interface ReservaDao extends JpaRepository<Reserva, Long> {

    List<Reserva> findByCantidadAsientosBetweenOrderByFechaReserva(int min, int max);

    @Query("SELECT r FROM Reserva r WHERE r.cantidadAsientos BETWEEN :min AND :max ORDER BY r.fechaReserva")
    List<Reserva> metodoJPQL(@Param("min") int min, @Param("max") int max);

    @Query(value = "SELECT * FROM reservas r WHERE r.cantidad_asientos BETWEEN :min AND :max ORDER BY r.fecha_reserva", nativeQuery = true)
    List<Reserva> metodoNativo(@Param("min") int min, @Param("max") int max);
}

