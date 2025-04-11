package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Pedido;
import edu.progAvUD.taller1.vista.VistaQuiosco;


public class Main {
    public static void main(String[] args){
        Pedido pedido = new Pedido(); 
        VistaQuiosco vista = new VistaQuiosco(); 
        Controlador controlador = new Controlador(pedido, vista); 
        
        vista.setControlador(controlador);
        vista.setVisible(true);
    }
    
}
