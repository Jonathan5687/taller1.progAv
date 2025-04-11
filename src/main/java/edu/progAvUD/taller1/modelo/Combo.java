package edu.progAvUD.taller1.modelo;

import java.util.ArrayList;
import java.util.List; 

public class Combo extends Producto {
    private Producto bebida; 
    private Producto papas; 
    private List<Producto> adicionales;
    
    public Combo(String nombre, double precio, String descripcion, Producto bebida, Producto papas){
        super(nombre, precio, descripcion);
        this.bebida = bebida; 
        this.papas = papas; 
        this.adicionales = new ArrayList<>();
    }
    
    public void SeleccionarBebida(String Sabor){
        System.out.println("Bebida seleccionada: " + Sabor);
    }
    
    public void AgrandarProducto(String Producto){
        System.out.println("Producto agrandado: " + Producto);
    }

    @Override
    public double calcularPrecioFinal() {
        double total = precio + bebida.calcularPrecioFinal() + papas.calcularPrecioFinal();
        for(Producto adicional : adicionales){
            total += adicional.calcularPrecioFinal(); 
        }
        return total;   
    }
    
}
