import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class TestLog {
	public static void main(String[] args) {
		try {
			// Datos de conexión a MySQL
			String url = "jdbc:mysql://localhost/";
			String usuario = "root";
			String contraseña = "Theo2019amiel";

			Connection con = DriverManager.getConnection(url, usuario, contraseña);
			Statement stmt = con.createStatement();

			// Código para crear la base de datos si no existe
			String createDatabaseSql = "CREATE DATABASE IF NOT EXISTS test";
			stmt.execute(createDatabaseSql);

			// Seleccionar la base de datos
			String useDatabaseSql = "USE test";
			stmt.execute(useDatabaseSql);

			// Código para crear una tabla y realizar inserciones
			String createTableSql = "CREATE TABLE IF NOT EXISTS TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));";
			stmt.execute(createTableSql);

			String insertDataSql1 = "INSERT INTO TEST(ID, NAME) VALUES(3, 'Hello');";
			stmt.execute(insertDataSql1);

			String insertDataSql2 = "INSERT INTO TEST(ID, NAME) VALUES(4, 'World');";
			stmt.execute(insertDataSql2);

			// Cerrar la conexión
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}