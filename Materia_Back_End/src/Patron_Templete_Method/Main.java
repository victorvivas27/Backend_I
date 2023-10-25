package Patron_Templete_Method;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Crear fecha de vencimiento
        Date fechaVencimiento = new Date(124, 11, 31); // Año, mes (0-11), día

        // Crear tarjetas de crédito y débito
        TarjetaCredito tarjetaCredito = new TarjetaCredito("1234567890123456", 123, fechaVencimiento, 1000.0, 500.0);
        TarjetaDebito tarjetaDebito = new TarjetaDebito("9876543210987654", 456, fechaVencimiento, 800.0);

        // Crear procesadores de pago
        ProcesadorPago procesadorCredito = new ProcesadorCredito();
        ProcesadorPago procesadorDebito = new ProcesadorDebito();

        // Realizar pagos
        double montoPago1 = 300.0;
        double montoPago2 = 700.0;
        double montoPago3 = 900.0;

        System.out.println("Procesando pagos con tarjeta de crédito:");
        procesadorCredito.procesarPago(tarjetaCredito, montoPago1); // Pago autorizado
        procesadorCredito.procesarPago(tarjetaCredito, montoPago2); // Pago autorizado
        procesadorCredito.procesarPago(tarjetaCredito, montoPago3); // Pago no autorizado

        System.out.println("\nProcesando pagos con tarjeta de débito:");
        procesadorDebito.procesarPago(tarjetaDebito, montoPago1);   // Pago autorizado
        procesadorDebito.procesarPago(tarjetaDebito, montoPago2);   // Pago no autorizado (saldo insuficiente)
    }
}
