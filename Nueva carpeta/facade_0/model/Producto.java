

public class Producto {
	private String productoId;
	private String nombre;
	public double valor;
	private Integer cantidad;

	public Producto(String productoId, String nombre, double valor, int cantidad) {
		this.productoId = productoId;
		this.nombre = nombre;
		this.valor = valor;
		this.cantidad = cantidad;
	}

	public String getProductoId() {
		return productoId;
	}

	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
