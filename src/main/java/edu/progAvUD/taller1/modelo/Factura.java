package edu.progAvUD.taller1.modelo;

import java.util.List;

public class Factura {
    private Usuario usuario;
    private List<Producto> productos;
    private double totalConDescuento;

    public Factura(Usuario usuario, List<Producto> productos, double totalConDescuento) {
        this.usuario = usuario;
        this.productos = productos;
        this.totalConDescuento = totalConDescuento;
    }

    public String generarTextoFactura() {
        StringBuilder sb = new StringBuilder();
        sb.append("----- FACTURA -----\n");
        sb.append("Cliente: ").append(usuario.getNombre()).append("\n");
        sb.append("Cédula: ").append(usuario.getCedula()).append("\n");
        sb.append("Edad: ").append(usuario.getEdad()).append("\n");
        sb.append("¿Indígena?: ").append(usuario.isEsIndigena() ? "Sí" : "No").append("\n\n");

        sb.append("Productos:\n");
        for (Producto producto : productos) {
            sb.append("- ").append(producto.getNombre()).append(" ($").append(producto.getPrecio()).append(")\n");
        }

        sb.append("\nTotal a pagar (con descuento): $").append(totalConDescuento).append("\n");
        sb.append("--------------------");

        return sb.toString();
    }
}

