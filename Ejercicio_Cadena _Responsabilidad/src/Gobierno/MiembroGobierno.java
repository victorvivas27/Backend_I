package Gobierno;

public  abstract class MiembroGobierno {
	protected  MiembroGobierno siguiente;

	public void setSiguiente(MiembroGobierno siguiente) {
		this.siguiente = siguiente;
	}

	public  abstract  void  leerDocumento(Documento doc);


}
