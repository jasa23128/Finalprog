package com.proyect;

import java.util.Objects;

public abstract class Paquete implements Comparable<Paquete> {

    public static final double COSTO_POR_KILO = 1000.0;

    private final String guia;
    private final double peso;
    private final Zona zona;

    public Paquete(String guia, double peso, Zona zona) throws GuiaInvalidaException, PesoInvalidoException {
        ValidadorPaquete.validarGuia(guia);
        ValidadorPaquete.validarPeso(guia, peso);
        if (zona == null) {
            throw new IllegalArgumentException("La zona de destino no puede ser nula");
        }
        this.guia = guia;
        this.peso = peso;
        this.zona = zona;
    }

    public String getGuia() {
        return guia;
    }

    public double getPeso() {
        return peso;
    }

    public Zona getZona() {
        return zona;
    }

    public double calcularCostoBase() {
        return zona.getTarifaBase() + (peso * COSTO_POR_KILO);
    }

    public abstract double calcularCostoEnvio();

    public abstract String getNombreServicio();

    public abstract String getTextoAjuste();

    public int getPrioridadEntrega() {
        return 2;
    }

    @Override
    public int compareTo(Paquete otro) {
        int compPrioridad = Integer.compare(this.getPrioridadEntrega(), otro.getPrioridadEntrega());
        if (compPrioridad != 0) {
            return compPrioridad;
        }
        int compRuta = Integer.compare(this.zona.getOrdenRuta(), otro.zona.getOrdenRuta());
        if (compRuta != 0) {
            return compRuta;
        }
        return this.guia.compareTo(otro.guia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paquete)) return false;
        Paquete paquete = (Paquete) o;
        return Objects.equals(guia, paquete.guia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guia);
    }

    @Override
    public String toString() {
        return guia + "  " + getNombreServicio() + "  " + zona.getNombre()
                + "  " + peso + " kg  " + (int) calcularCostoBase()
                + "  " + getTextoAjuste() + "  " + (int) calcularCostoEnvio();
    }
}