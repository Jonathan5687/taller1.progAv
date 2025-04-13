package edu.progAvUD.taller1.vista;

import edu.progAvUD.taller1.modelo.Factura;
import edu.progAvUD.taller1.modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaQuiosco extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    
    private JPanel panelInicio;
    private JPanel panelTipoPedido;
    private JPanel panelCategorias;
    private JPanel panelCatalogoProductos;
    private JPanel panelUsuario;
    private JPanel panelPago;

    public JTextField txtCedula, txtNombre, txtEdad;
    public JCheckBox chkIndigena;
    public JButton btnConfirmarUsuario, btnPagarCaja, btnPagarTarjeta;

    public VistaQuiosco() {
        setTitle("Quiosco de Autoservicio");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        inicializarPantallas();
        getContentPane().add(mainPanel);

        setVisible(true);
    }

    private void inicializarPantallas() {
        inicializarPantallaInicio();
        inicializarPanelTipoPedido();
        inicializarPanelCategorias();
        inicializarPanelCatalogo();
        inicializarPanelUsuario();
        inicializarPanelPago();
    }

    private void inicializarPantallaInicio() {
        panelInicio = new JPanel(new BorderLayout());
        JButton btnIniciar = new JButton("Iniciar Pedido");
        btnIniciar.setActionCommand("INICIAR_PEDIDO");
        panelInicio.add(btnIniciar, BorderLayout.CENTER);
        mainPanel.add(panelInicio, "INICIO");
    }

    private void inicializarPanelTipoPedido() {
        panelTipoPedido = new JPanel();
        JButton btnMesa = new JButton("Para Mesa");
        JButton btnLlevar = new JButton("Para Llevar");
        JButton btnCancelar = new JButton("Cancelar");

        btnMesa.setActionCommand("PARA_MESA");
        btnLlevar.setActionCommand("PARA_LLEVAR");
        btnCancelar.setActionCommand("CANCELAR_PEDIDO");

        panelTipoPedido.add(btnMesa);
        panelTipoPedido.add(btnLlevar);
        panelTipoPedido.add(btnCancelar);
        mainPanel.add(panelTipoPedido, "TIPO_PEDIDO");
    }

    private void inicializarPanelCategorias() {
        panelCategorias = new JPanel();
        String[] categorias = {"Combos", "Alitas", "Nuggets", "Papas", "Wraps", "Hamburguesas"};
        for (String cat : categorias) {
            JButton btnCategoria = new JButton(cat);
            btnCategoria.setActionCommand("CATEGORIA_" + cat.toUpperCase().replace(" ", "_"));
            panelCategorias.add(btnCategoria);
        }
        mainPanel.add(panelCategorias, "CATEGORIAS");
    }

    private void inicializarPanelCatalogo() {
        panelCatalogoProductos = new JPanel(new GridLayout(0, 3, 10, 10));
        mainPanel.add(new JScrollPane(panelCatalogoProductos), "CATALOGO_PRODUCTOS");
    }

    public void mostrarPantallaCatalogoProductos(String categoria, List<Producto> productos, ActionListener listener) {
        panelCatalogoProductos.removeAll();
        for (Producto producto : productos) {
            JButton botonProducto = new JButton("<html><center>" + producto.getNombre() + "<br>$" + producto.getPrecio() + "</center></html>");
            botonProducto.setActionCommand("PRODUCTO_" + producto.getNombre().toUpperCase().replace(" ", "_"));
            botonProducto.addActionListener(listener);
            panelCatalogoProductos.add(botonProducto);
        }
        panelCatalogoProductos.revalidate();
        panelCatalogoProductos.repaint();
        cardLayout.show(mainPanel, "CATALOGO_PRODUCTOS");
    }

    private void inicializarPanelUsuario() {
        panelUsuario = new JPanel(new GridLayout(5, 2));
        txtNombre = new JTextField();
        txtCedula = new JTextField();
        txtEdad = new JTextField();
        chkIndigena = new JCheckBox("¿Es indígena?");

        btnConfirmarUsuario = new JButton("Confirmar Datos");
        btnConfirmarUsuario.setActionCommand("CONFIRMAR_USUARIO");

        panelUsuario.add(new JLabel("Nombre:"));
        panelUsuario.add(txtNombre);
        panelUsuario.add(new JLabel("Cédula:"));
        panelUsuario.add(txtCedula);
        panelUsuario.add(new JLabel("Edad:"));
        panelUsuario.add(txtEdad);
        panelUsuario.add(chkIndigena);
        panelUsuario.add(new JLabel(""));
        panelUsuario.add(btnConfirmarUsuario);

        mainPanel.add(panelUsuario, "USUARIO");
    }

    private void inicializarPanelPago() {
        panelPago = new JPanel();
        btnPagarCaja = new JButton("Pagar en Caja");
        btnPagarTarjeta = new JButton("Pagar con Tarjeta");

        btnPagarCaja.setActionCommand("PAGAR_CAJA");
        btnPagarTarjeta.setActionCommand("PAGAR_TARJETA");

        panelPago.add(btnPagarCaja);
        panelPago.add(btnPagarTarjeta);

        mainPanel.add(panelPago, "PAGO");
    }

    public void setControlador(ActionListener controlador) {
        for (Component c : panelInicio.getComponents()) if (c instanceof JButton) ((JButton) c).addActionListener(controlador);
        for (Component c : panelTipoPedido.getComponents()) if (c instanceof JButton) ((JButton) c).addActionListener(controlador);
        for (Component c : panelCategorias.getComponents()) if (c instanceof JButton) ((JButton) c).addActionListener(controlador);
        btnConfirmarUsuario.addActionListener(controlador);
        btnPagarCaja.addActionListener(controlador);
        btnPagarTarjeta.addActionListener(controlador);
    }

    public void mostrarPantallaInicio() {
        cardLayout.show(mainPanel, "INICIO");
    }

    public void mostrarPantallaTipoPedido() {
        cardLayout.show(mainPanel, "TIPO_PEDIDO");
    }

    public void mostrarPantallaCategorias() {
        cardLayout.show(mainPanel, "CATEGORIAS");
    }

    public void mostrarPantallaUsuario(Producto productoSeleccionado) {
        cardLayout.show(mainPanel, "USUARIO");
    }

    public void mostrarPantallaPago() {
        cardLayout.show(mainPanel, "PAGO");
    }

    public void mostrarFactura(Factura factura) {
        JTextArea areaFactura = new JTextArea(factura.generarTextoFactura());
        areaFactura.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(areaFactura), "Factura", JOptionPane.INFORMATION_MESSAGE);
        mostrarPantallaInicio();
    }
}
