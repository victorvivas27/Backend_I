package Patron_Templete_Method;

import java.util.Date;

public class Tarjeta {
	private  String numero;
	private  Integer codigoSeguridaad;
	private Date fechaVencimiento;

	public Tarjeta(String numero, Integer codigoSeguridaad, Date fechaVencimiento) {
		this.numero = numero;
		this.codigoSeguridaad = codigoSeguridaad;
		this.fechaVencimiento = fechaVencimiento;
	}
	public  Date getFechaVencimiento(){
		return  fechaVencimiento;
	}
}
