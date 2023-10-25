import com.company.daos.EstudianteDaoH2;
import com.company.entidades.Estudiante;
import com.company.service.EstudianteService;

public class Main {
	public static void main(String[] args) {
		Estudiante estudiante = new Estudiante();
		estudiante.setId(1L);
		estudiante.setNombre("Victor");
		estudiante.setApellido("Vivas");
		EstudianteService estudianteService = new EstudianteService();
		estudianteService.setEstudianteIDao(new EstudianteDaoH2());
	estudianteService.guardarEstudiante(estudiante);
	}
}