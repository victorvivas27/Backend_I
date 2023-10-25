package Patron_Templete_Method;

public class ProcesadorCredito  extends ProcesadorPago {

	@Override
	protected Boolean autorizarPago(Tarjeta tarjeta, Double monto) {
		TarjetaCredito tarjetaCreditoe=(TarjetaCredito) tarjeta;
		return  tarjetaCreditoe.getLimite()>= monto;
	}
}
