/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.services;

import com.prestamos.dao.PrestamoDao;
import com.prestamos.exception.DaoException;
import com.prestamos.exception.SWException;
import com.prestamos.dto.Dispositivo;
import com.prestamos.dto.Prestamo;

import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
@Component
@Path("/PrestamoSW")
public class PrestamoSW {
    
    private PrestamoDao prestamoDao;
    
    /**
     * Metodo que presta el servicio web de listar todos los dispositivos disponibles
     * @param fecha es la fecha en la cual los dispositivos que se mostraran estaran disponibles
     * @return una lista con los dispositivos disponibles
     * @throws SWException 
     */
    @GET
    @Path("/disponibles/{fecha}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dispositivo> listarDispositivosDisponibles(@PathParam("fecha") String fecha) throws SWException{
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        try {
            Date date = formater.parse(fecha);
            return prestamoDao.listarDispositivosDisponibles(date);
        } catch (DaoException | ParseException e) {
            throw new SWException(e);
        }
    }
    
    /**
     * Metodo  que envia una solicitud de prestamo
     * @param prestamo un objeto de la clase prestamo que contiene los datos del prestamos a solicitar
     * @throws SWException 
     */
    @PUT
    @Path("/solicitud")
    @Consumes(MediaType.APPLICATION_JSON)
    public void solicitarPrestamo(@WebParam(name = "prestamo") Prestamo prestamo) throws SWException{
        try {
            prestamoDao.solicitarPrestamo(prestamo);
        } catch (DaoException ex) {
            throw new SWException(ex);
        }
    }
    
    /**
     * Metodo con el cual se actualiza los datos de un parametro
     * @param prestamo es el nombre del metodo a actualizar
     * @throws SWException
     */
    @PUT
    @Path("/respondersolicitud")
    @Consumes(MediaType.APPLICATION_JSON)
    public void actualizarPrestamo(@WebParam(name = "prestamo") Prestamo prestamo) throws SWException{
        try {
            prestamoDao.actualizar(prestamo);
        } catch (DaoException ex) {
            throw new SWException(ex);
        }
    }

    public void setPrestamoDao(PrestamoDao prestamoDao) {
        this.prestamoDao = prestamoDao;
    }
    
    
}
