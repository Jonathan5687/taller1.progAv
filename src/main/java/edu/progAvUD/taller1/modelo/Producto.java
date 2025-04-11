package edu.progAvUD.taller1.modelo;

public abstract class Producto {
    private String nombre; 
    double precio; 
    private String descripcion;
    
    public Producto(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio; 
        this.descripcion = descripcion;
    }
    
    public abstract double calcularPrecioFinal();
}
