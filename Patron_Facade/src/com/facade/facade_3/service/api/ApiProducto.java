package com.facade.facade_3.service.api;

import com.facade.facade_3.model.ProductoSuper;
import org.apache.log4j.Logger;

public class ApiProducto {
	private static  final Logger LOGGER = Logger.getLogger(ApiProducto.class);

	public static int calcularDescuentoProducto(ProductoSuper productoSuper) {
		int descuento = productoSuper.getTipo().equalsIgnoreCase("latas") ? 10 : 0;
		LOGGER.info("Descuento correspondiente por producto:  \n  "
				+ productoSuper + "  \nDescuento:  " + descuento);
		return descuento;
	}
}
