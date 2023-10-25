

public class Direccion {
	private String calle;
	private String nro;
	private String barrio;

	public Direccion(String calle, String nro, String barrio) {
		this.calle = calle;
		this.nro = nro;
		this.barrio = barrio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNro() {
		return nro;
	}

	public void setNro(String nro) {
		this.nro = nro;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
}
