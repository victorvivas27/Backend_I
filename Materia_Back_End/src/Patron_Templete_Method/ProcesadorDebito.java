package Patron_Templete_Method;

public class ProcesadorDebito  extends ProcesadorPago {

	@Override
	protected Boolean autorizarPago(Tarjeta tarjeta, Double monto) {
		TarjetaDebito tarjetaDebito =(TarjetaDebito) tarjeta;
		return  tarjetaDebito.getSaldoDisponible()>=monto;
	}
}
