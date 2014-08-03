package com.prestamos.dto;
// Generated 17/07/2014 03:01:05 PM by Hibernate Tools 3.6.0



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private UsuarioId id;
     private TipoUsuario tipoUsuario;
     private String nombres;
     private String apellidos;
     private String correo;
     private String estado;

    public Usuario() {
    }

    public Usuario(UsuarioId id, TipoUsuario tipoUsuario, String nombres, String apellidos, String correo, String estado) {
       this.id = id;
       this.tipoUsuario = tipoUsuario;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.correo = correo;
       this.estado = estado;
    }
   
    public UsuarioId getId() {
        return this.id;
    }
    
    public void setId(UsuarioId id) {
        this.id = id;
    }
    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }
    
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


