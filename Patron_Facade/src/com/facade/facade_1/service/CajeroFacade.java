package com.facade_1.service;

import com.facade_1.model.AuthenticacionService;
import com.facade_1.model.CajaService;
import com.facade_1.model.Cuenta;
import com.facade_1.model.CuentaService;

public class CajeroFacade {
	private AuthenticacionService authenticacionService;
	private CuentaService cuentaService;
	private CajaService cajaService;

	public CajeroFacade() {
		authenticacionService = new AuthenticarServiceImpl();
		cuentaService = new CuentaServiceImpl();
		cajaService = new CajaServiceImpl();

	}

	public boolean retirarDinero(String dni, String contrasenia, double monto) {
		boolean autenticado = authenticacionService.validarUsuarioYContarsenia(dni, contrasenia);
		if (autenticado) {
			Cuenta cuenta = cuentaService.getCuenta(dni);
			if ( cuenta != null && cuenta.getSaldo() >= (monto)){
				return  cajaService.entregarDinero(monto);
			}
		}
		return  false;
	}

}



