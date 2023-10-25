package Taza;

public class Taza {
	private  String tipoLiquido;
	private  Double porcentaje;

	public Taza(String tipoLiquido, Double porcentaje) {
		this.tipoLiquido = tipoLiquido;
		this.porcentaje = porcentaje;
	}

	public String getTipoLiquido() {
		return tipoLiquido;
	}

	public void setTipoLiquido(String tipoLiquido) {
		this.tipoLiquido = tipoLiquido;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
}
