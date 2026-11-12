package com.proyect;

public class PaqueteEstandar extends Paquete {

    public PaqueteEstandar(String guia, double peso, Zona zona) throws GuiaInvalidaException, PesoInvalidoException {
        super(guia, peso, zona);
    }

    @Override
    public double calcularCostoEnvio() {
        return calcularCostoBase();
    }

    @Override
    public String getNombreServicio() {
        return "Estándar";
    }

    @Override
    public String getTextoAjuste() {
        return "";
    }
}