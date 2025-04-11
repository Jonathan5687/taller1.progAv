package edu.progAvUD.taller1.modelo;


public class Factura {
    private String detalles; 
    private double monto;
    
    public Factura(String detalles, double monto){
        this.detalles = detalles; 
        this.monto = monto;
    }
    public String getDetalles(){
        return detalles;
    }
    public double getMonto(){
        return monto;
    }
    
}
