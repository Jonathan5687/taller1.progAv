package edu.progAvUD.taller1.modelo;

import java.util.List;

public class Combo extends Producto {
    private List<Producto> adicionales;

    public Combo(String nombre, String categoria, double precioBase, List<Producto> adicionales) {
        super(nombre, categoria, precioBase);
        this.adicionales = adicionales;
    }

    @Override
    public double calcularPrecioFinal() {
        double total = this.precio;
        for (Producto adicional : adicionales) {
            total += adicional.calcularPrecioFinal();
        }
        return total;
    }

    public List<Producto> getAdicionales() {
        return adicionales;
    }
}