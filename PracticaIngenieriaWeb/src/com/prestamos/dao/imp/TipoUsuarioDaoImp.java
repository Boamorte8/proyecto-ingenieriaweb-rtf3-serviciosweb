/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao.imp;

import com.prestamos.dao.TipoUsuarioDao;
import com.prestamos.dto.TipoUsuario;
import com.prestamos.exception.DaoException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Juan Carlos
 */
public class TipoUsuarioDaoImp implements TipoUsuarioDao{
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insertar(TipoUsuario tipoUsuario) throws DaoException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(tipoUsuario);
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
    public TipoUsuario buscar(int codigo) throws DaoException {
        Session session = null;
        TipoUsuario tipoUsuario = null;
        try {
            session = sessionFactory.openSession();
            tipoUsuario = (TipoUsuario)session.get(TipoUsuario.class, codigo);
        } catch (ExceptionInInitializerError e) {
            throw new DaoException(e);
        } finally{
            if(session != null){
                session.close();
            }
        }
        return tipoUsuario;    
    }

    @Override
    public void actualizar(TipoUsuario tipoUsuario) throws DaoException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(tipoUsuario);
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
    public void eliminar(TipoUsuario tipoUsuario) throws DaoException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(tipoUsuario);
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
    public List<TipoUsuario> listar() throws DaoException {
        Session session = null;
        List<TipoUsuario> tipoDispositivos = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(TipoUsuario.class);
            tipoDispositivos = criteria.list();
        } catch (ExceptionInInitializerError e) {
            throw new DaoException(e);
        } finally{
            if(session != null){
                session.close();
            }
        }
        return tipoDispositivos;    
    }
    
}
