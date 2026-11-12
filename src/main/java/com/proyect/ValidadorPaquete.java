package com.proyect;

public final class ValidadorPaquete {

    public static final double PESO_MINIMO = 0.0;
    public static final double PESO_MAXIMO_PAQUETE = 20.0;

    private ValidadorPaquete() {
    }

    public static void validarGuia(String guia) throws GuiaInvalidaException {
        if (guia == null || !guia.matches("^EY\\d{4}$")) {
            throw new GuiaInvalidaException("Guía inválida (" + guia + "): debe iniciar con 'EY' seguido de exactamente 4 dígitos.");
        }
    }

    public static void validarPeso(String guia, double peso) throws PesoInvalidoException {
        if (peso <= PESO_MINIMO) {
            throw new PesoInvalidoException("Peso inválido en paquete " + guia + " (" + peso + " kg): debe ser mayor a 0 kg.");
        }
        if (peso > PESO_MAXIMO_PAQUETE) {
            throw new PesoInvalidoException("Peso inválido en paquete " + guia + " (" + peso + " kg): supera el máximo de 20 kg permitidos por paquete en moto.");
        }
    }

    public static void validarContenido(String guia, String contenido) throws ContenidoFragilException {
        if (contenido == null || contenido.trim().isEmpty()) {
            throw new ContenidoFragilException("Error en paquete frágil " + guia + ": debe especificar qué contiene (no puede estar vacío).");
        }
    }
}