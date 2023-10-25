package com.company;

public class Main {
	public static void main(String[] args) {
Cuenta cuenta = new Cuenta();
cuenta.setSaldo(2000.0);
cuenta.setNumero(1120);
cuenta.setEstrategiaExtraccion(new ExtrategiaCajaAhorro());
cuenta.extraer(2100.0);
		System.out.println(cuenta.getSaldo());
		cuenta.setEstrategiaExtraccion(new EstrategiaCuentaCorriente());
		cuenta.extraer(2100.0);
		System.out.println("La cuenta: "+ cuenta.getNumero()+ " Tiene un saldo de: "+ cuenta.getSaldo());
		System.out.println(cuenta.getSaldo());
	}
}
