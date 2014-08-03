/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao;

import com.prestamos.dto.TipoUsuario;
import com.prestamos.exception.DaoException;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public interface TipoUsuarioDao {
    
    public void insertar(TipoUsuario tipoUsuario) throws DaoException;
    
    public TipoUsuario buscar(int codigo) throws DaoException;
    
    public void actualizar(TipoUsuario tipoUsuario) throws DaoException;
    
    public void eliminar(TipoUsuario tipoUsuario) throws DaoException;
    
    public List<TipoUsuario> listar() throws DaoException;
}
