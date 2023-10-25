package logica;

public class VideoJuego {
	private  Integer codigo;
	private  String nombre;
	private  String  consola;
	private  Integer cantJuagadores;
	private  String categoria;

	public VideoJuego(Integer codigo) {

	}

	public VideoJuego(Integer codigo, String nombre, String consola, Integer cantJuagadores, String categoria) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.consola = consola;
		this.cantJuagadores = cantJuagadores;
		this.categoria = categoria;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getConsola() {
		return consola;
	}

	public void setConsola(String consola) {
		this.consola = consola;
	}

	public Integer getCantJuagadores() {
		return cantJuagadores;
	}

	public void setCantJuagadores(Integer cantJuagadores) {
		this.cantJuagadores = cantJuagadores;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "VideoJuego{" +
				"codigo=" + codigo +
				", nombre='" + nombre + '\'' +
				", consola='" + consola + '\'' +
				", cantJuagadores=" + cantJuagadores +
				", categoria='" + categoria + '\'' +
				'}';
	}
}
