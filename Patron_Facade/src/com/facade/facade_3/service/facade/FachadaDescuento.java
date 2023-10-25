package com.facade.facade_3.service.facade;

import com.facade.facade_3.model.ProductoSuper;
import com.facade.facade_3.model.TarjetaBanco;
import com.facade.facade_3.service.api.ApiCantidad;
import com.facade.facade_3.service.api.ApiProducto;
import com.facade.facade_3.service.api.ApiTarjeta;
import org.apache.log4j.Logger;

public class FachadaDescuento implements IDescuento {
	private final Logger LOOGER = Logger.getLogger(FachadaDescuento.class);

	@Override
	public int calcularDescuento(ProductoSuper productoSuper, TarjetaBanco tarjetaBanco, int cantidad) {
		int descuento = 0;
		descuento += ApiProducto.calcularDescuentoProducto(productoSuper);
		descuento += ApiTarjeta.calcularDescuentoTarjeta(tarjetaBanco);
		descuento += ApiCantidad.calcularDescuentoCantidad(cantidad);


		LOOGER.info("Descuento total: " + descuento);
		return descuento;
	}
}
