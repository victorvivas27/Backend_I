

import java.util.List;

public class AlmacenService {
	private List<com.facade.model.Producto> productos;

	public void setProductos(List<com.facade.model.Producto> productos) {
		this.productos = productos;
	}

	public com.facade.model.Producto buscarProducto(String productoId, Integer cantidad) {

		com.facade.model.Producto productoEncontrado = null;
		for (com.facade.model.Producto p : this.productos) {
			if (p.getProductoId().equals(productoId) && p.getCantidad() >= cantidad) {
				productoEncontrado = p;
				p.setCantidad(p.getCantidad() - cantidad);
				productoEncontrado.setCantidad(cantidad);
			}

		}
		return productoEncontrado;
	}
}
