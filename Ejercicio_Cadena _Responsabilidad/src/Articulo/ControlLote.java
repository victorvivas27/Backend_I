package Articulo;

public class ControlLote  extends ControlCalidad{
	public ControlLote(ControlCalidad controlCalidad) {
		super(controlCalidad);
	}

	@Override
	public boolean comprobarCalidad(Articulo articulo) {
		return false;
	}

	@Override
	public String notificarAprobacion() {
		return null;
	}

	@Override
	public String notificarRechazo() {
		return null;
	}
}
