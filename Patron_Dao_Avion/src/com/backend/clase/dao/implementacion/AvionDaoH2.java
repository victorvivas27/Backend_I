package com.backend.clase.dao.implementacion;

import com.backend.clase.dao.H2connection;
import com.backend.clase.dao.IDao;
import com.backend.clase.model.Avion;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;


public class AvionDaoH2 implements IDao<Avion> {
	private final Logger LOGGER = Logger.getLogger(AvionDaoH2.class);
	private final String SQL_INSERT_AVION = "INSERT INTO Aviones " +
			"(Marca, Modelo, Matricula, FechaEntradaServicio) VALUES (?,?,?,?)";


	@Override
	public Avion registrarAvion(Avion avion) {
		Connection connection = null;
		Avion avionPersistido = null;
		try {
			connection = H2connection.getConnection();
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_AVION, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, avion.getMarca());
			preparedStatement.setString(2, avion.getModelo());
			preparedStatement.setString(3, avion.getMatricula());
			preparedStatement.setDate(4, avion.getFechaEntradaServicio());
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			while (resultSet.next()) {
				avionPersistido = new Avion(resultSet.getInt(1), avion.getMarca(),
						avion.getModelo(), avion.getMatricula(), avion.getFechaEntradaServicio().toLocalDate());
			}

			LOGGER.info("Avion guardado: " + avionPersistido);

			connection.commit();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			exception.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
					LOGGER.info("Tuvimos un problema");
					LOGGER.error(exception.getMessage());
					exception.printStackTrace();
				} catch (SQLException sqlException) {
					LOGGER.error(sqlException.getMessage());
					sqlException.printStackTrace();
				}
			}
		} finally {
			try {
				connection.close();
			} catch (Exception exception) {
				LOGGER.error("No se pudo cerrar la conexión: " + exception.getMessage());
			}
		}
		return avionPersistido;
	}


	@Override
	public Avion buscarAvionPorId(int id) {
		return null;
	}

	@Override
	public Avion eliminarAvion(int id) {
		return null;
	}

	@Override
	public List<Avion> buscarTodosAviones() {
		return null;
	}
}
