package Documentos;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> autorisacionUsuario = new ArrayList<>();
		autorisacionUsuario.add("user1@gmail.com");
		autorisacionUsuario.add("user2@gmail.com");
		Documento documento = new Documento("15623","http://ejemplo.com/documento","Contenido del documento",autorisacionUsuario);
		DocumentoProxy proxy = new DocumentoProxy(documento);
		proxy.access("user1@gmail.com");
		proxy.access("user3@gmail.com");
		documento.access("user2@gmail.com");
	}
}
