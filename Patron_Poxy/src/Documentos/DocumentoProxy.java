package Documentos;

import java.util.ArrayList;
import java.util.List;

public class DocumentoProxy implements IDocumento {
	private Documento documento;
	private List<String> accesoBy;

	public DocumentoProxy(Documento documento) {
		this.documento = documento;
		this.accesoBy = new ArrayList<>();
	}

	@Override
	public void access(String email) {
		if (!accesoBy.contains(email)) {
			documento.access(email);
			accesoBy.add(email);
		} else {
			System.out.println("El usuario con el correo electrónico " + email + " ya ha accedido al documento " + documento.getId() + " previamente.");
		}
	}
}
