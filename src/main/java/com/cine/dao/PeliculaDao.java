/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.dao;

import com.cine.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
/**
 *
 * @author Juan
 */

public interface PeliculaDao extends JpaRepository<Pelicula, Long> {

    List<Pelicula> findByActivoTrue();

    List<Pelicula> findByGenero(String genero);

    List<Pelicula> findByActivo(boolean activo);

    List<Pelicula> findByDuracionBetweenOrderByTitulo(int duracionMin, int duracionMax);

    @Query("SELECT p FROM Pelicula p WHERE p.duracion BETWEEN :minDuracion AND :maxDuracion ORDER BY p.titulo")
    List<Pelicula> metodoJPQL(@Param("minDuracion") int minDuracion, @Param("maxDuracion") int maxDuracion);

    @Query(value = "SELECT * FROM peliculas p WHERE p.duracion BETWEEN :minDuracion AND :maxDuracion ORDER BY p.titulo", nativeQuery = true)
    List<Pelicula> metodoNativo(@Param("minDuracion") int minDuracion, @Param("maxDuracion") int maxDuracion);
}

