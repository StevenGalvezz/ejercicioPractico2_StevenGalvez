/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service.impl;

import com.cine.dao.UsuarioDao;
import com.cine.domain.Usuario;
import com.cine.service.UsuarioService;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *
 * @author Juan
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;

    public UsuarioServiceImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public List<Usuario> getUsuarios(boolean activo) {
        return usuarioDao.findByActivo(activo);
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getId()).orElse(null);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioDao.findByUsername(username).orElse(null);
    }

    @Override
    public List<Usuario> metodoJPQL(String filtro) {
        return usuarioDao.metodoJPQL(filtro);
    }

    @Override
    public List<Usuario> metodoNativo(String filtro) {
        return usuarioDao.metodoNativo(filtro);
    }
}
