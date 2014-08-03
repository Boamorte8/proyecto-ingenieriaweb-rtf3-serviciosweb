/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao.imp;

import com.prestamos.dao.DispositivoDao;
import com.prestamos.dto.Dispositivo;
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
public class DispositivoDaoImp implements DispositivoDao{
    
    private SessionFactory sessionFactory;

    @Override
    public void insertar(Dispositivo dispositivo) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(dispositivo);
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
    public Dispositivo buscar(long codigo) throws DaoException{
        Session session = null;
        Dispositivo dispositivo = null;
        try {
            session = sessionFactory.openSession();
            dispositivo = (Dispositivo)session.get(Dispositivo.class, codigo);
        } catch (ExceptionInInitializerError e) {
            throw new DaoException(e);
        } finally{
            if(session != null){
                session.close();
            }
        }
        return dispositivo;
    }

    @Override
    public void actualizar(Dispositivo dispositivo) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(dispositivo);
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
    public void eliminar(Dispositivo dispositivo) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(dispositivo);
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
    public List<Dispositivo> listar() throws DaoException{
        Session session = null;
        List<Dispositivo> dispositivos = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Dispositivo.class);
            dispositivos = criteria.list();
        } catch (ExceptionInInitializerError e) {
            throw new DaoException(e);
        } finally{
            if(session != null){
                session.close();
            }
        }
        return dispositivos;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
}
