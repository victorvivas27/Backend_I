package Articulo;

public class Articulo {
	private String nombre;
	private  int lote;
	private  String envasado;

	public Articulo(String nombre, int lote, String envasado) {
		this.nombre = nombre;
		this.lote = lote;
		this.envasado = envasado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	public String getEnvasado() {
		return envasado;
	}

	public void setEnvasado(String envasado) {
		this.envasado = envasado;
	}
}
