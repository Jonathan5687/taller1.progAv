package edu.progAvUD.taller1.modelo;

public class Bucket extends Producto {

    public Bucket(String nombre, String categoria, double precio) {
        super(nombre, categoria, precio);
    }

    @Override
    public double calcularPrecioFinal() {
        return this.precio;
    }
}