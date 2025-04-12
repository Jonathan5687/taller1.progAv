package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.vista.VistaQuiosco;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CatalogoProductos catalogo = new CatalogoProductos();
            VistaQuiosco vista  = new VistaQuiosco();
            Controlador controlador = new Controlador(vista, catalogo);
            
            vista.setVisible(true);
        });
    }
}
