package dao;

import java.sql.*;
import javax.swing.JOptionPane;

public class DaoFactory {
	private String url;
	private String username;
	private String password;

	public DaoFactory() {
		
		
	}

	public DaoFactory(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static DaoFactory instanceDaoF() {
		String url = "jdbc:mysql://localhost:3306/tennis?serverTimezone=UTC";
		String username = "root";
        String password = "Maivykim#242328";
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Database could not be connected");
			}
			DaoFactory instance = new DaoFactory(url, username, password);
			return instance;
	}
	
	public Connection getConn() throws SQLException {
			Connection conn = DriverManager.getConnection(url, username, password);

			return conn;
            
			/*
            String url = "jdbc:mysql://localhost:3306/tennis";
            String username = "root";
            String password = "Maivykim#242328";
            Connection c;
            Statement s;

            try {
                c = DriverManager.getConnection(url, username, password);
                System.out.println("connected");
                s = c.createStatement();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database could not be connected");
                throw new IllegalStateException("Cannot connect the database!", e);
            }
			return c;
			*/
    }

}
