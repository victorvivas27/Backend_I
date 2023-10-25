package com.backend.clase;

import org.apache.log4j.Logger;

import java.sql.*;

public class TestUsuario {

	private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS  USUARIO; CREATE TABLE USUARIO" +
			"(" +
			"ID INT PRIMARY KEY," +
			"NOMBRE VARCHAR(100) NOT NULL," +
			"EMAIL VARCHAR(100) NOT NULL," +
			"SUELDO NUMERIC(15,2) NOT NULL" +
			")";
	private static final String SQL_INSERT = "INSERT INTO USUARIO (ID,NOMBRE,EMAIL,SUELDO) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE USUARIO SET SUELDO=? WHERE EMAIL=?";
	private  static  	Logger LOGGER = Logger.getLogger(TestUsuario.class);

	public static void main(String[] args) throws SQLException {

		Usuario usuario = new Usuario("Victor","victoryeyo@gmail.com",10d);
		Connection connection= null;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			statement.execute(SQL_TABLE_CREATE);
			PreparedStatement preparedStatement= connection.prepareStatement(SQL_INSERT);
			preparedStatement.setInt(1,1);
			preparedStatement.setString(2, usuario.getNombre());
			preparedStatement.setString(3, usuario.getEmail());
			preparedStatement.setDouble(4,usuario.getSueldo());
			preparedStatement.execute();
			connection.setAutoCommit(false);
			LOGGER.info("Empleado insertado en base de datos: ");

			PreparedStatement preparedUpdate= connection.prepareStatement(SQL_UPDATE);
			preparedUpdate.setDouble(1,usuario.subirSueldo(10d));
			preparedUpdate.setString(2, usuario.getEmail());
			preparedUpdate.execute();
			connection.commit();
			connection.setAutoCommit(true);
			String query= "SELECT*FROM USUARIO";
			Statement statement1 = connection.createStatement();
			ResultSet resultSet=statement1.executeQuery(query);
			while (resultSet.next()){
				LOGGER.info(resultSet.getInt(1) + resultSet.getString(2) + resultSet.getString(3) + resultSet.getString(4));
			}

		}catch (Exception exception){
LOGGER.error(exception.getMessage());
		}finally {
connection.close();
		}
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		return DriverManager.getConnection("jdbc:h2:~/Usuario", "sa", "sa");
	}
}
