package com.utilidades;
import com.model.Estudiante;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDaoH2 implements IDao<Estudiante> {
	private static final String DB_JDBC_DRIVER = "org.h2.Driver";
	private static final String DB_URL = "jdbc:h2:~/prueba2";
	private static final String DB_USER = "sa";
	private static final String DB_PASSWORD = "";

	public EstudianteDaoH2() {

	}
	private void crearTablaSiNoExiste() {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			 Statement statement = connection.createStatement()) {
			// Utiliza "IF NOT EXISTS" para evitar errores si la tabla ya existe
			statement.execute("CREATE TABLE IF NOT EXISTS ESTUDIANTES (" +
					"ID INT PRIMARY KEY, " +
					"NOMBRE VARCHAR(255), " +
					"APELLIDO VARCHAR(255))");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al crear la tabla ESTUDIANTES en la base de datos.", e);
		}
		return;
	}

	@Override
	public Estudiante guardar(Estudiante estudiante) {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ESTUDIANTES VALUES(?,?,?)")) {

			preparedStatement.setLong(1, estudiante.getId());
			preparedStatement.setString(2, estudiante.getNombre());
			preparedStatement.setString(3, estudiante.getApellido());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al guardar el estudiante en la base de datos.", e);
		}
		return estudiante;
	}

	@Override
	public void eliminar(Long id) {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			 PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ESTUDIANTES WHERE ID = ?")) {

			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al eliminar el estudiante de la base de datos.", e);
		}
	}

	@Override
	public Estudiante buscar(Long id) {
		Estudiante estudiante = null;
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			 PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, NOMBRE, APELLIDO FROM ESTUDIANTES WHERE ID = ?")) {

			preparedStatement.setLong(1, id);
			try (ResultSet result = preparedStatement.executeQuery()) {
				while (result.next()) {
					Long idEstudiante = result.getLong("ID");
					String nombre = result.getString("NOMBRE");
					String apellido = result.getString("APELLIDO");
					estudiante = new Estudiante(idEstudiante, nombre, apellido);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al buscar el estudiante en la base de datos.", e);
		}
		return estudiante;
	}

	@Override
	public List<Estudiante> buscarTodos() {
		List<Estudiante> estudiantes = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ESTUDIANTES");
			 ResultSet result = preparedStatement.executeQuery()) {

			while (result.next()) {
				Long id = result.getLong("ID");
				String nombre = result.getString("NOMBRE");
				String apellido = result.getString("APELLIDO");
				estudiantes.add(new Estudiante(id, nombre, apellido));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al buscar todos los estudiantes en la base de datos.", e);
		}
		return estudiantes;
	}
}