/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.service;

import com.cine.domain.Pelicula;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface PeliculaService {

    // Lista de películas filtrando activas/inactivas
    public List<Pelicula> getPeliculas(boolean activo);

    // Obtiene una película por id (a partir del objeto)
    public Pelicula getPelicula(Pelicula pelicula);

    // Guarda o actualiza una película
    public void save(Pelicula pelicula);

    // Elimina una película
    public void delete(Pelicula pelicula);

    // Consulta por duración en rango y ordenadas por título
    public List<Pelicula> findByDuracionBetweenOrderByTitulo(int duracionMin, int duracionMax);

    // Consulta usando JPQL
    public List<Pelicula> metodoJPQL(int duracionMin, int duracionMax);

    // Consulta usando SQL Nativo
    public List<Pelicula> metodoNativo(int duracionMin, int duracionMax);
}

