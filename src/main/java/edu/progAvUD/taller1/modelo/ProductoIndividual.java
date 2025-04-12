package edu.progAvUD.taller1.modelo;

public class ProductoIndividual extends Producto{
    private int puntos;
    
    public ProductoIndividual (String nombre, double precio, String descripcion, int puntos){
        super(nombre, precio, descripcion);
        this.puntos = puntos; 
        
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio();
    }
    public int getPuntos(){
        return puntos; 
    }
    
}
