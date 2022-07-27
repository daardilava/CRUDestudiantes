/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author diego
 */
public class Estudiante {
    private int code;
    private String tipoID;
    private int numeroID;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;
    private String movil;
    private String email;

   // constructor vacio 
    public Estudiante() {
    
    }

    //constructor agregar
    public Estudiante(String tipoID, int numeroID, String nombre, String apellido, String usuario, String contraseña, String movil, String email) {
        this.tipoID = tipoID;
        this.numeroID = numeroID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.movil = movil;
        this.email = email;
    }
    
// constructor actualizar    
    
    public Estudiante(int code, String tipoID, int numeroID, String nombre, String apellido, String usuario, String contraseña, String movil, String email) {
        this.code = code;
        this.tipoID = tipoID;
        this.numeroID = numeroID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.movil = movil;
        this.email = email;
    }
    
 // getter y setter

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTipoID() {
        return tipoID;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    public int getNumeroID() {
        return numeroID;
    }

    public void setNumeroID(int numeroID) {
        this.numeroID = numeroID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
} //fin de la clase estudiante
