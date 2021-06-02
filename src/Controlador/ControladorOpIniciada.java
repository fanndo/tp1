/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.OP;
import Interfaz.OpIniciada;
import Modelo.Color;
import Modelo.Datos;
import Modelo.Empleado;
import Modelo.Estado;
import Modelo.LineaDeTrabajo;
import Modelo.Modelo;
import Modelo.Turno;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControladorOpIniciada {
    
    public static ArrayList<Modelo> model = new ArrayList<Modelo>();
    public static ArrayList<Color> colores = new ArrayList<Color>();
    public static OpIniciada op = new OpIniciada();
    public static OP inicio= new OP();
    public static Datos datos = new Datos();
    public static ArrayList<LineaDeTrabajo> lineas = new ArrayList<LineaDeTrabajo>();
    public static ArrayList<Turno> turnos = new ArrayList<Turno>();
    public static Usuario usuario1;
    public static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    
     public static void mostrar(){
        
        model.clear();
        colores.clear();
        lineas.clear();
        
        String sku;
        String modelo;
        String[] colores = {};
        int i=0;
       
        model = datos.agregarCalzado();
       
        op.getTxtModelo().setEditable(false);
        op.getTxtColor().setEditable(false);
        
        op.getCbModelo().removeAllItems();
        op.getCbColor().removeAllItems(); //Remueve los items
        op.getCbLinea().removeAllItems();
        
        op.getTxtModelo().setText("");
        op.getTxtColor().setText("");
        op.getCbModelo().addItem("Modelo"); //Pone un item llamado modelo
        
        for(Modelo m: model){
            
            sku= m.getSKU();
       
           op.getCbModelo().addItem(sku);
           
            
        }
        agregarHora();
        lineasTrabajo();
        
        
        op.setLocationRelativeTo(null);
        op.setVisible(true);
      
        
    }
    
    public static String[] AgregarColores(){
         
        String modelo = (String) op.getCbModelo().getSelectedItem();
        String[] col = new String[4];
        int i=1;
        
        op.getTxtModelo().setText("");
        op.getTxtColor().setText("");
        
        for(Modelo m: model){
            if(m.getSKU().equals(modelo)){
                colores = m.getColores();
                op.getTxtModelo().setText(m.getDenominacion());
            }
        }
        col[0] = "Color";
        for(Color c:colores){
            col[i] = c.getCodigo();
            i++;
        }
        return col;
        
        
    }
    
    public static void AgregarModelo(){
         
        String codigo = (String) op.getCbColor().getSelectedItem();
        
        op.getTxtColor().setText("");
        
        for(Color c:colores){
            
            if(c.getCodigo().equals(codigo)){
                
                op.getTxtColor().setText(c.getDescripcion());
            }
        }
        
        
     }
    
      public static void lineasTrabajo(){
//        vistaIniciar.getCbLinea().setSelectedIndex(0);
        op.getCbLinea().addItem("Linea");
        lineas = datos.agregarLinea();
        for(LineaDeTrabajo l:lineas){
            op.getCbLinea().addItem(l.getNumero()+"");
        }
    }
    
      public static int hora(){
        int hora;
        Calendar calendario = new GregorianCalendar();
        Date horaActual = new Date();
        calendario.setTime(horaActual);
        hora = Integer.parseInt(calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY));
       
        return hora;
    }
    
    public static void agregarHora(){
        int hora = hora();
        int h;
        int i=0;
        int[] ho = new int[8];
        turnos = datos.agregarTurno();
        
        for(Turno t:turnos){
            if(hora >= t.getHoraInicio() && hora < t.getHoraFin()){
                h=hora;
                while(h < t.getHoraFin()){
                    ho[i] = h;
                    i++;
                    
                    h++;
                }
                agregarHorario(ho,i);
            }   
        }
    }
    
    public static void agregarHorario(int[] ho,int i){
        
        DefaultTableModel datos = (DefaultTableModel) op.getTblObjetivos().getModel();
        datos.setNumRows(0);
        
        for(int t=0;t<i;t++){
            Object[] fila = new Object[2];

            fila[0] = ho[t];
            datos.addRow(fila);
        }
    }
    
     public static boolean validarModelo(){
         
        String modelo = (String) op.getCbModelo().getSelectedItem();
        boolean validacion;
        
        if(!modelo.equals("Modelo")){
            validacion = true;
        }else{
            validacion = false;
        }
        return validacion;
    }
    
    public static boolean validarColor(){
        
        String color = (String) op.getCbColor().getSelectedItem();
        boolean validacion;
        
        if(!color.equals("Color")){
            validacion = true;
        }else{
            validacion = false;
        }
        return validacion;
    }
    
    public static boolean validarLinea(){
        
        String linea = (String) op.getCbLinea().getSelectedItem();
        boolean validacion;
        
        if(!linea.equals("Linea")){
            validacion = true;
        }else{
            validacion = false;
        }
        return validacion;
    }
    
    public static boolean validarObjetivos(){
        
        boolean validar=false;
        try{
            int fila = op.getTblObjetivos().getRowCount();
            int objetivo;
            int c=0;
           
            if(fila>0){
                for(int i=0;i<fila;i++){
                    if(!op.getTblObjetivos().getValueAt(i, 1).toString().equals("")){
                            objetivo = Integer.parseInt(op.getTblObjetivos().getValueAt(i, 1).toString());
                            if(objetivo>=0 && objetivo<=10000){
                            c++;
                        }

                    }  
                }
            }
            if(fila != 0){
                if(c==fila){
                    validar = true;
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Objetivo no valido");
        }
        return validar;
        
    }
     public static void iniciarOp(){
        
        String modelo = (String) op.getCbModelo().getSelectedItem();
        String color = (String) op.getCbColor().getSelectedItem();
        String linea1 = (String) op.getCbLinea().getSelectedItem();
        String usuario;
        int linea;
        
        Estado estado= Estado.Iniciado;
        
       
        if(validarModelo()){
            if(validarColor()){
                if(validarLinea()){
                    if(validarObjetivos()){
                        
                        for(Empleado e: empleados){
                            
                            usuario1=e.getUsuario();
                            
                        }
                       
                        linea = Integer.parseInt(op.getCbLinea().getSelectedItem().toString());
                        
                        datos.pruebaDatos();
                        
                        if(datos.verificarInicio(usuario1, linea)){
                            
                            datos.guardarDatos(usuario1, linea);
                            
                            op.dispose();
                            inicio.setLocationRelativeTo(null);
                            inicio.setVisible(true);
                        
                            inicio.getBtnIniciar().setEnabled(false);
                            inicio.getBtnPausar().setEnabled(true);
                            inicio.getBtnReanudar().setEnabled(true);
                            inicio.getBtnFinalizar().setEnabled(true);
                        
                            inicio.getTxtModelo().setEditable(false);
                            inicio.getTxtColor().setEditable(false);
                            inicio.getTxtLinea().setEditable(false);
                            inicio.getTxtEstado().setEditable(false);
                                
                            inicio.getTxtModelo().setText(modelo);
                            inicio.getTxtColor().setText(color);
                            inicio.getTxtLinea().setText(linea1);
                            inicio.getTxtEstado().setText(estado.toString());
                        
                        for(int i=0; i<op.getTblObjetivos().getRowCount(); i++){
                            
                            String datos[]= new String[2];
                            datos[0]=op.getTblObjetivos().getValueAt(i, 0).toString();
                            datos[1]=op.getTblObjetivos().getValueAt(i, 1).toString();
                            OP.modelo.addRow(datos);
                        }
                   
                        inicio.getTblObjetivos1().setEnabled(false);
                            
                        }else{
                            JOptionPane.showMessageDialog(null,"La linea o el supervisor ya esta trabajando en una OP");
                        }
                       
                    }else{
                        JOptionPane.showMessageDialog(null,"No se encuentra en horario para iniciar op");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar una linea");
                }
            }else{
            JOptionPane.showMessageDialog(null,"Debe seleccionar un color");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debe seleccionar un modelo");
        }
    }
}
