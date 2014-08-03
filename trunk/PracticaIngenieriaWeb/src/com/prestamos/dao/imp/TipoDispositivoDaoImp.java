/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao.imp;

import com.prestamos.dao.TipoDispositivoDao;
import com.prestamos.dto.TipoDispositivo;
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
public class TipoDispositivoDaoImp implements TipoDispositivoDao{
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insertar(TipoDispositivo tipoDispositivo) throws DaoException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(tipoDispositivo);
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
    public TipoDispositivo buscar(int codigo) throws DaoException {
        Session session = null;
        TipoDispositivo tipoDispositivo = null;
        try {
            session = sessionFactory.openSession();
            tipoDispositivo = (TipoDispositivo)session.get(TipoDispositivo.class, codigo);
        } catch (ExceptionInInitializerError e) {
            throw new DaoException(e);
        } finally{
            if(session != null){
                session.close();
            }
        }
        return tipoDispositivo;    
    }

    @Override
    public void actualizar(TipoDispositivo tipoDispositivo) throws DaoException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(tipoDispositivo);
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
    public void eliminar(TipoDispositivo tipoDispositivo) throws DaoException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(tipoDispositivo);
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
    public List<TipoDispositivo> listar() throws DaoException {
        Session session = null;
        List<TipoDispositivo> tipoDispositivos = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(TipoDispositivo.class);
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
