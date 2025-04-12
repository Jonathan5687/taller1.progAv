package edu.progAvUD.taller1.modelo;

import java.util.ArrayList;
import java.util.List; 

public class Combo extends Producto {
    private Producto bebida;
    private Producto papas;
    private List<Producto> adicionales;
    private Producto principal;

    public Combo(String nombre, double precio, String descripcion, Producto principal, Producto bebida, Producto papas) {
        super(nombre, precio, descripcion);
        this.principal = principal;
        this.bebida = bebida;
        this.papas = papas;
        this.adicionales = new ArrayList<>();
    }

    public void seleccionarBebida(String sabor) {
        // lógica futura si se desea personalizar
    }

    public void agrandarProducto(String producto) {
        // lógica futura si se desea personalizar
    }

    public void agregarAdicional(Producto adicional) {
        adicionales.add(adicional);
    }

    @Override
    public double calcularPrecioFinal() {
        double total = getPrecio();
        for (Producto adicional : adicionales) {
            total += adicional.calcularPrecioFinal();
        }
        return total;
    }

    // Métodos estáticos para crear combos predeterminados

    public static Combo crearCombo1() {
        Producto nuggets = new ProductoIndividual("Nuggets (10 uds)", 0, "10 nuggets de pollo", 10);
        Producto papas = new ProductoIndividual("Papas a la francesa", 0, "Papas clásicas", 5);
        Producto gaseosa = new ProductoIndividual("Gaseosa", 0, "Sabor a elegir", 5);
        return new Combo("Combo 1", 25000, "10 nuggets + papas + gaseosa", nuggets, gaseosa, papas);
    }

    public static Combo crearCombo2() {
        Producto alitas = new ProductoIndividual("Alitas BBQ (5 uds)", 0, "5 alitas en salsa BBQ", 12);
        Producto papasGrandes = new ProductoIndividual("Papas grandes", 0, "Porción grande de papas", 6);
        Producto gaseosa = new ProductoIndividual("Gaseosa", 0, "Sabor a elegir", 5);
        return new Combo("Combo 2", 22500, "5 alitas BBQ + papas grandes + gaseosa", alitas, gaseosa, papasGrandes);
    }

    public static Combo crearCombo3() {
        Producto hamburguesa = new ProductoIndividual("Hamburguesa Clásica", 0, "Pan, carne, queso, lechuga, tomate", 15);
        Producto nuggets = new ProductoIndividual("Nuggets (5 uds)", 0, "5 nuggets de pollo", 6);
        Producto papas = new ProductoIndividual("Papas medianas", 0, "Papas estándar", 5);
        Producto gaseosa = new ProductoIndividual("Gaseosa", 0, "Sabor a elegir", 5);

        Combo combo = new Combo("Combo 3", 36000, "2 hamburguesas clásicas + 5 nuggets + papas + gaseosa",
                hamburguesa, gaseosa, papas);
        combo.agregarAdicional(new ProductoIndividual("Hamburguesa Clásica", 0, "Pan, carne, queso, lechuga, tomate", 15));
        combo.agregarAdicional(nuggets);
        return combo;
    }
}