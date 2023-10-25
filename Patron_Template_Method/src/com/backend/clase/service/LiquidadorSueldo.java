package com.backend.clase.service;

import com.backend.clase.model.Empleado;

public abstract class LiquidadorSueldo {
	public String liquidarSueldo(Empleado empleado) {
		String respuesta = " la liquidacion no se pudo realizar";
		double sueldo = calcularSueldo(empleado);
		if (sueldo > 0) {
			String recibo = generarRecibo(empleado);
			respuesta = recibo + ". Sueldo a liquidar $ " + sueldo;
			System.out.println(depositar(empleado));
		}
		return respuesta;
	}

	protected abstract double calcularSueldo(Empleado empleado);

	protected abstract String generarRecibo(Empleado empleado);

	private String depositar(Empleado empleado) {
		return " Orden de deposito en la cuenta :  " + empleado.getNumeroCuenta();
	}
}
