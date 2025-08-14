/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;
import lombok.Data;
/**
 *
 * @author Juan
 */

@Data
@Entity
@Table(name = "roles")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String nombre; // Ej: ROLE_ADMIN, ROLE_USER

    // Relación bidireccional con Usuario
    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios;

}
