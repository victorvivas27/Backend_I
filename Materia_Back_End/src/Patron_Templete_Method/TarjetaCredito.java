package Patron_Templete_Method;

import java.util.Date;

public class TarjetaCredito extends Tarjeta {
	private  Double limite;
	private  Double saldoUtilizado;

	public TarjetaCredito(String numero, Integer codigoSeguridaad, Date fechaVencimiento, Double limite, Double saldoUtilizado) {
		super(numero, codigoSeguridaad, fechaVencimiento);
		this.limite = limite;
		this.saldoUtilizado = saldoUtilizado;
	}
	public  Double getLimite(){
		return  limite;
	}
}
