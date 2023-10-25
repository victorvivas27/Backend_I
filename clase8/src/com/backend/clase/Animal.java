package com.backend.clase;

import org.apache.log4j.Logger;

import java.sql.*;

public class Animal {

	public static void main(String[] args) {
		Logger LOGGER = Logger.getLogger(Animal.class);

		// Definimos las consultas SQL
		String create = "DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES (ID INT " +
				"AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(50) NOT NULL, TIPO VARCHAR(50) NOT NULL)";

		String insert = "INSERT INTO ANIMALES (NOMBRE, TIPO) VALUES " +
				"('Firulais', 'Perro'),('Whiskers', 'Gato'),('Rex', 'Perro'),('Tweety', 'Canario'),('Donatello', 'Tortuga')";

		String delete = "DELETE  FROM ANIMALES WHERE ID = 1";
		String select = "SELECT * FROM ANIMALES";
		Connection connection = null;

		try {
			// Establecemos una conexión a la base de datos
			connection = getConnection();
			Statement statement = connection.createStatement();

			// Paso 1: Ejecutar la consulta para crear la tabla ANIMALES (si no existe)
			statement.execute(create);

			// Paso 2: Insertar registros en la tabla ANIMALES
			statement.execute(insert);
			ResultSet resultSet = statement.executeQuery(select);
			LOGGER.info("Animales en la base de datos:");

			// Paso 3: Mostrar los animales en la base de datos
			while (resultSet.next()) {
				LOGGER.info("Animal: " + resultSet.getString("nombre") + "  -  " + resultSet.getString(3));
			}

			// Paso 4: Ejecutar la consulta para eliminar un registro
			statement.execute(delete);
			LOGGER.info("------------------------------------------------------------------------------------------------------------------------------");

			// Paso 5: Mostrar los animales restantes en la base de datos
			resultSet = statement.executeQuery(select);
			while (resultSet.next()) {
				LOGGER.info("Animal: " + resultSet.getString("nombre") + "  -  " + resultSet.getString(3));
			}

		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
		} finally {
			try {
				// Cerramos la conexión
				connection.close();
			} catch (Exception exception) {
				LOGGER.error(exception.getMessage());
			}
		}
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// Establecemos una conexión a la base de datos H2
		Class.forName("org.h2.Driver");
		return DriverManager.getConnection("jdbc:h2:~/BdAnimal", "sa", "sa");
	}
}