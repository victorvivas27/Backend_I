package log_animales;

import org.apache.log4j.Logger;

public class Test_animales {
	private static final Logger logger = Logger.getLogger(Test_animales.class);

	public static void main(String[] args) {
		Leon leon1 = new Leon("Simba", 8, true);
		Leon leon2 = new Leon("Bom", -5,true);
		Tigre tigre1 = new Tigre("Tigre", 15);

		leon1.correr();
		leon1.esMayorA10();
		leon2.correr();
		leon2.esMayorA10();
		tigre1.correr();
		tigre1.esMayorA10();
	}
}
