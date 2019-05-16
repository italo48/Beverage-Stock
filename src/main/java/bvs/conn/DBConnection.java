package bvs.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private Connection c;

	public DBConnection(Connection conn) {
		this.c = conn;
	}
	
	public Connection conn() {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BeverageStock", "postgres", "123456");
			System.out.println("Open connection");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return c;
	}

	public void closeConn() {
		try {
			c.close();
			System.out.println("Close connection");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}