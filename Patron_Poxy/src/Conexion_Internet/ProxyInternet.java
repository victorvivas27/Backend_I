package Conexion_Internet;

import java.util.List;

public class ProxyInternet  implements  IConexionInternet{
	private  InternetService internetService;
	private List<String> sitiosBloqueados ;

	public ProxyInternet(InternetService internetService, List<String> sitiosBloqueados) {
		this.internetService = internetService;
		this.sitiosBloqueados = sitiosBloqueados;
	}

	@Override
	public void conectarCon(String url) {
		if (!this.sitiosBloqueados.contains(url)){
			this.internetService.conectarCon(url);
		}else {
			System.out.println("Acceso denegado");
		}
	}
}
