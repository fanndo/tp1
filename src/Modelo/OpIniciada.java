/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class OpIniciada {
   
    private Usuario usuario;
    
   private int linea;
   

    public OpIniciada(Usuario usuario, int linea) {
       
        this.usuario = usuario;
        this.linea = linea;
        
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}