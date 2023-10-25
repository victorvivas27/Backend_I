import org.apache.log4j.Logger;

import java.util.List;

public class ListaPromedio {
	private static final Logger LOGGER = Logger.getLogger(ListaPromedio.class);

	public ListaPromedio(List<Integer> listaEnteros) throws Exception {
		if (listaEnteros.isEmpty()) {
			LOGGER.error("La lista es igual a cero");
			throw new Exception("La lista es igual a cero");
		}

		if (listaEnteros.size() > 5) {
			LOGGER.info("La longitud de la lista es mayor a 5");
		}

		if (listaEnteros.size() > 10) {
			LOGGER.info("La longitud de la lista es mayor a 10");
		}

		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int numero : listaEnteros) {
			sum += numero;
			max = Math.max(max, numero);
			min = Math.min(min, numero);
		}

		double promedio = (double) sum / listaEnteros.size();
		LOGGER.info("El promedio es: " + promedio);
		LOGGER.info("El máximo es: " + max);
		LOGGER.info("El mínimo es: " + min);
	}
}
