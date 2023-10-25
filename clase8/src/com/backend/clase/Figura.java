package com.backend.clase;

import org.apache.log4j.Logger;

import java.sql.*;

public class Figura {

	public static void main(String[] args) {
	Logger LOGGER = Logger.getLogger(Figura.class);

		String createTableQuery = "CREATE TABLE IF NOT EXISTS FIGURAS (ID INT AUTO_INCREMENT PRIMARY KEY, FIGURA VARCHAR(50) NOT NULL, COLOR VARCHAR(50) NOT NULL)";
		String insertQuery1 = "INSERT INTO FIGURAS (FIGURA, COLOR) VALUES ('Circulo', 'Rojo')";
		String insertQuery2 = "INSERT INTO FIGURAS (FIGURA, COLOR) VALUES ('Cuadrado', 'Azul')";
		String insertQuery3 = "INSERT INTO FIGURAS (FIGURA, COLOR) VALUES ('Triangulo', 'Verde')";
		String insertQuery4 = "INSERT INTO FIGURAS (FIGURA, COLOR) VALUES ('Circulo', 'Amarillo')";
		String insertQuery5 = "INSERT INTO FIGURA (FIGURA, COLOR) VALUES ('Cuadrado', 'Marron')";
		String selectQuery = "SELECT * FROM FIGURAS";
		Connection connection = null;

		try {
			connection = getConnection();
			Statement statement = connection.createStatement();

			// Crear la tabla ANIMALES si no existe
			statement.execute(createTableQuery);

			// Insertar 5 registros de animales
			statement.executeUpdate(insertQuery1);
			statement.executeUpdate(insertQuery2);
			statement.executeUpdate(insertQuery3);
			statement.executeUpdate(insertQuery4);
			statement.executeUpdate(insertQuery5);

			// Recuperar y mostrar los datos
			ResultSet resultSet = statement.executeQuery(selectQuery);
			LOGGER.info("Figuras en la base de datos:");
			LOGGER.info("------------------------------------------------------------------------------------------------------------------------------");
			while (resultSet.next()) {
				String figura = resultSet.getString("FIGURA");
				String color = resultSet.getString("COLOR");
				LOGGER.info("Figuras: " + figura + ", Color: " + color);
			}
		} catch (Exception exception) {
			LOGGER.error("Error al ejecutar la operación en la base de datos: " + exception.getMessage());
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error("Error al cerrar la conexión a la base de datos: " + e.getMessage());
			}
		}
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		return DriverManager.getConnection("jdbc:h2:~/figura", "sa", "sa");
	}
}
