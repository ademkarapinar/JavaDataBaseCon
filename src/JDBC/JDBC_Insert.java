package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Insert {

	public static void main(String[] args) throws SQLException {

		Connection con = null;
		Statement stm = null;
		ResultSet resultSet = null;
		// the format for jdbc:mysql://hostname:port/databaseName
		String url = "jdbc:mysql://localhost:3306/ebookshop" + "?serverTimezone=UTC";
		String username = "root";
		String password = "12345";

		try {
			con = DriverManager.getConnection(url, username, password);
			stm = con.createStatement();
			
			//insert a record
			String sqlInsert = "insert into book values (6, 'Gone Fishing' , 'Jack Jones' , 20.20 , 66);";
			System.out.println("SQL Statement is "+sqlInsert + "\n");
			
			int countInserted = stm.executeUpdate(sqlInsert);
			System.out.println(countInserted + "rows inserted");
			
			// INSERT multiple records
			sqlInsert = "insert into books values " + "(7, 'Anna Karenina', 'Leo Tolstoy', 25.25, 22), "
					+ "(8, 'Crime and Punishment', 'Dostoevsky', 30.50, 44)";
			System.out.println("The SQL statement is " + sqlInsert + "\n");
			countInserted = stm.executeUpdate(sqlInsert);
			System.out.println(countInserted + " rows inserted\n");
			resultSet = stm.executeQuery("select * from books");
			
		} catch (Exception e) {
			System.out.println("Error connecting to the database!");
			e.printStackTrace();
		} finally {
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
