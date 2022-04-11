package dao;

import java.sql.*;

import beans.User;

public class UserDaoImpl {
	private DaoFactory df;

	public UserDaoImpl(DaoFactory df) {
		super();
		this.df = df;
	}

	public DaoFactory getDf() {
		return df;
	}

	public void setDf(DaoFactory df) {
		this.df = df;
	}
	
	public User isValidLogin(String login, String password) {
		Connection conn = null;
		PreparedStatement s = null;
		
		try {
			conn = df.getConn();
			s = conn.prepareStatement("SELECT * FROM connexion WHERE login=? AND password=?");
			s.setString(1,login);
			s.setString(2, password);
			
			ResultSet rs = s.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String loginVar = rs.getString("login");
				String passwordVar = rs.getString("password");
				int profilVar = rs.getInt("profil");
				
				User user = new User(id, loginVar, passwordVar, profilVar);
				return user;
				
			} else {
				return null;
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	 public String register(String login, String password, int profil) {

         Connection conn = null;
         PreparedStatement s = null;
         
         try {
        	 conn = df.getConn();
        	 s = conn.prepareStatement("INSERT into connexion(login, password, profil) values (?, ?, ?);");
        	 
        	 s.setString(1,login);
 			 s.setString(2, password);
 			 s.setInt(3, profil);

             int i= s.executeUpdate();
             
             if (i!=0)  //Just to ensure data has been inserted into the database
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
     }

}
