package logica;

import java.util.ArrayList;
import java.util.List;

public class EjercicioVideoJuegos {
	public static void main(String[] args) {

		List<VideoJuego> listaVideosJuegos = new ArrayList<VideoJuego>();
		VideoJuego video1 = new VideoJuego(12338, "Banjo Kazooie", "Nintendo 64", 4, "Plataforma");
		VideoJuego video2 = new VideoJuego(283746, "Mario Party", "Nintendo x", 2, "Plataforma");
		VideoJuego video3 = new VideoJuego(87756464, "Age of Empire II", "Pc", 4, "Estrategia");
		VideoJuego video4 = new VideoJuego(8922394, "Counter Strike 1.6", "Nintendo 64", 3, "Shooter");
		listaVideosJuegos.add(video1);
		listaVideosJuegos.add(video2);
		listaVideosJuegos.add(video3);
		listaVideosJuegos.add(video4);

		for (VideoJuego video : listaVideosJuegos) {
			System.out.println("Titulo:  " + video.getNombre() + " Consola:  " + video.getConsola() + " Cantidad juagadores :  " + video.getCantJuagadores());

		}
		video1.setNombre("Banjo Kazooie II");
		video1.setCantJuagadores(1);
		video4.setNombre("Super mario Kart 64");
		video4.setCantJuagadores(4);

		for (VideoJuego video : listaVideosJuegos) {
			if (video.getConsola().equals("Nintendo 64")) {
				System.out.println(video.toString());
			}
		}
	}
}