package com.proyect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Despacho {

    private static int contadorDespachos = 0;
    public static final double CAPACIDAD_MAXIMA_MOTO = 30.0;

    private final String codigo;
    private final String nombreMensajero;
    private final List<Paquete> paquetes;

    public Despacho(String nombreMensajero) {
        if (nombreMensajero == null || nombreMensajero.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del mensajero no puede estar vacío.");
        }
        contadorDespachos++;
        this.codigo = "D-" + contadorDespachos;
        this.nombreMensajero = nombreMensajero.trim();
        this.paquetes = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreMensajero() {
        return nombreMensajero;
    }

    public double calcularPesoTotal() {
        double total = 0.0;
        for (Paquete p : paquetes) {
            total += p.getPeso();
        }
        return total;
    }

    public double calcularCostoTotal() {
        double total = 0.0;
        for (Paquete p : paquetes) {
            total += p.calcularCostoEnvio();
        }
        return total;
    }

    public void agregarPaquete(Paquete paquete) throws PaqueteDuplicadoException, CapacidadExcedidaException {
        if (paquete == null) {
            return;
        }
        if (paquetes.contains(paquete)) {
            throw new PaqueteDuplicadoException(
                    "No se agregó el paquete " + paquete.getGuia() + " en " + codigo + ": ya existe un paquete con esa guía en el despacho.");
        }
        double pesoProyectado = calcularPesoTotal() + paquete.getPeso();
        if (pesoProyectado > CAPACIDAD_MAXIMA_MOTO) {
            throw new CapacidadExcedidaException(
                    "No se agregó el paquete " + paquete.getGuia() + " (" + paquete.getPeso() + " kg) en " + codigo
                            + ": supera el límite de 30.0 kg de la moto (peso actual: " + calcularPesoTotal() + " kg).");
        }
        paquetes.add(paquete);
    }

    public void imprimirManifiesto() {
        List<Paquete> ordenados = new ArrayList<>(paquetes);
        Collections.sort(ordenados);


        System.out.println("Manifiesto: Despacho " + codigo + " - Mensajero(a): " + nombreMensajero);
        System.out.println("Guía | Servicio | Zona | Peso | Costo base | Ajuste | Costo envío");


        List<String> advertencias = new ArrayList<>();

        for (Paquete p : ordenados) {
            System.out.println(p);
            if (p instanceof ManejoEspecial) {
                ManejoEspecial especial = (ManejoEspecial) p;
                advertencias.add(especial.generarAdvertencia());
            }
        }

        String textoAdvertencias = advertencias.isEmpty() ? "Ninguna" : String.join(", ", advertencias);
        System.out.println("Peso total: " + calcularPesoTotal() + " kg. Costo total del despacho: $"
                + (int) calcularCostoTotal() + " Advertencias: " + textoAdvertencias);

    }
}