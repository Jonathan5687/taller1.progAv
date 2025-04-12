package edu.progAvUD.taller1.modelo;

public class Producto {
    protected String nombre;
    protected String categoria;
    protected double precio;

    public Producto(String nombre, String categoria, double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    // Permite personalizar el cálculo en subclases como Combo o Bucket
    public double calcularPrecioFinal() {
        return precio;
    }
}

