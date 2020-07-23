package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Delete {

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
			
			//write a statement to delete from books where ids are 2,3
			String sqlDelete = "delete from books where id >= 2 and id<4";
			System.out.println("The SQL Statement is "+sqlDelete);
			
			int countDeleted = stm.executeUpdate(sqlDelete);
			System.out.println(countDeleted + " rows deleted\n");
			
			resultSet = stm.executeQuery("select * from books");
			
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + ", " + resultSet.getString("title")
								+ ", " + resultSet.getString("author") 
								+ ", " + resultSet.getDouble("price")
								+ ", " + resultSet.getInt("qty")
						);
			}
			
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
