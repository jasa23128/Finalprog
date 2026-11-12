package com.proyect;

public class PaqueteFragil extends Paquete implements ManejoEspecial {

    public static final double RECARGO_FRAGIL = 5000.0;
    private final String contenido;

    public PaqueteFragil(String guia, double peso, Zona zona, String contenido)
            throws GuiaInvalidaException, PesoInvalidoException, ContenidoFragilException {
        super(guia, peso, zona);
        ValidadorPaquete.validarContenido(guia, contenido);
        this.contenido = contenido.trim();
    }

    public String getContenido() {
        return contenido;
    }

    @Override
    public double calcularCostoEnvio() {
        return calcularCostoBase() + RECARGO_FRAGIL;
    }

    @Override
    public String getNombreServicio() {
        return "Frágil " + contenido;
    }

    @Override
    public String getTextoAjuste() {
        return "+5.000";
    }

    @Override
    public String generarAdvertencia() {
        return getGuia() + " FRÁGIL " + contenido;
    }
}