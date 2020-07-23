package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Update {

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
			
			String sqlUpdate = "update books set price = price * 0.9, qty = qty + 5 where id = 1";
			System.out.println("The SQL Statement is "+sqlUpdate);
			stm.executeUpdate(sqlUpdate);
			
			//Increase the price by 50% "A cup of java 
			String sqlUpdate2 = "update books set price = price * 1.5 where id = 4";
			System.out.println("The SQL Statement is "+sqlUpdate2);
			stm.executeUpdate(sqlUpdate2);
			System.out.println();
			
			resultSet = stm.executeQuery("select * from books");
			
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + ", " + resultSet.getString("title")
								+ ", " + resultSet.getString("author") 
								+ ", " + resultSet.getDouble("price")
								+ ", " + resultSet.getInt("qty")
						);
			}
			
			//CRUD CREATE,READ,UPDATE,DELETE
			//INSERT -CREATE
			//SELECT -READ
			//UPDATE-UPDATE
			//DELETE-DELETE
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


