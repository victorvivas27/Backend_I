package Spotify_Usuario;

public class ServicioDescargaProxy implements ServicioDescarga {
	private SpotifyService servicioReal;

	public ServicioDescargaProxy() {
		this.servicioReal = new SpotifyService();
	}

	@Override
	public void descargar() {
		Usuario usuario = optenerUsuario();
		if (usuario != null && servicioReal.checkUsuarioPremium(usuario)) {
			servicioReal.descargar();
		}else {
			System.out.println("No se puede descargar la canción. Debes ser un usuario Premium.");
		}
	}


	private Usuario optenerUsuario() {
		return new Usuario(1, TipoUsuario.Premium);
	}
}
