import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {
	public static void main(String[] args) throws Exception {
		Class.forName("org.h2.Driver").newInstance();
		Connection connection = DriverManager.getConnection(" jdbc:h2:file:C:\\Users\\i78th\\OneDrive\\Desktop\\Base\\","victor","");
		Statement statement = connection.createStatement();
		String createTable = "DROP TABLE IF EXISTS TEST; CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(250)";
		statement.execute(createTable);
		String insertarFila = "INSERT INTO TEST VALUE(1,'HOLA')";
		String insertarFila2= "INSERT INTO TEST VALUE(2,'CHAU')";
		statement.execute(insertarFila);
		statement.execute(insertarFila2);
		String sql= " SELECT * FROM TEST";
		ResultSet rd = statement.executeQuery(sql);
		while (rd.next()){
			System.out.println(rd.getInt(1) +rd.getString(2));
		}

	}
}
