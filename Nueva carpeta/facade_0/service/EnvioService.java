

public class EnvioService {
	public void procesarEnvio(Producto producto, Direccion direccion) {
		System.out.println("Enviando producto a " + direccion.getCalle() + " " + direccion.getNro() + " ," + direccion.getBarrio());

	}
}
