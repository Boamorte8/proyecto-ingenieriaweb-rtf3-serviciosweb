/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.exception;

import org.apache.log4j.Logger;

/**
 *
 * @author Juan Carlos
 */
public class SWException extends Exception{
    
    private static final Logger log = Logger.getLogger(DaoException.class);
    
    public SWException() {
		log.error("Ocurrio un error en el sitema");
	}

	public SWException(String arg0) {
		super(arg0);
                log.error(arg0);
	}

	public SWException(Throwable arg0) {
		super(arg0);
                log.error("Ocurrio un error en el sistema", arg0);
	}

	public SWException(String arg0, Throwable arg1) {
		super(arg0, arg1);
                log.error("Ocurrio un error en el sistema", arg1);
	}

	public SWException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
                log.error("Ocurrio un error en el sistema", arg1);
	}

}
