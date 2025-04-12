package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoProductos {
    private List<Producto> productos;

    public CatalogoProductos() {
        productos = new ArrayList<>();

        // Buckets
        productos.add(new Producto("Bucket Clásico", "Buckets", 35000));
        productos.add(new Producto("Bucket Familiar", "Buckets", 45000));

        // Wraps
        productos.add(new Producto("Wrap de Pollo BBQ", "Wraps", 18000));
        productos.add(new Producto("Wrap Picante", "Wraps", 19000));

        // Alitas
        productos.add(new Producto("5 Alitas BBQ", "Alitas", 16000));
        productos.add(new Producto("10 Alitas Picantes", "Alitas", 30000));

        // Nuggets
        productos.add(new Producto("5 Nuggets", "Nuggets", 8000));
        productos.add(new Producto("10 Nuggets", "Nuggets", 15000));

        // Hamburguesas
        productos.add(new Producto("Hamburguesa Clásica", "Hamburguesas", 12000));
        productos.add(new Producto("Hamburguesa Doble", "Hamburguesas", 18000));

        // Combos
        productos.add(new Producto("Combo 1: Nuggets + Papas + Gaseosa", "Combos", 25000));
        productos.add(new Producto("Combo 2: Alitas + Papas + Gaseosa", "Combos", 22500));
        productos.add(new Producto("Combo 3: Hamburguesas + Nuggets + Gaseosa", "Combos", 36000));
    }

    public List<Producto> obtenerProductosPorCategoria(String categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }
}
