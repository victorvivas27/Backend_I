package Calculadora;

import org.apache.log4j.Logger;

public class Test {
	private static  final Logger logger = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		Calcaludora_log4j calculadora = new Calcaludora_log4j(1,3);
		int suma = calculadora.sumar();
		System.out.println(suma);
		Calcaludora_log4j calculadora1 = new Calcaludora_log4j(1,0);
		 double dividir =calculadora1.dividir();
		System.out.println(dividir);
		Calcaludora_log4j calculadora2 = new Calcaludora_log4j(2,3);
		calculadora2.dividir();

	}
}
