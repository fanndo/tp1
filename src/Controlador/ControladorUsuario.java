/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.IniciarSesion;
import Interfaz.OP;
import Modelo.Datos;
import Modelo.Empleado;
import Modelo.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ControladorUsuario {
    
    public static Datos datos = new Datos();
    public static IniciarSesion IniSesion = new IniciarSesion();
    public static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    public static Usuario usuario1;
    public static OP op= new OP();
          
    
    public static boolean AutenticarUsuario(String usuario, String contraseña){
        
      empleados = datos.agregarEmpleado();
      Boolean b=false;
      
        for(Empleado e:empleados){
            
            if(e.getFuncion().equals("Supervisor Linea")){
                
                usuario1 = e.getUsuario(); //Le da todos los datos del usuario
                
                if(usuario.equals(usuario1.getUsuario()) && contraseña.equals(usuario1.getContraseña())){
                      
                    
                    op.getTblObjetivos1().setEnabled(false);
                    
                    op.setVisible(true);
                    op.setLocationRelativeTo(null);
                    
                    op.getBtnPausar().setEnabled(false);
                    op.getBtnReanudar().setEnabled(false);
                    op.getBtnFinalizar().setEnabled(false);
                    
                    op.getTxtModelo().setEditable(false);
                    op.getTxtColor().setEditable(false);
                    op.getTxtLinea().setEditable(false);
                    op.getTxtEstado().setEditable(false);
                    
                    b=true;
                   
                    
                }else{
                    
                   JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos");
                }     
            }else{ 
                
                JOptionPane.showMessageDialog(null,"Necesita ser un supervisor de linea para ingresar");
                
            }
                
        }
                    
           return b;     
    }

    public static void CerrarSesion(){
        
        op.setVisible(false);
        IniSesion.setLocationRelativeTo(null);
        IniSesion.setVisible(true);
        
    }
    
}
