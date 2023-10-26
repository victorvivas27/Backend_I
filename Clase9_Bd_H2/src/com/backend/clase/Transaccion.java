package com.backend.clase;

import com.backend.clase.dbConnection.H2Connection;
import com.backend.clase.model.Cuenta;
import org.apache.log4j.Logger;

import java.sql.*;

public class Transaccion {
	private static final Logger LOGGER = Logger.getLogger(Transaccion.class);
	private static final String CREATE = "DROP TABLE IF EXISTS CUENTAS; " +
			"CREATE TABLE CUENTAS(ID INT PRIMARY KEY AUTO_INCREMENT," +
			"NOMBRE VARCHAR(100) NOT NULL,NUMERO_CUENTA INT NOT NULL,SALDO NUMERIC(10,2)NOT NULL)";
	private static final String INSERT = "INSERT INTO CUENTAS(NOMBRE,NUMERO_CUENTA,SALDO) VALUES(?,?,?)";
	private static final String UPDATE = "UPDATE CUENTAS SET SALDO=? WHERE NUMERO_CUENTA=?";
	private static final String SELECT = "SELECT*FROM CUENTAS WHERE  NUMERO_CUENTA=?";

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Cuenta cuenta1 = null;
		Cuenta cuenta=new Cuenta("Victor",37846363,5000);
		try {
			connection = H2Connection.getConnection();
			connection.setAutoCommit(false);
			//Creamos la tabla
			Statement statement = connection.createStatement();
			statement.execute(CREATE);
			//Insertar datos
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1,cuenta.getNombre());
			preparedStatement.setInt(2,cuenta.getNumeroCuenta());
			preparedStatement.setDouble(3,cuenta.getSaldo());
			preparedStatement.execute();
			//Agregar 10 al saldo
			PreparedStatement preparedStatementUpdate = connection.prepareStatement(UPDATE);
			preparedStatementUpdate.setDouble(1,cuenta.getSaldo()+10);
			preparedStatementUpdate.setInt(2,cuenta.getNumeroCuenta());
			preparedStatementUpdate.execute();
			cuenta.setSaldo(cuenta.getSaldo()+10);

			PreparedStatement preparedStatementUpdate2 = connection.prepareStatement(UPDATE);
			preparedStatementUpdate2.setDouble(1,cuenta.getSaldo()+15);
			preparedStatementUpdate2.setInt(2,cuenta.getNumeroCuenta());
			preparedStatementUpdate2.execute();
           //Optener los datos y mostrarlos
			PreparedStatement preparedStatementSelect = connection.prepareStatement(SELECT);
			preparedStatementSelect.setInt(1,cuenta.getNumeroCuenta());
			ResultSet resultSet =preparedStatementSelect.executeQuery();
			while (resultSet.next()){
				cuenta1 =new Cuenta(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getInt(3),resultSet.getDouble(4));
				LOGGER.info(cuenta1);
			}
			connection.commit();
			// Código que puede lanzar excepciones
		} catch (Exception exception) {
			// Captura cualquier excepción que ocurra
			LOGGER.error(exception.getMessage()); // Registra el mensaje de error

			if (connection != null) { // declaración condicional que verifica si la variable
				// connection no es nula antes de ejecutar cierto código.
				try {
					// Intenta realizar un "rollback" en la base de datos
					connection.rollback();
					exception.printStackTrace(); // Imprime la traza de la excepción
					LOGGER.error(exception.getMessage()); // Registra el mensaje de error
				} catch (SQLException sqlException) {
					LOGGER.error(sqlException.getMessage()); // Registra el mensaje de error de SQL
				}
			}
		} finally {
			try {
				// Cierra la conexión de la base de datos (siempre se ejecutará)
				connection.close();
			} catch (Exception exception) {
				LOGGER.error(exception.getMessage()); // Registra el mensaje de error al cerrar la conexión
			}
		}
	}
}
