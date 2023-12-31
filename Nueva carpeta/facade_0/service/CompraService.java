

import java.util.List;

public class CompraService implements ICompraService {
	private AlmacenService almacenService;
	private PagoService pagoService;
	private EnvioService envioService;

	public CompraService() {
		this.almacenService = new AlmacenService();
		this.pagoService = new PagoService();
		this.envioService = new EnvioService();
	}

	@Override
	public void procesarCompra(String productoId, Integer cantidad, Tarjeta tarjeta, Direccion direccion, List<Producto> productos) {
		Producto prod;
		almacenService.setProductos(productos);
		prod = almacenService.buscarProducto(productoId, cantidad);
		if (prod != null) {
			double montoCobrar = prod.getValor() * cantidad;
			if (pagoService.procesarPago(tarjeta, montoCobrar)) {
				envioService.procesarEnvio(prod, direccion);
			}


		}

	}
}
