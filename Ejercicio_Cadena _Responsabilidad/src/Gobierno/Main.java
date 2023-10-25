package Gobierno;

public class Main {
	public static void main(String[] args) {


	Diputado diputado = new Diputado();
	Ministro ministro = new Ministro();
	Presidente presidente = new Presidente();

        diputado.setSiguiente(ministro);
        ministro.setSiguiente(presidente);

	Documento documento1 = new Documento("Documento Reservado", 1);
	Documento documento2 = new Documento("Documento Secreto", 2);
	Documento documento3 = new Documento("Documento Muy Secreto", 3);

        diputado.leerDocumento(documento1);
        diputado.leerDocumento(documento2);
        diputado.leerDocumento(documento3);
}
}
