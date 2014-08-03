/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao;

import com.prestamos.dto.Usuario;
import com.prestamos.dto.UsuarioId;
import com.prestamos.exception.DaoException;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public interface UsuarioDao {
    
    public void insertar(Usuario usuario) throws DaoException;
    
    public Usuario buscar(UsuarioId id) throws DaoException;
    
    public void actualizar(Usuario usuario) throws DaoException;
    
    public void eliminar(Usuario usuario) throws DaoException;
    
    public List<Usuario> listar() throws DaoException;
}
