package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_Test {
	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		Statement stm = null;
		ResultSet resultSet = null;
		// the format for jdbc:mysql://hostname:port/databaseName
		String url = "jdbc:mysql://localhost:3306/ebookshop" +"?serverTimezone=UTC";
		String username = "root";
		String password = "12345";
		
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to Database");
			
			//Allocate a 'Statement Object' in the connection
			stm= con.createStatement();
			
			String select = "select * from books";
			System.out.println("The sql staatement is :"+ select);
			//execute sql select query. the reslut is returned in a resultSet Object
			resultSet = stm.executeQuery(select);
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString("title") + " - " + resultSet.getString("author"));
			}
		} catch (Exception e) {
			System.out.println("Error connecting to the database!");
			e.printStackTrace();
		}
		finally {
			if (con != null) {
				con.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		}
	}
}