/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service.impl;

import com.cine.dao.ReservaDao;
import com.cine.domain.Reserva;
import com.cine.service.ReservaService;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *
 * @author Juan
 */
@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaDao reservaDao;

    public ReservaServiceImpl(ReservaDao reservaDao) {
        this.reservaDao = reservaDao;
    }

    @Override
    public List<Reserva> getReservas() {
        return reservaDao.findAll();
    }

    @Override
    public Reserva getReserva(Reserva reserva) {
        return reservaDao.findById(reserva.getIdReserva()).orElse(null);
    }

    @Override
    public void save(Reserva reserva) {
        reservaDao.save(reserva);
    }

    @Override
    public void delete(Reserva reserva) {
        reservaDao.delete(reserva);
    }

    @Override
    public List<Reserva> findByCantidadAsientosBetweenOrderByFechaReserva(int min, int max) {
        return reservaDao.findByCantidadAsientosBetweenOrderByFechaReserva(min, max);
    }

    @Override
    public List<Reserva> metodoJPQL(int min, int max) {
        return reservaDao.metodoJPQL(min, max);
    }

    @Override
    public List<Reserva> metodoNativo(int min, int max) {
        return reservaDao.metodoNativo(min, max);
    }
}
