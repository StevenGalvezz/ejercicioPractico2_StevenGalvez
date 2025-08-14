/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service.impl;

import com.cine.dao.RolDao;
import com.cine.domain.Rol;
import com.cine.service.RolService;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *
 * @author Juan
 */

@Service
public class RolServiceImpl implements RolService {

    private final RolDao rolDao;

    public RolServiceImpl(RolDao rolDao) {
        this.rolDao = rolDao;
    }

    @Override
    public List<Rol> getRoles() {
        return rolDao.findAll();
    }

    @Override
    public Rol getRol(Rol rol) {
        return rolDao.findById(rol.getId()).orElse(null);
    }

    @Override
    public void save(Rol rol) {
        rolDao.save(rol);
    }

    @Override
    public void delete(Rol rol) {
        rolDao.delete(rol);
    }

    @Override
    public Rol findByNombre(String nombre) {
        return rolDao.findByNombre(nombre).orElse(null);
    }

    @Override
    public List<Rol> metodoJPQL(String filtro) {
        return rolDao.metodoJPQL(filtro);
    }

    @Override
    public List<Rol> metodoNativo(String filtro) {
        return rolDao.metodoNativo(filtro);
    }
}
