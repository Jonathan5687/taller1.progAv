package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Producto;
import edu.progAvUD.taller1.vista.VistaQuiosco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {
    private VistaQuiosco vista;
    private CatalogoProductos catalogo;

    public Controlador(VistaQuiosco vista, CatalogoProductos catalogo) {
        this.vista = vista;
        this.catalogo = catalogo;
        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "INICIAR_PEDIDO":
                vista.mostrarPantallaTipoPedido();
                break;

            case "CANCELAR_PEDIDO":
                vista.mostrarPantallaInicio();
                break;

            
            case "PARA_LLEVAR":
                JOptionPane.showMessageDialog(null, "Esta opción se habilitará pronto");
                vista.mostrarPantallaInicio();
                break;
            case "PARA_MESA":
                vista.mostrarPantallaCategorias();
                break;
            default:
                if (comando.startsWith("CATEGORIA_")) {
                    String categoria = comando.substring("CATEGORIA_".length()).replace("_", " ");
                    List<Producto> productos = catalogo.obtenerProductosPorCategoria(categoria);
                    vista.mostrarPantallaCatalogoProductos(categoria, productos, this);
                } else if (comando.startsWith("PRODUCTO_")) {
                    String nombreProducto = comando.substring("PRODUCTO_".length()).replace("_", " ");
                    System.out.println("Producto seleccionado: " + nombreProducto);
                }
                break;
        }
    }
}
