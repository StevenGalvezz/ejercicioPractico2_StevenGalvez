/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.dao;

import com.cine.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Juan
 */
public interface RolDao extends JpaRepository<Rol, Long> {

    Optional<Rol> findByNombre(String nombre);

    @Query("SELECT r FROM Rol r WHERE LOWER(r.nombre) LIKE LOWER(CONCAT('%', :filtro, '%'))")
    List<Rol> metodoJPQL(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM roles r WHERE LOWER(r.nombre) LIKE LOWER(CONCAT('%', :filtro, '%'))", nativeQuery = true)
    List<Rol> metodoNativo(@Param("filtro") String filtro);
}

