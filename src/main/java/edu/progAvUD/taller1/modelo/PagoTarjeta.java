package edu.progAvUD.taller1.modelo;


public class PagoTarjeta extends Pago{
    private Datafono datafono;
    
    public PagoTarjeta(Datafono datafono){
        this.datafono = datafono;
    }

    @Override
    public boolean procesarPago(double monto) {
        return datafono.validarTransaccion(monto);
    }
}
