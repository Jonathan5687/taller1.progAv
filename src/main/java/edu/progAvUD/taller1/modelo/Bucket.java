package edu.progAvUD.taller1.modelo;

import java.util.ArrayList;
import java.util.List;
public class Bucket extends Producto {
    private List<Producto> piezas;
    
    public Bucket(String nombre, String descripcion){
        super(nombre, 0, descripcion);
        this.piezas = new ArrayList<>(); 
    }
    
    public void agregarPieza(Producto pieza){
        piezas.add(pieza ); 
    }
    
    @Override
    public double calcularPrecioFinal() {
        double total = 0; 
        for(Producto pieza : piezas){
            total += pieza.calcularPrecioFinal();
        }
        return total;
    }   
}
