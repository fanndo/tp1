/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Objetivo {
    
    private int numObjetivo;
    
    private int hora;
    
    public Objetivo(int hora, int numObjetivo) {
        this.hora = hora;
        this.numObjetivo = numObjetivo;
    }

    public int getNumObjetivo() {
        return numObjetivo;
    }

    public void setNumObjetivo(int numObjetivo) {
        this.numObjetivo = numObjetivo;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
    
}
