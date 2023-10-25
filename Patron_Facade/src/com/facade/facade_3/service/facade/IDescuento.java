package com.facade.facade_3.service.facade;

import com.facade.facade_3.model.ProductoSuper;
import com.facade.facade_3.model.TarjetaBanco;

public interface IDescuento {
	int calcularDescuento(ProductoSuper productoSuper, TarjetaBanco tarjetaBanco, int cantidad);

}
