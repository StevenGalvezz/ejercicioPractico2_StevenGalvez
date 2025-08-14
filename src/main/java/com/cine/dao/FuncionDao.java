/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.dao;

import com.cine.domain.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
/**
 *
 * @author Juan
 */
public interface FuncionDao extends JpaRepository<Funcion, Long> {

    List<Funcion> findByPrecioBetweenOrderByFecha(double precioMin, double precioMax);

    @Query("SELECT f FROM Funcion f WHERE f.precio BETWEEN :precioMin AND :precioMax ORDER BY f.fecha")
    List<Funcion> metodoJPQL(@Param("precioMin") double precioMin, @Param("precioMax") double precioMax);

    @Query(value = "SELECT * FROM funciones f WHERE f.precio BETWEEN :precioMin AND :precioMax ORDER BY f.fecha", nativeQuery = true)
    List<Funcion> metodoNativo(@Param("precioMin") double precioMin, @Param("precioMax") double precioMax);
}

