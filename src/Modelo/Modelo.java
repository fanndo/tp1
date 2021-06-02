/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;


public class Modelo {
    
    public static ArrayList<Color> colores = new ArrayList<Color>();
    
    private String SKU;
    
    private String denominacion;
    
    public Modelo(String SKU, String denominacion, ArrayList<Color> colores) {
    
        this.SKU = SKU;
        this.denominacion = denominacion;
        this.colores = colores;
  
    }

    public static ArrayList<Color> getColores() {
        return colores;
    }

    public static void setColores(ArrayList<Color> colores) {
        Modelo.colores = colores;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    
    
}
