/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Empleado {
    
    private int dni;
    
    private String nombre;
    
    private String correo;
    
    private Usuario usuario;
    
    private String funcion;
    
    public Empleado(int dni, String nombre, String correo,Usuario usuario, String funcion ){
        
        this.dni= dni;
        this.nombre= nombre;
        this.correo= correo;
        this.usuario = usuario;
        this.funcion= funcion;
        
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

   
    
}
