package log_animales;

import org.apache.log4j.Logger;

public class Tigre {
	private static final Logger logger = Logger.getLogger(Tigre.class);
	private String nombre;
	private int edad;

	public Tigre(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public void correr() {
		logger.info(nombre + " esta corrriendo.");

	}

	public void esMayorA10() {
		try {


			if (edad < 0) {
				throw new IllegalArgumentException("La edad no puede ser negativa");
			}
			if (edad > 10) {
				logger.info(nombre + " es mayor de 10 años.");
			}
		}catch (IllegalArgumentException exception){
			logger.error("Error: "+ exception.getMessage());

		}
	}
}
