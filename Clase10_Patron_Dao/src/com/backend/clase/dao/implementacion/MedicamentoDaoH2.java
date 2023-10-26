package com.backend.clase.dao.implementacion;

import com.backend.clase.dao.H2connection;
import com.backend.clase.dao.IDao;
import com.backend.clase.model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDaoH2 implements IDao<Medicamento> {
	private final Logger LOGGER = Logger.getLogger(MedicamentoDaoH2.class);

	@Override
	public Medicamento registrar(Medicamento medicamento) {
		Connection connection = null;
		Medicamento medicamentoPersistido = null;
		try {
			connection = H2connection.getConnection();
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MEDICAMENTOS" +
							"(CODIGO,NOMBRE,LABORATORIO,CANTIDAD,PRECIO) VALUES(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, medicamento.getCodigo());
			preparedStatement.setString(2, medicamento.getNombre());
			preparedStatement.setString(3, medicamento.getLaboratorio());
			preparedStatement.setInt(4, medicamento.getCantidad());
			preparedStatement.setDouble(5, medicamento.getPrecio());
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			while (resultSet.next()) {
				medicamentoPersistido = new Medicamento(resultSet.getInt(1), medicamento.getCodigo(), medicamento.getNombre(),
						medicamento.getLaboratorio(), medicamento.getCantidad(), medicamento.getPrecio());
			}
			LOGGER.info("Medicamento guardado: " + medicamentoPersistido);

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
				LOGGER.error("No se pudo cerrar la conexion: " + exception.getMessage());
			}
		}
		return medicamentoPersistido;
	}


	@Override
	public Medicamento buscarPorId(int id) {
		Medicamento medicamento = null;
		Connection connection = null;
		try {
			connection = H2connection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement
					("SELECT * FROM MEDICAMENTOS WHERE ID=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				medicamento = crearObjetoMedicamento(resultSet);
			}
			LOGGER.info("Se a encontrado el medicamento: " + medicamento);


			connection.commit();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			exception.printStackTrace();

		} finally {
			try {
				connection.close();
			} catch (Exception exception) {
				LOGGER.error("No se pudo cerrar la conexión: " + exception.getMessage());
			}
		}
		return medicamento;
	}

	@Override
	public Medicamento eliminar(int id) {
		Connection connection = null;
		Medicamento medicamentoEliminado = null;
		try {
			connection = H2connection.getConnection();
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement
					("DELETE FROM MEDICAMENTOS WHERE ID=?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			LOGGER.info("Medicamento eliminado con ID: " + id);
			connection.commit();
			medicamentoEliminado = buscarPorId(id);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			exception.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
					LOGGER.error("Tuvimos un problema al eliminar el medicamento");
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
		return medicamentoEliminado;
	}

	@Override
	public List<Medicamento> buscarTodo() {
		List<Medicamento> medicamentos = new ArrayList<>();
		Connection connection = null;
		try {
			connection = H2connection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MEDICAMENTOS");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Medicamento medicamento = crearObjetoMedicamento(resultSet);
				medicamentos.add(medicamento);
			}
			LOGGER.info("Se encontraron " + medicamentos.size() + " medicamentos.");
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			exception.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception exception) {
				LOGGER.error("No se pudo cerrar la conexión: " + exception.getMessage());
			}
		}
		return medicamentos;
	}
	private Medicamento crearObjetoMedicamento(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String nombre = resultSet.getString("nombre");
		int codigo = resultSet.getInt("codigo");
		String laboratorio = resultSet.getString("laboratorio");
		int cantidad = resultSet.getInt("cantidad");
		double precio = resultSet.getDouble("precio");
		return new Medicamento(id, codigo, nombre, laboratorio, cantidad, precio);
	}
}
