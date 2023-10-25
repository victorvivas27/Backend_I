package Taza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TazaTest {

@Test
	void getTipoLiquido() {
	Taza taza  = new Taza("Jugo de naranja",70.5);
	assertEquals("Jugo de naranja",taza.getTipoLiquido());
	}

	@Test
	void getPorcentaje() {
	Taza taza = new Taza("Jugo de naranja", 70.5);
	assertEquals(70.5, taza.getPorcentaje());
	}
}