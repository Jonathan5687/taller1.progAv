package edu.progAvUD.taller1.vista;

import edu.progAvUD.taller1.control.Controlador;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaQuiosco extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Paneles principales
    private JPanel pantallaInicio;
    private JPanel panelTipoPedido;
    private JPanel panelCategorias;

    // Botones pantalla inicio
    private JButton btnIniciarPedido;
    private JButton btnCancelarPedido;

    // Botones tipo de pedido
    private JButton btnParaMesa;
    private JButton btnParaLlevar;

    // Panel para las categorías
    private JButton[] botonesCategorias;

    public VistaQuiosco() {
        setTitle("Kiosco de autoatención");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        inicializarPantallaInicio();
        inicializarPanelTipoPedido();
        inicializarPanelCategorias();

        add(mainPanel);
        setLocationRelativeTo(null); // Centrar ventana
    }

    private void inicializarPantallaInicio() {
        pantallaInicio = new JPanel(new FlowLayout());
        btnIniciarPedido = new JButton("Iniciar Pedido");
        btnCancelarPedido = new JButton("Cancelar Pedido");
        pantallaInicio.add(btnIniciarPedido);
        pantallaInicio.add(btnCancelarPedido);
        mainPanel.add(pantallaInicio, "INICIO");
    }

    private void inicializarPanelTipoPedido() {
        panelTipoPedido = new JPanel(new GridLayout(2, 1, 10, 10));
        btnParaMesa = new JButton("Para Mesa");
        btnParaLlevar = new JButton("Para Llevar");
        panelTipoPedido.add(btnParaMesa);
        panelTipoPedido.add(btnParaLlevar);
        mainPanel.add(panelTipoPedido, "TIPO_PEDIDO");
    }

    private void inicializarPanelCategorias() {
        String[] categorias = {
            "Buckets", "Para Compartir", "Wraps", "Alitas", "Nuggets", "Hamburguesas", "Combos"
        };

        panelCategorias = new JPanel(new GridLayout(0, 2, 10, 10));
        botonesCategorias = new JButton[categorias.length];

        for (int i = 0; i < categorias.length; i++) {
            botonesCategorias[i] = new JButton(categorias[i]);
            panelCategorias.add(botonesCategorias[i]);
        }

        mainPanel.add(panelCategorias, "CATEGORIAS");
    }

    public void setControlador(Controlador controlador) {
        btnIniciarPedido.addActionListener(controlador);
        btnIniciarPedido.setActionCommand("INICIAR_PEDIDO");
        btnCancelarPedido.addActionListener(controlador);
        btnCancelarPedido.setActionCommand("CANCELAR_PEDIDO");
        btnParaMesa.addActionListener(controlador);
        btnParaMesa.setActionCommand("PARA_MESA");
        btnParaLlevar.addActionListener(controlador);
        btnParaLlevar.setActionCommand("PARA_LLEVAR");

        for (JButton botonCategoria : botonesCategorias) {
            botonCategoria.addActionListener(controlador);
            botonCategoria.setActionCommand("CATEGORIA_" + botonCategoria.getText().toUpperCase().replace(" ", "_"));
        }
    }

    // Métodos para cambiar de pantalla
    public void mostrarPantallaInicio() {
        cardLayout.show(mainPanel, "INICIO");
    }

    public void mostrarPantallaTipoPedido() {
        cardLayout.show(mainPanel, "TIPO_PEDIDO");
    }

    public void mostrarPantallaCategorias() {
        cardLayout.show(mainPanel, "CATEGORIAS");
    }

    public JButton getBtnParaMesa() {
        return btnParaMesa;
    }

    public JButton getBtnParaLlevar() {
        return btnParaLlevar;
    }

    public JButton[] getBotonesCategorias() {
        return botonesCategorias;
    }

    public JButton getBtnIniciarPedido() {
        return btnIniciarPedido;
    }

    public JButton getBtnCancelarPedido() {
        return btnCancelarPedido;
    }
}