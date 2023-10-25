package Gobierno;

public class Diputado extends MiembroGobierno {
	@Override
	public void leerDocumento(Documento doc) {
		if (doc.getTipo() <= 1) {
			System.out.println("Diputado leyendo documento : " + doc.getContenido());
		} else if (siguiente != null) {
			siguiente.leerDocumento(doc);
		}
	}
}
