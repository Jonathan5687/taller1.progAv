package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Pedido;
import edu.progAvUD.taller1.vista.VistaQuiosco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class Controlador implements ActionListener {
    private Pedido pedido; 
    private VistaQuiosco vista;
    
    public Controlador(Pedido pedido, VistaQuiosco vista){
        this.pedido = pedido; 
        this.vista = vista; 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("iniciar pedido")){
            System.out.println("Pedido iniciado...");
        }
        else if (comando.equals("cancelar pedido...")){
            System.out.println("Pedido cancelado...");
        }
    }
    
}
