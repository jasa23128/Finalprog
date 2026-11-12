package com.proyect;

public class PaqueteExpress extends Paquete {

    public static final double RECARGO_EXPRESS = 1.50;

    public PaqueteExpress(String guia, double peso, Zona zona) throws GuiaInvalidaException, PesoInvalidoException {
        super(guia, peso, zona);
    }

    @Override
    public double calcularCostoEnvio() {
        return calcularCostoBase() * RECARGO_EXPRESS;
    }

    @Override
    public String getNombreServicio() {
        return "Express";
    }

    @Override
    public String getTextoAjuste() {
        return "+50%";
    }

    @Override
    public int getPrioridadEntrega() {
        return 1;
    }
}









