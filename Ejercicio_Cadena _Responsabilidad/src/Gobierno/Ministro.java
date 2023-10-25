package Gobierno;

public class Ministro extends MiembroGobierno {


	@Override
	public void leerDocumento(Documento doc) {
		if (doc.getTipo() <= 2) {
			System.out.println("Ministro leyendo documento : " + doc.getContenido());

		} else if (siguiente != null) {
			siguiente.leerDocumento(doc);

		}
	}
}
