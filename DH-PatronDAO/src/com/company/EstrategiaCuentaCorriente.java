package com.company;

public  class EstrategiaCuentaCorriente implements  EstrategiaExtraccion{


	@Override
	public boolean extraer(Cuenta cuenta, double monto) {
		cuenta.setSaldo(cuenta.getSaldo()-monto);
		return  true;
	}
}
