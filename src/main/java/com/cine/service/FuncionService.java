/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.service;

import com.cine.domain.Funcion;
import java.util.List;
/**
 *
 * @author Juan
 */

public interface FuncionService {

    // Lista de funciones
    public List<Funcion> getFunciones();

    // Obtiene una función por id (a partir del objeto)
    public Funcion getFuncion(Funcion funcion);

    // Guarda o actualiza una función
    public void save(Funcion funcion);

    // Elimina una función
    public void delete(Funcion funcion);

    // Consulta por precio de la función en rango y ordenadas por fecha
    public List<Funcion> findByPrecioBetweenOrderByFecha(double precioMin, double precioMax);

    // Consulta usando JPQL
    public List<Funcion> metodoJPQL(double precioMin, double precioMax);

    // Consulta usando SQL Nativo
    public List<Funcion> metodoNativo(double precioMin, double precioMax);
}

