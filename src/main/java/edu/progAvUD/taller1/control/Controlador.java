package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Pedido;
import edu.progAvUD.taller1.vista.VistaQuiosco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JOptionPane;

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
        switch (comando) {
        case "INICIAR_PEDIDO":
            vista.mostrarPantallaTipoPedido();
            break;

        case "CANCELAR_PEDIDO":
            vista.mostrarPantallaInicio(); // O puedes hacer algo más
            break;

        case "PARA_LLEVAR":
            JOptionPane.showMessageDialog(vista, "Pronto habilitaremos esta función", "Info", JOptionPane.INFORMATION_MESSAGE);
            vista.mostrarPantallaInicio();
            break;

        case "PARA_MESA":
            vista.mostrarPantallaCategorias();
            break;

        default:
            if (comando.startsWith("CATEGORIA_")) {
                String categoria = comando.replace("CATEGORIA_", "");
                JOptionPane.showMessageDialog(vista, "Seleccionaste la categoría: " + categoria);
                // Aquí luego se muestra el catálogo
            }
            break;
    }
    }
    
}
