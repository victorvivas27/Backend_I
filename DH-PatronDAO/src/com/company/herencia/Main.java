package com.company.herencia;

import com.company.Cuenta;
import com.company.herencia.CuentaCajaAhorro;
import com.company.herencia.CuentaCorriente;

public class Main {
	public static void main(String[] args) {
		Cuenta cuenta=new CuentaCajaAhorro();
		cuenta.setSaldo(1000.0);
		cuenta.extraer(1100.0);

		System.out.println(cuenta.getSaldo());
		Cuenta cuenta1 = new CuentaCorriente();
		cuenta1.setSaldo(1000.0);
		cuenta1.extraer(1100.0);
		System.out.println(cuenta1.getSaldo());
	}
}