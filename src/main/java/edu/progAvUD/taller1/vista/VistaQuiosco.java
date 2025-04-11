package edu.progAvUD.taller1.vista;

import edu.progAvUD.taller1.control.Controlador;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 


public class VistaQuiosco extends JFrame{
    private JButton btnIniciarPedido; 
    private JButton btnCancelarPedido; 
   
    public VistaQuiosco(){
        this.setTitle("Kiosco de autoatención");
        this.setSize (400, 300); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        btnIniciarPedido =  new JButton("Iniciar Pedido"); 
        btnCancelarPedido = new JButton("Cancelar Pedido");
        
        this.add(btnIniciarPedido);
        this.add(btnCancelarPedido);
    }
    
    public void setControlador(Controlador controlador){
        btnIniciarPedido.addActionListener(controlador);
        btnCancelarPedido.addActionListener(controlador);
    }
    
}
