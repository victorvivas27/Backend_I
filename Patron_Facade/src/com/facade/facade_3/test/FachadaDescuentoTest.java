package com.facade.facade_3.test;

import com.facade.facade_3.model.ProductoSuper;
import com.facade.facade_3.model.TarjetaBanco;
import com.facade.facade_3.service.facade.FachadaDescuento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FachadaDescuentoTest {
	 private  FachadaDescuento fachadaDescuento= new FachadaDescuento();

	 @Test
	void  deberiaCalcularce25DeDescuento(){
		 //arrange
		 ProductoSuper producto =new ProductoSuper("choclo","latas");
		 TarjetaBanco tarjeta = new TarjetaBanco("77783838389","Galicia");
		 //act
		 int descuentoOptenido= fachadaDescuento.calcularDescuento(producto,tarjeta,15);
		 //assert
		 assertEquals(25, descuentoOptenido);
	 }


}