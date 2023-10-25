import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class);
	public static void main(String[] args) {
		try {
			List<Integer> lista1 = new ArrayList<>();
			List<Integer> lista2 = new ArrayList<>();
			List<Integer> lista3 = new ArrayList<>();

			// Agrega elementos a las listas
			lista1.add(2);
			lista1.add(4);
			lista1.add(6);

			lista2.add(8);
			lista2.add(10);
			lista2.add(12);
			lista2.add(14);
			lista2.add(16);

			// Intenta crear instancias de ListaPromedio
			new ListaPromedio(lista1);
			new ListaPromedio(lista2);
			new ListaPromedio(lista3); // Esto generará un error

		} catch (Exception e) {
			LOGGER.error("Error al crear ListaPromedio: " + e.getMessage());
			e.printStackTrace();
		}
	}
}