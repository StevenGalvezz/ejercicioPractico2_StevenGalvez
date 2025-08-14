/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service.impl;

import com.cine.dao.FuncionDao;
import com.cine.domain.Funcion;
import com.cine.service.FuncionService;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *
 * @author Juan
 */

@Service
public class FuncionServiceImpl implements FuncionService {

    private final FuncionDao funcionDao;

    public FuncionServiceImpl(FuncionDao funcionDao) {
        this.funcionDao = funcionDao;
    }

    @Override
    public List<Funcion> getFunciones() {
        return funcionDao.findAll();
    }

    @Override
    public Funcion getFuncion(Funcion funcion) {
        return funcionDao.findById(funcion.getId()).orElse(null);
    }

    @Override
    public void save(Funcion funcion) {
        funcionDao.save(funcion);
    }

    @Override
    public void delete(Funcion funcion) {
        funcionDao.delete(funcion);
    }

    @Override
    public List<Funcion> findByPrecioBetweenOrderByFecha(double precioMin, double precioMax) {
        return funcionDao.findByPrecioBetweenOrderByFecha(precioMin, precioMax);
    }

    @Override
    public List<Funcion> metodoJPQL(double precioMin, double precioMax) {
        return funcionDao.metodoJPQL(precioMin, precioMax);
    }

    @Override
    public List<Funcion> metodoNativo(double precioMin, double precioMax) {
        return funcionDao.metodoNativo(precioMin, precioMax);
    }
}

