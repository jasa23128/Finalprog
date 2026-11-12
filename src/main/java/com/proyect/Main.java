package com.proyect;

public class Main {

    public static void main(String[] args) {
        ejecutarCaso1();
        ejecutarCaso2();
        ejecutarCaso3();
        ejecutarCaso4();
    }

    private static void ejecutarCaso1() {
        System.out.println("Despacho Andrés");
        Despacho despachoAndres = new Despacho("Andrés");

        try {
            despachoAndres.agregarPaquete(new PaqueteEstandar("EY2001", 5.0, Zona.ORIENTE));
        } catch (Exception e) {
            System.out.println("ALERTA " + e.getMessage());
        }

        try {
            despachoAndres.agregarPaquete(new PaqueteExpress("EY2002", 1.5, Zona.NORTE));
        } catch (Exception e) {
            System.out.println("ALERTA " + e.getMessage());
        }

        try {
            despachoAndres.agregarPaquete(new PaqueteFragil("EY2003", 2.0, Zona.CENTRO, "vajilla"));
        } catch (Exception e) {
            System.out.println("ALERTA " + e.getMessage());
        }

        try {
            despachoAndres.agregarPaquete(new PaqueteEstandar("EY2004", 8.0, Zona.CENTRO));
        } catch (Exception e) {
            System.out.println("ALERTA " + e.getMessage());
        }

        try {
            despachoAndres.agregarPaquete(new PaqueteExpress("EY2005", 6.0, Zona.ORIENTE));
        } catch (Exception e) {
            System.out.println("[ALERTA] " + e.getMessage());
        }

        try {
            despachoAndres.agregarPaquete(new PaqueteFragil("EY2006", 3.5, Zona.SUR, "televisor"));
        } catch (Exception e) {
            System.out.println("ALERTA " + e.getMessage());
        }

        despachoAndres.imprimirManifiesto();
    }

    private static void ejecutarCaso2() {
        System.out.println("Valdación de paquetes invalidos");

        try {
            new PaqueteEstandar("EY3001", -2.0, Zona.CENTRO);
        } catch (Exception e) {
            System.out.println("ALERTA " + e.getMessage());
        }

        try {
            new PaqueteFragil("EY3002", 2.0, Zona.NORTE, "");
        } catch (Exception e) {
            System.out.println("ALERTA " + e.getMessage());
        }

        try {
            new PaqueteEstandar("EY12A4", 3.0, Zona.SUR);
        } catch (Exception e) {
            System.out.println("ALERTA " + e.getMessage());
        }

        try {
            new PaqueteExpress("EY3003", 22.0, Zona.NORTE);
        } catch (Exception e) {
            System.out.println("ALERTA " + e.getMessage());
        }

        System.out.println();
    }

    private static void ejecutarCaso3() {
        System.out.println("Despacho Camila Límite 30 kg");
        Despacho despachoCamila = new Despacho("Camila");

        try {
            despachoCamila.agregarPaquete(new PaqueteEstandar("EY4001", 12.0, Zona.CENTRO));
        } catch (Exception e) {
            System.out.println("ALERTA " + e.getMessage());
        }

        try {
            despachoCamila.agregarPaquete(new PaqueteExpress("EY4002", 10.0, Zona.SUR));
        } catch (Exception e) {
            System.out.println("ALERTA" + e.getMessage());
        }

        try {
            despachoCamila.agregarPaquete(new PaqueteFragil("EY4003", 9.0, Zona.NORTE, "espejo"));
        } catch (Exception e) {
            System.out.println("ALERT " + e.getMessage());
        }

        try {
            despachoCamila.agregarPaquete(new PaqueteEstandar("EY4004", 8.0, Zona.ORIENTE));
        } catch (Exception e) {
            System.out.println("[ALERTA] " + e.getMessage());
        }

        despachoCamila.imprimirManifiesto();
    }

    private static void ejecutarCaso4() {
        System.out.println("Despacho Mateo - Guía duplicada");
        Despacho despachoMateo = new Despacho("Mateo");

        try {
            despachoMateo.agregarPaquete(new PaqueteFragil("EY5001", 3.0, Zona.SUR, "lámpara"));
        } catch (Exception e) {
            System.out.println("ALERTA " + e.getMessage());
        }

        try {
            despachoMateo.agregarPaquete(new PaqueteEstandar("EY5001", 1.0, Zona.CENTRO));
        } catch (Exception e) {
            System.out.println("ALERTA " + e.getMessage());
        }

        try {
            despachoMateo.agregarPaquete(new PaqueteExpress("EY5002", 2.0, Zona.CENTRO));
        } catch (Exception e) {
            System.out.println("ALERTA " + e.getMessage());
        }

        despachoMateo.imprimirManifiesto();
    }
}