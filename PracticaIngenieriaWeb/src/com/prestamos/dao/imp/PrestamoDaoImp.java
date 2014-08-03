/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao.imp;

import com.prestamos.dao.PrestamoDao;
import com.prestamos.dto.Dispositivo;
import com.prestamos.dto.Prestamo;
import com.prestamos.dto.UsuarioId;
import com.prestamos.exception.DaoException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Juan Carlos
 */
public class PrestamoDaoImp implements PrestamoDao{

    private SessionFactory sessionFactory;
    
    @Override
    public List<Dispositivo> listarDispositivosDisponibles(Date fecha) throws DaoException{
        Session session = null;
        List<Dispositivo> lista;
        try {
            session = sessionFactory.openSession();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            lista = session.createSQLQuery("SELECT * FROM dispositivo d, "
                    + "tipo_dispositivo t WHERE (d.codigo NOT IN "
                    + "(SELECT dispositivo FROM prestamo WHERE  ("
                    + "'"+formater.format(fecha)+"' BETWEEN fecha_inicio AND fecha_fin)"
                    + " AND (estado =  'activo' OR estado =  'aprobado'))) "
                    + "AND d.tipo = t.codigo").list();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }finally{
            if(session != null){
                session.close();
            }
        }
        return lista;
    }

    @Override
    public void solicitarPrestamo(Prestamo prestamo) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(prestamo);
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
    public void actualizar(Prestamo prestamo) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(prestamo);
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
    public List<Prestamo> consultarPrestamosInvestigador(UsuarioId id) throws DaoException{
        Session session = null;
        List<Prestamo> lista = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("FROM Prestamo WHERE investigador.id = :id");
            query.setParameter("id", id);
            lista = query.list();
        } catch (HibernateException e) {
            throw new DaoException(e);
        } finally{
            if(session != null){
                session.close();
            }
        }
        return lista;
    }

    @Override
    public List<Prestamo> consultarPrestamosActivos() throws DaoException{
        Session session = null;
        List<Prestamo> lista;
        try {
            session = sessionFactory.openSession();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fecha = new Date();
            lista = session.createQuery("FROM Prestamo WHERE ('"+formater.format(fecha)+"' between fechaInicio "
                    + "and fechaFin) and (estado = 'activo' or estado = 'aprobado')").list();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }finally{
            if(session != null){
                session.close();
            }
        }
        return lista;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
