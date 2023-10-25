package com.company.herencia;

import com.company.Cuenta;

public class CuentaCorriente  extends Cuenta {



	@Override
	public boolean extraer(double monto) {
		setSaldo(getSaldo()-monto);
		return true;

	}
}
