package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.*;
import edu.progAvUD.taller1.vista.VistaQuiosco;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controlador implements ActionListener {
    private VistaQuiosco vista;
    private CatalogoProductos catalogo;
    private Producto productoSeleccionado;
    private Usuario usuario;
    private Pedido pedido;
    private double totalConDescuento;

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

            case "PARA_MESA":
                vista.mostrarPantallaCategorias();
                break;

            case "PARA_LLEVAR":
                JOptionPane.showMessageDialog(null, "Esta opción estará disponible pronto.");
                vista.mostrarPantallaInicio();
                break;

            case "CONFIRMAR_USUARIO":
                try {
                    String cedula = vista.txtCedula.getText();
                    String nombre = vista.txtNombre.getText();
                    int edad = Integer.parseInt(vista.txtEdad.getText());
                    boolean esIndigena = vista.chkIndigena.isSelected();

                    this.usuario = new Usuario(cedula, nombre, edad, esIndigena);
                    this.pedido = new Pedido();
                    pedido.agregarProducto(productoSeleccionado);
                    this.totalConDescuento = pedido.calcularDescuento(usuario);

                    JOptionPane.showMessageDialog(null, "Total con descuento: $" + totalConDescuento);
                    vista.mostrarPantallaPago();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese una edad válida.");
                }
                break;

            case "PAGAR_CAJA":
                Factura facturaCaja = new Factura(usuario, pedido.getProductos(), totalConDescuento);
                vista.mostrarFactura(facturaCaja);
                break;

            case "PAGAR_TARJETA":
                PagoTarjeta pagoTarjeta = new PagoTarjeta(new Datafono());
                boolean aprobado = pagoTarjeta.procesarPago(productoSeleccionado.getPrecio());
                if (aprobado) {
                    JOptionPane.showMessageDialog(null, "Pago aprobado con tarjeta");
                } else {
                    JOptionPane.showMessageDialog(null, "Pago rechazado");
                }
                break;

            default:
                if (comando.startsWith("CATEGORIA_")) {
                    String categoria = comando.substring("CATEGORIA_".length()).replace("_", " ");
                    List<Producto> productos = catalogo.obtenerProductosPorCategoria(categoria);
                    vista.mostrarPantallaCatalogoProductos(categoria, productos, this);
                } else if (comando.startsWith("PRODUCTO_")) {
                    String nombreProducto = comando.substring("PRODUCTO_".length()).replace("_", " ");
                    System.out.println("Buscando producto con nombre: " + nombreProducto);

                    List<Producto> todosLosProductos = catalogo.obtenerTodosLosProductos();
                    productoSeleccionado = todosLosProductos.stream()
                            .filter(p -> p.getNombre().equalsIgnoreCase(nombreProducto))
                            .findFirst().orElse(null);

                    if (productoSeleccionado != null){
                        this.pedido = new Pedido();
                        this.pedido.agregarProducto(productoSeleccionado);
                        vista.mostrarPantallaUsuario(productoSeleccionado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado");
                    }
                }
                break;
        }
    }
}

