package Patron_Templete_Method;

import java.util.Date;

public abstract class  ProcesadorPago {
	public  void procesarPago (Tarjeta tarjeta, Double monto){
		if (validarFecha(tarjeta.getFechaVencimiento())){
			if (autorizarPago(tarjeta,monto)){
				System.out.println("Pago autorizado");
			}else {
				System.out.println("Pago no autorizado");
			}
		}else {
			System.out.println("Tarjeta vencida");
		}

	}
	protected  abstract  Boolean autorizarPago(Tarjeta tarjeta, Double monto);
	private  Boolean validarFecha(Date fechaVencimiento){
		Date fechaAtual = new Date();
		return  fechaVencimiento.after(fechaAtual);
	}

}
