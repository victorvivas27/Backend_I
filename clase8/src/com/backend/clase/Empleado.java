package com.backend.clase;

import org.apache.log4j.Logger;

import java.sql.*;

public class Empleado {
	public static void main(String[] args) {
		Logger LOOGER = Logger.getLogger(Empleado.class);
		String create = "DROP TABLE IF EXISTS EMPLEADOS ;CREATE TABLE EMPLEADOS (ID INT AUTO_INCREMENT  PRIMARY KEY ,NOMBRE  VARCHAR (255)" +
				" NOT NULL,EDAD INT NOT NULL,EMPRESA VARCHAR(255), FECHAINICIO DATE) ";
		String insert = " INSERT INTO EMPLEADOS  (NOMBRE,EDAD,EMPRESA,FECHAINICIO) VALUES" +
				"('Victor Vivas',44,'DigitalHouse','2023-01-01')," +
				"('Yanina Jurez',38,'Google','2018-09-02'),('Carlor Fermin',65,'Facebook','2015-07-02')";
		String select = " SELECT*FROM EMPLEADOS";
		Connection connection = null;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			statement.execute(create);
			statement.execute(insert);
			ResultSet resultSet = statement.executeQuery(select);
			LOOGER.info("Empleado insertado en base de datos");
			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String nombre = resultSet.getString("Nombre");
				int edad = resultSet.getInt("Edad");
				String empresa = resultSet.getString("Empresa");
				String fechaInicio = resultSet.getString("FechaInicio");
				LOOGER.info("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Empresa: " + empresa + ", Fecha de inicio: " + fechaInicio);
			}


		} catch (Exception exception) {
			LOOGER.error(exception.getMessage());

		}


	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		return DriverManager.getConnection("jdbc:h2:~/BdEmpleado", "sa", "sa");

	}
}
