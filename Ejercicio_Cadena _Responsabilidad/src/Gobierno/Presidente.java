package Gobierno;

public class Presidente extends MiembroGobierno {


	@Override
	public void leerDocumento(Documento doc) {
		if (doc.getTipo() <= 3) {
			System.out.println(" Presidente leyendo documento : " + doc.getContenido());
		} else {
			System.out.println("Nadie tiene acceso a este documento ");

		}
	}
}
