package Spotify_Usuario;

public class SpotifyService  implements  ServicioDescarga{
	@Override
	public void descargar() {
		System.out.println("Descargando la canción de Spotify");

	}
	boolean checkUsuarioPremium(Usuario usuario){
		return  usuario.getTipoUsuario()==TipoUsuario.Premium;
	}
}
