/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service.impl;

import com.cine.dao.PeliculaDao;
import com.cine.domain.Pelicula;
import com.cine.service.PeliculaService;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *
 * @author Juan
 */

@Service
public class PeliculaServiceImpl implements PeliculaService {

    private final PeliculaDao peliculaDao;

    public PeliculaServiceImpl(PeliculaDao peliculaDao) {
        this.peliculaDao = peliculaDao;
    }

    @Override
    public List<Pelicula> getPeliculas(boolean activo) {
        return peliculaDao.findByActivo(activo);
    }

    @Override
    public Pelicula getPelicula(Pelicula pelicula) {
        return peliculaDao.findById(pelicula.getId()).orElse(null);
    }

    @Override
    public void save(Pelicula pelicula) {
        peliculaDao.save(pelicula);
    }

    @Override
    public void delete(Pelicula pelicula) {
        peliculaDao.delete(pelicula);
    }

    @Override
    public List<Pelicula> findByDuracionBetweenOrderByTitulo(int duracionMin, int duracionMax) {
        return peliculaDao.findByDuracionBetweenOrderByTitulo(duracionMin, duracionMax);
    }

    @Override
    public List<Pelicula> metodoJPQL(int duracionMin, int duracionMax) {
        return peliculaDao.metodoJPQL(duracionMin, duracionMax);
    }

    @Override
    public List<Pelicula> metodoNativo(int duracionMin, int duracionMax) {
        return peliculaDao.metodoNativo(duracionMin, duracionMax);
    }
}

