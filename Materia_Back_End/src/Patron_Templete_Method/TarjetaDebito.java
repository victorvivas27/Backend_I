package Patron_Templete_Method;

import java.util.Date;

public class TarjetaDebito  extends Tarjeta {
	private  Double saldoDisponible;

	public TarjetaDebito(String numero, Integer codigoSeguridaad, Date fechaVencimiento, Double saldoDisponible) {
		super(numero, codigoSeguridaad, fechaVencimiento);
		this.saldoDisponible = saldoDisponible;
	}
	public  Double getSaldoDisponible(){
		return saldoDisponible;
	}
}
