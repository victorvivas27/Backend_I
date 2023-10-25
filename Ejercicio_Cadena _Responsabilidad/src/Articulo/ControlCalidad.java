package Articulo;

public  abstract class ControlCalidad {
	private  ControlCalidad controlCalidad;

	public ControlCalidad(ControlCalidad controlCalidad) {
		this.controlCalidad = controlCalidad;
	}
	public  abstract boolean comprobarCalidad(Articulo articulo);
	public  abstract  String notificarAprobacion();
	public  abstract  String notificarRechazo();

	public ControlCalidad getControlCalidad() {
		return controlCalidad;
	}

	public void setControlCalidad(ControlCalidad controlCalidad) {
		this.controlCalidad = controlCalidad;
	}
}
