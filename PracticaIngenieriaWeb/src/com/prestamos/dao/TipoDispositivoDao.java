/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao;

import com.prestamos.dto.TipoDispositivo;
import com.prestamos.exception.DaoException;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public interface TipoDispositivoDao {
    
    public void insertar(TipoDispositivo tipoDispositivo) throws DaoException;
    
    public TipoDispositivo buscar(int codigo) throws DaoException;
    
    public void actualizar(TipoDispositivo tipoDispositivo) throws DaoException;
    
    public void eliminar(TipoDispositivo tipoDispositivo) throws DaoException;
    
    public List<TipoDispositivo> listar() throws DaoException;
}
