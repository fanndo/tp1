/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

public class Datos {
    
    public static ArrayList<Modelo> modelo = new ArrayList<Modelo>();
    public static ArrayList<Color> c1 = new ArrayList<Color>();
    public static ArrayList<Color> c2 = new ArrayList<Color>();
    public static ArrayList<Color> c3 = new ArrayList<Color>();
    public static ArrayList<LineaDeTrabajo> lineas = new ArrayList<LineaDeTrabajo>();
    public static ArrayList<Turno> turnos = new ArrayList<Turno>();
    public static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    public static ArrayList<OpIniciada> opIniciada = new ArrayList<OpIniciada>();
    public static Usuario u1 = new Usuario("admin","admin");
    public static Usuario u2 = new Usuario("gab","123");
    //public static Usuario u3 = new Usuario("easy","abc");
    
    
      public ArrayList<Modelo> agregarCalzado(){
          
        modelo.clear();
        c1.clear();
        c2.clear();
        c3.clear();
        
        c1.add(new Color("B56", "Morado,Celeste,Verde"));
        c1.add(new Color("B25", "Celeste,Azul"));
        c1.add(new Color("B78", "Negro,Blanco"));
        
        c2.add(new Color("AAA", "Rojo"));
        c2.add(new Color("BBB", "Amarillo"));
        c2.add(new Color("B78", "Negro"));
        
        c3.add(new Color("JKA", "Naranja"));
        c3.add(new Color("RTS", "Rojo,Negro"));
        c3.add(new Color("CLA", "Blanco"));
        
        
        modelo.add(new Modelo("ABC1","Air Max",c1));
        modelo.add(new Modelo("ATR2","Revolution",c2));
        modelo.add(new Modelo("ZAR3","STREET",c3));
        
        return modelo;
    }
    
    public ArrayList<LineaDeTrabajo> agregarLinea(){
        
        lineas.clear();
        
        lineas.add(new LineaDeTrabajo(1));
        lineas.add(new LineaDeTrabajo(2));
        lineas.add(new LineaDeTrabajo(3));
        lineas.add(new LineaDeTrabajo(4));
        lineas.add(new LineaDeTrabajo(5));
        lineas.add(new LineaDeTrabajo(6));
        lineas.add(new LineaDeTrabajo(7));
        lineas.add(new LineaDeTrabajo(8));
        lineas.add(new LineaDeTrabajo(9));
        lineas.add(new LineaDeTrabajo(10));
        
        return lineas;
    }
    
    public ArrayList<Turno> agregarTurno(){
        
        turnos.clear();
        
        turnos.add(new Turno(6,15));
        turnos.add(new Turno(15,24));
        
        return turnos;
    }
    

    public ArrayList<Empleado> agregarEmpleado(){
        
        empleados.clear();
        
       
        empleados.add(new Empleado(42372605, "Gabriel Lazo", "gabriel@gmail.com",u1, "Supervisor Linea"));
        //empleados.add(new Empleado(40392210,"Agullo Ezequiel", "Agullo@gmail.com",u2, "Supervisor Calidad"));
        //empleados.add(new Empleado(32134051,"Raul Juarez","Raul@gmail.com",u3,"Supervisor Linea"));
        
        return empleados;
    }
    

     public void pruebaDatos(){
        
        opIniciada.add(new OpIniciada(u2, 2));
    }
    public void guardarDatos(Usuario usuario, int linea){
        //System.out.println(usuario +"         " + linea);
        opIniciada.add(new OpIniciada(usuario, linea));
    }
    public boolean verificarInicio(Usuario usuario, int linea){
        boolean validar = true;
        for(OpIniciada s: opIniciada){
            System.out.println(s.getUsuario()+"////////////");
            System.out.println(usuario+"sssssssss");
            
            System.out.println(s.getLinea()+"////////");
            System.out.println(linea);
            
            if(s.getUsuario().equals(usuario) || s.getLinea() == linea){
                validar=false;
            }
        }
        return validar;
    }
    
}
