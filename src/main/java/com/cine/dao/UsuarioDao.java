/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.dao;

import com.cine.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Juan
 */

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    List<Usuario> findByActivo(boolean activo);

    Optional<Usuario> findByUsername(String username);

    @Query("SELECT u FROM Usuario u WHERE LOWER(u.correo) LIKE LOWER(CONCAT('%', :filtro, '%'))")
    List<Usuario> metodoJPQL(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM usuarios u WHERE LOWER(u.correo) LIKE LOWER(CONCAT('%', :filtro, '%'))", nativeQuery = true)
    List<Usuario> metodoNativo(@Param("filtro") String filtro);
}

