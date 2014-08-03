/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao.imp;

import com.prestamos.dao.UsuarioDao;
import com.prestamos.dto.Usuario;
import com.prestamos.dto.UsuarioId;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import com.prestamos.exception.DaoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public class UsuarioDaoImp implements UsuarioDao{
    
    private SessionFactory sessionFactory;

    @Override
    public void insertar(Usuario usuario) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();//EXITO
        } catch (HibernateException e) {
            if(transaction != null){
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{
            if(session != null){
                session.close();
            }
        }
        
    }

    @Override
    public Usuario buscar(UsuarioId id) throws DaoException{
          Session session = null;
        Usuario usuario = null;
        try {
            session = sessionFactory.openSession();
            usuario = (Usuario)session.get(Usuario.class, id);
        } catch (ExceptionInInitializerError e) {
            throw new DaoException(e);
        } finally{
            if(session != null){
                session.close();
            }
        }
        return usuario;
    }

    @Override
    public void actualizar(Usuario usuario) throws DaoException{
         Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();//EXITO
        } catch (HibernateException e) {
            if(transaction != null){
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void eliminar(Usuario usuario) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(usuario);
            transaction.commit();//EXITO
        } catch (HibernateException e) {
            if(transaction != null){
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public List<Usuario> listar() throws DaoException{
        Session session = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Usuario.class);
            usuarios = criteria.list();
        } catch (ExceptionInInitializerError e) {
            throw new DaoException(e);
        } finally{
            if(session != null){
                session.close();
            }
        }
        return usuarios;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
}
