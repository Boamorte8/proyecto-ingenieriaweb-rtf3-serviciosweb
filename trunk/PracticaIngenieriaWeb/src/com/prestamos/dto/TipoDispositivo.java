package com.prestamos.dto;
// Generated 17/07/2014 03:01:05 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * TipoDispositivo generated by hbm2java
 */
public class TipoDispositivo  implements java.io.Serializable {


     private Integer codigo;
     private String tipo;
     private Set dispositivos = new HashSet(0);

    public TipoDispositivo() {
    }

	
    public TipoDispositivo(String tipo) {
        this.tipo = tipo;
    }
    public TipoDispositivo(String tipo, Set dispositivos) {
       this.tipo = tipo;
       this.dispositivos = dispositivos;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Set getDispositivos() {
        return this.dispositivos;
    }
    
    public void setDispositivos(Set dispositivos) {
        this.dispositivos = dispositivos;
    }




}


