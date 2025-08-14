/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.service;

import com.cine.domain.Usuario;
import java.util.List;
/**
 *
 * @author Juan
 */

public interface UsuarioService {

    // Lista de usuarios filtrando activos/inactivos
    public List<Usuario> getUsuarios(boolean activo);

    // Obtiene un usuario por id (a partir del objeto)
    public Usuario getUsuario(Usuario usuario);

    // Guarda o actualiza un usuario
    public void save(Usuario usuario);

    // Elimina un usuario
    public void delete(Usuario usuario);

    // Consulta por nombre de usuario
    public Usuario findByUsername(String username);

    // Consulta usando JPQL (ejemplo: por email que contenga algo)
    public List<Usuario> metodoJPQL(String filtro);

    // Consulta usando SQL Nativo
    public List<Usuario> metodoNativo(String filtro);
}

