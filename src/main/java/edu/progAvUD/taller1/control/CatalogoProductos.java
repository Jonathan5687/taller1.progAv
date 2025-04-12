package edu.progAvUD.taller1.control;

import edu.progAvUD.taller1.modelo.Producto;
import edu.progAvUD.taller1.modelo.ProductoIndividual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CatalogoProductos {
    private Map<String, List<Producto>> catalogo;
    
    public CatalogoProductos(){
        catalogo = new HashMap<>();
        inicializarCatalogo();
    }
    private void inicializarCatalogo() {
        agregarProducto("Alitas", new ProductoIndividual("Alitas BBQ (5 uds)", 12000, "Alitas en salsa BBQ, 5 unidades", 12));
        agregarProducto("Alitas", new ProductoIndividual("Alitas Picantes (5 uds)", 12000, "Alitas con salsa picante, 5 unidades", 12));

        agregarProducto("Nuggets", new ProductoIndividual("Nuggets de Pollo (6 uds)", 10000, "Nuggets crujientes de pollo, 6 unidades", 10));

        agregarProducto("Papas", new ProductoIndividual("Papas a la francesa", 7000, "Papas fritas medianas", 7));
        agregarProducto("Papas", new ProductoIndividual("Papas grandes", 9000, "Papas fritas grandes", 9));

        agregarProducto("Wraps", new ProductoIndividual("Wrap de Pollo Clásico", 11000, "Wrap con pollo, lechuga y aderezo", 11));
        agregarProducto("Wraps", new ProductoIndividual("Wrap Picante", 11500, "Wrap de pollo picante con vegetales", 11));

        agregarProducto("Hamburguesas", new ProductoIndividual("Hamburguesa Clásica", 13000, "Hamburguesa con carne, queso y vegetales", 13));
        agregarProducto("Hamburguesas", new ProductoIndividual("Hamburguesa Doble", 16000, "Hamburguesa con doble carne y queso", 16));        
    }

    private void agregarProducto(String categoria, Producto producto) {
        catalogo.computeIfAbsent(categoria, k -> new ArrayList<>()).add(producto);
    }

    public List<String> getCategorias() {
        return new ArrayList<>(catalogo.keySet());
    }

    public List<Producto> getProductosPorCategoria(String categoria) {
        return catalogo.getOrDefault(categoria, new ArrayList<>());
    }
}
