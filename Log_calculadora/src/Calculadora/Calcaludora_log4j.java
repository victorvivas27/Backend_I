package Calculadora;

import org.apache.log4j.Logger;

public class Calcaludora_log4j {
	private static  final Logger logger = Logger.getLogger(Calcaludora_log4j.class);
	private int valor1;
	private int valor2;

	public Calcaludora_log4j(int valor1, int valor2) {
		this.valor1 = valor1;
		this.valor2 = valor2;
	}
	public  int sumar(){
		return valor1+valor2;
	}
	public  int restar(){
		return valor1-valor2;
	}
	public  int multiplivar(){
		return  valor1*valor2;
	}
	public double dividir(){
		logger.info("empezamos a dividir: "+ valor1+ "/"+ valor2);
		double resultado;
		try {
			resultado= valor1/valor2;
		}catch (Exception exception){
			logger.error("Ocurrio unerror al dividir: ",exception);
			return 0;
		}
		logger.debug("Terminamos de dividir con exito.");
		return  resultado;
	}
}

