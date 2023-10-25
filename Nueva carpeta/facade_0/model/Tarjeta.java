

public class Tarjeta {
	private String numerosFrente;
	private String codSeguridad;

	public Tarjeta(String numerosFrente, String codSeguridad) {
		this.numerosFrente = numerosFrente;
		this.codSeguridad = codSeguridad;
	}

	public String getNumerosFrente() {
		return numerosFrente;
	}

	public void setNumerosFrente(String numerosFrente) {
		this.numerosFrente = numerosFrente;
	}

	public String getCodSeguridad() {
		return codSeguridad;
	}

	public void setCodSeguridad(String codSeguridad) {
		this.codSeguridad = codSeguridad;
	}
}
