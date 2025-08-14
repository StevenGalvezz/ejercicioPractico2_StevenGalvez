/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.List;
import lombok.Data;
/**
 *
 * @author Juan
 */

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // En SQL: id BIGINT PRIMARY KEY AUTO_INCREMENT

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "apellidos", length = 50)
    private String apellidos;

    @Column(name = "correo", unique = true, length = 100)
    private String correo;

    @Column(length = 15)
    private String telefono;

    @Column(name = "ruta_imagen", length = 300)
    private String rutaImagen;

    private boolean activo = true;

    private boolean enabled = true; // Para compatibilidad con Spring Security

    // Relación Many-to-Many con Rol
    @ManyToMany
    @JoinTable(
        name = "usuarios_roles",
        joinColumns = @JoinColumn(name = "usuario_id"), // FK a Usuario
        inverseJoinColumns = @JoinColumn(name = "rol_id") // FK a Rol
    )
    private Set<Rol> roles;

    // Relación One-to-Many con Reserva
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Reserva> reservas;
}
