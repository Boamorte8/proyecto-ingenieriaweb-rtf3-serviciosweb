/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao;

import com.prestamos.dto.Dispositivo;
import com.prestamos.dto.Prestamo;
import com.prestamos.dto.UsuarioId;
import com.prestamos.exception.DaoException;
import java.util.Date;
import java.util.List;

/**
 * Interface que define los metodos que va a proveer el dao de Prestamo
 * @author Juan Carlos
 */
public interface PrestamoDao {
    
    public List<Dispositivo> listarDispositivosDisponibles(Date fecha) throws DaoException;
    
    public void solicitarPrestamo(Prestamo prestamo) throws DaoException;
    
    public void actualizar(Prestamo prestamo) throws DaoException;
    
    public List<Prestamo> consultarPrestamosInvestigador(UsuarioId id) throws DaoException;
    
    public List<Prestamo> consultarPrestamosActivos() throws DaoException;
}
