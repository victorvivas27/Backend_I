package log_animales;


import org.apache.log4j.Logger;

public class Leon {
	private static final Logger logger = Logger.getLogger(Leon.class);
	private  String nombre;
	private  int edad;
	private  boolean esAlfa;

	public Leon(String nombre, int edad, boolean esAlfa) {
		this.nombre = nombre;
		this.edad = edad;
		this.esAlfa = esAlfa;
	}
	public void correr(){
		logger.info("El leon "+ nombre+"  esta corrriendo");

	}
	public void esMayorA10() {
		try {
			if (edad < 0) {
				throw new IllegalArgumentException("La edad no puede ser negativa" );

			}

			if (edad > 10 && esAlfa) {
				logger.info(nombre + " es mayor de 10 años y es un alfa.");
			}
		}catch (IllegalArgumentException exception){
			logger.error("Error: "+ exception.getMessage());
			logger.error("La edad de Leon "+nombre+" es incorrecta");

		}
	}
}
