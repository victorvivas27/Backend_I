package Test_Calcular_Area;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadorAreaCirculoTest {

	@Test
	void calcularAreaCirculo() {
		double radio = 7.0;
		double areaEsperada = Math.PI * Math.pow(radio, 2);
		double areaCalcualada = CalculadorAreaCirculo.calcularAreaCirculo(radio);
		assertEquals(areaCalcualada, areaCalcualada, 0.001);
	}
}
