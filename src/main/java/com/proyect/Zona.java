package com.proyect;

public enum Zona {
    CENTRO("Centro", 6000.0, 1),
    NORTE("Norte", 8000.0, 2),
    SUR("Sur", 8000.0, 3),
    ORIENTE("Oriente", 15000.0, 4);

    private final String nombre;
    private final double tarifaBase;
    private final int ordenRuta;

    Zona(String nombre, double tarifaBase, int ordenRuta) {
        this.nombre = nombre;
        this.tarifaBase = tarifaBase;
        this.ordenRuta = ordenRuta;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public int getOrdenRuta() {
        return ordenRuta;
    }
}