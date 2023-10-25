package com.facade.facade_3.service.api;

import com.facade.facade_3.model.TarjetaBanco;
import org.apache.log4j.Logger;

public class ApiTarjeta {
	private static  final Logger LOGGER = Logger.getLogger(ApiTarjeta.class);
	 public  static  int calcularDescuentoTarjeta(TarjetaBanco tarjetaBanco){
		 int descuento = tarjetaBanco.getBanco().equalsIgnoreCase("Star Banck")?20:0;

		 LOGGER.info("Descuento correspondiente por tarjeta: \n "
				 + tarjetaBanco+ " \n Descuento:  " + descuento);
		 return  descuento;
	 }
}
