package com.hibernate.introduction.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    // ATRIBUTOS
    @Id
    private String correo;
    private String contrasena;
    private String nombreUsuario;
    private String apellidoUsuario;
    
    //CONSTRUCTORES

    public Usuario(){}

    public Usuario(String correo, String contrasena, String nombreUsuario, String apellidoUsuario){
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
    }

    @Override
    public String toString(){
        String info = "---------------------------\n";
        info += "Correo: "+correo;
        info += "\nContraseña: "+contrasena;
        info += "\nNombre Usuario: "+nombreUsuario;
        info += "\nApellido Usuario: "+apellidoUsuario;
        info += "\n---------------------------\n";
        return info;
    }
    //CONSULTORES // GETTERS
    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    //MODIFICADORES // SETTERS

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }    
}
