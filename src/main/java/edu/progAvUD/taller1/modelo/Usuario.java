package edu.progAvUD.taller1.modelo;

public class Usuario {
    private String cedula; 
    private String nombre; 
    private int edad; 
    private boolean esIndigena; 
    private int puntos; 
    
    public Usuario(String cedula, String nombre, int edad, boolean esIndigena){
        this.cedula = cedula; 
        this.nombre = nombre; 
        this.edad = edad; 
        this.esIndigena = esIndigena; 
        this.puntos = 0; 
    }
    
    public void acumularPuntos(double monto){
        this.puntos += (int) (monto/100); 
    }
    
    public String getNombre(){
        return nombre;
    }
    public boolean isEsIndigena(){
        return esIndigena;
    }
    public int getEdad(){
        return edad; 
    }
    public int getPuntos(){
        return puntos;
    }
}
