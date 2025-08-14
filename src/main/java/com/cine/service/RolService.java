/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.service;

import com.cine.domain.Rol;
import java.util.List;
/**
 *
 * @author Juan
 */

public interface RolService {

    // Lista de roles
    public List<Rol> getRoles();

    // Obtiene un rol por id (a partir del objeto)
    public Rol getRol(Rol rol);

    // Guarda o actualiza un rol
    public void save(Rol rol);

    // Elimina un rol
    public void delete(Rol rol);

    // Consulta por nombre de rol exacto
    public Rol findByNombre(String nombre);

    // Consulta usando JPQL
    public List<Rol> metodoJPQL(String filtro);

    // Consulta usando SQL Nativo
    public List<Rol> metodoNativo(String filtro);
}

