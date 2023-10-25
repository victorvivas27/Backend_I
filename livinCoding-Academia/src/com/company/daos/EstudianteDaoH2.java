package com.company.daos;

import com.company.entidades.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDaoH2 implements IDao<Estudiante> {
	private static final String DB_JDBC_DRIVER = "org.h2.Driver";
	private static final String DB_URL = "jdbc:h2:~/bd_estudiante";
	private static final String DB_USER = "sa";
	private static final String DB_PASSWORD = "";

	@Override
	public Estudiante guardar(Estudiante estudiante) {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ESTUDIANTES VALUES (?,?,?)")) {
			preparedStatement.setLong(1, estudiante.getId());
			preparedStatement.setString(2, estudiante.getNombre());
			preparedStatement.setString(3, estudiante.getApellido());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estudiante;
	}

	@Override
	public void eliminar(Long id) {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			 PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ESTUDIANTES WHERE id = ?")) {
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Estudiante buscar(Long id) {
		Estudiante estudiante = null;
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ESTUDIANTES WHERE id = ?")) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Long idEstudiante = resultSet.getLong("id");
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				estudiante = new Estudiante();
				estudiante.setId(idEstudiante);
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estudiante;
	}

	@Override
	public List<Estudiante> buscarTodo() {
		List<Estudiante> estudiantes = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ESTUDIANTES");
			 ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				Long idEstudiante = resultSet.getLong("id");
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				Estudiante estudiante = new Estudiante();
				estudiante.setId(idEstudiante);
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiantes.add(estudiante);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estudiantes;
	}
}