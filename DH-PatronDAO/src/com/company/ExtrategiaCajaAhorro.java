package com.company;

public class ExtrategiaCajaAhorro implements  EstrategiaExtraccion {

	@Override
	public boolean extraer(Cuenta cuenta, double monto) {
		boolean resultado = false;
		if (cuenta.getSaldo() >= monto) {
			cuenta.setSaldo(cuenta.getSaldo() - monto); // Resta el monto al saldo de la cuenta
			resultado = true;
		}
		return resultado;
	}
}
