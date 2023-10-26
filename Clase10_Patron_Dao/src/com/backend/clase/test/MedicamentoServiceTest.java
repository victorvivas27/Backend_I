import com.backend.clase.dao.implementacion.MedicamentoDaoH2;
import com.backend.clase.model.Medicamento;
import com.backend.clase.service.MedicamentoService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.assertNotNull;

public class MedicamentoServiceTest {
	private MedicamentoService medicamentoService;

	@BeforeAll
	static void doBefore() {
		try (Connection connection = DriverManager.getConnection("jdbc:h2:~/medica;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa")) {
			// El bloque try-with-resources se encargará de cerrar la conexión automáticamente
		} catch (Exception exception) {
			// Maneja la excepción adecuadamente, por ejemplo, registrándola o notificando
			exception.printStackTrace();
		}
	}

	@Test
	public void deberiaAgregarYRetornarUnMedicamentoEnH2() {
		medicamentoService = new MedicamentoService(new MedicamentoDaoH2());
		Medicamento medicamento = new Medicamento
				(45556, "Aaspirina", "Bayer", 50, 200);
		Medicamento medicamentoPersistido = medicamentoService.registrarMedicamento(medicamento);
		assertNotNull(medicamentoPersistido.getId());
	}
}