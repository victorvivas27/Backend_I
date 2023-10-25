package Documentos;

import java.util.List;

public class Documento implements IDocumento {
	private String id;
	private String url;
	private String contiene;
	private List<String> autorisacionUsuario;

	public Documento(String id, String url, String contiene, List<String> autorisacionUsuario) {
		this.id = id;
		this.url = url;
		this.contiene = contiene;
		this.autorisacionUsuario = autorisacionUsuario;
	}

	@Override
	public void access(String email) {
		if (autorisacionUsuario.contains(email)) {
			System.out.println("El usuario con el correo electronico :  " + email + " ha accedido al documento :  " + id + ".");
		} else {
			System.out.println("El usuario con el correo electrónico  " + email + "  no está autorizado para acceder al documento " + id + ".");
		}
	}

	public String getId() {
		return id;
	}
}

