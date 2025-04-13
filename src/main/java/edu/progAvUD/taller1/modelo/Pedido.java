package edu.progAvUD.taller1.modelo;

import java.util.ArrayList;
import java.util.List; 

public class Pedido {
    private List<Producto> productos; 
    private Pago metodoPago;
    
    public Pedido(){
        this.productos = new ArrayList<>();
    }
    public void agregarProducto(Producto producto){
        productos.add(producto);
    }
    public double calcularTotal(){
        return productos.stream().mapToDouble(Producto::calcularPrecioFinal).sum();
    }
    public double calcularDescuento(Usuario usuario){
        double total = calcularTotal(); 
        if (usuario.getEdad()>= 60){
            total *= 0.90;  //10% de descuento a personas de la tercera edad
        }
        if (usuario.isEsIndigena()){
            total *= 0.92; //8% de descuento adicional para indigenas
        }
        return total; 
    }
    
    public void limpiarPedido() {
        productos.clear();
    }

    public List<Producto> getProductos() {
        return productos;
    }
}