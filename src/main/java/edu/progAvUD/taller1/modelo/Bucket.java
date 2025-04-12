package edu.progAvUD.taller1.modelo;

import java.util.HashMap;
import java.util.Map;

public class Bucket extends Producto {
    private Map<ProductoIndividual, Integer> productos;

    public Bucket(String nombre, String descripcion) {
        super(nombre, 0, descripcion);
        this.productos = new HashMap<>();
    }

    public boolean agregarProducto(ProductoIndividual producto, int cantidad) {
        if (cantidad <= 0 || cantidad > 5) return false;

        int actual = productos.getOrDefault(producto, 0);
        if (actual + cantidad > 5) return false;

        productos.put(producto, actual + cantidad);
        return true;
    }

    @Override
    public double calcularPrecioFinal() {
        double total = 0;
        for (Map.Entry<ProductoIndividual, Integer> entry : productos.entrySet()) {
            ProductoIndividual producto = entry.getKey();
            int cantidad = entry.getValue();
            total += producto.calcularPrecioFinal() * cantidad;
        }
        return total;
    }

    public Map<ProductoIndividual, Integer> getContenido() {
        return productos;
    }
}
