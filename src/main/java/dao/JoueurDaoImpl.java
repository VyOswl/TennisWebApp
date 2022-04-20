package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import beans.Joueur;

public class JoueurDaoImpl implements JoueurDao {
	

	public JoueurDaoImpl() {
	}

	@Override
	public void ajouter(Joueur joueur) {
		DaoFactory df = DaoFactory.instanceDaoF();
		
		String query = "INSERT INTO `JOUEUR`(ID,NOM,PRENOM,SEXE) VALUES " + "( ?, ?, ?,?);";
		
		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, joueur.getId());
			ps.setString(2, joueur.getNom());
            ps.setString(3, joueur.getPrenom());
            ps.setString(4, joueur.getSexe());
            ps.executeUpdate();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Joueur> lister() {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "SELECT * FROM JOUEUR;";
		List<Joueur> list = new ArrayList<Joueur>();
		
		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);
	        ResultSet rs= ps.executeQuery(); 
	        while(rs.next()){
	        	Joueur joueur = new Joueur();
	        	joueur.setId(rs.getInt("ID"));
	        	joueur.setNom(rs.getString("NOM"));
	        	joueur.setPrenom(rs.getString("PRENOM"));
	        	joueur.setSexe(rs.getString("SEXE"));
	            list.add(joueur);
	        }
	        return list;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
        
		/*
		Joueur p1  = new Joueur(7, "Han", "Solo", "H");
		Joueur p2 = new Joueur(8, "Luke", "Skywalker", "H");
		Joueur p3 = new Joueur(9, "Peter", "Pan", "H");
		Joueur p4 = new Joueur(10, "Vy", "Phan", "F");
		List<Joueur> list = new ArrayList<Joueur>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		*/
		
	}

	
	@Override
	public Joueur lecture(int id) {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "SELECT * FROM joueur WHERE ID = " + id + ";";
		Joueur joueur = new Joueur();
		
		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);
	        ResultSet rs= ps.executeQuery(); 
	        while(rs.next()){
	        	joueur.setId(rs.getInt("ID"));
	        	joueur.setNom(rs.getString("NOM"));
	        	joueur.setPrenom(rs.getString("PRENOM"));
	        	joueur.setSexe(rs.getString("SEXE"));
	        }
            return joueur;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	

	@Override
	public void supprimer(int id) {
		DaoFactory df = DaoFactory.instanceDaoF();
		String q1 = "SET FOREIGN_KEY_CHECKS = 0;",
				q2 = "DELETE from JOUEUR where ID = ?;",
				q3 = "SET FOREIGN_KEY_CHECKS = 1";

		
	    try {
	        Connection conn = df.getConn();
			PreparedStatement ps1 = conn.prepareStatement(q1);
			PreparedStatement ps2 = conn.prepareStatement(q2);
			PreparedStatement ps3 = conn.prepareStatement(q3);
			
			ps2.setInt(1, id);
			ps1.executeUpdate();
			ps2.executeUpdate();
			ps3.executeUpdate();
           /* boolean row = ps.executeUpdate() > 0;
	        //System.out.print("row");
	        return row; */
	        } catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@Override
	public void modifier(Joueur joueur) {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "UPDATE JOUEUR set nom = ?, prenom = ?, sexe = ? where id =?;";
		
		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, joueur.getNom());
            ps.setString(2, joueur.getPrenom());
            ps.setString(3, joueur.getSexe());
            ps.setInt(4, joueur.getId());
            ps.executeUpdate();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public List<Joueur> chercher(String txt) {
		DaoFactory df = DaoFactory.instanceDaoF();
		//String query = "SELECT * FROM JOUEUR WHERE NOM LIKE '%" + txt + "%' OR PRENOM LIKE '%" + txt + "%';";
		List<Joueur> result = new ArrayList<Joueur>();
		//System.out.println(query);
		
		try {
			Connection conn = df.getConn();
			String query = "SELECT * FROM JOUEUR WHERE NOM LIKE ? OR PRENOM LIKE ?;";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%" + txt + "%");
			ps.setString(2, "%" + txt + "%");
			
	        ResultSet rs= ps.executeQuery();

	        while(rs.next()){
	        	Joueur player = new Joueur();
	        	player.setId(rs.getInt("ID"));
	        	player.setNom(rs.getString("NOM"));
	        	player.setPrenom(rs.getString("PRENOM"));
	        	player.setSexe(rs.getString("SEXE"));
	            result.add(player);
	        }
	        //System.out.println(result);
	        return result;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Joueur searchFvsH(int id) {
		DaoFactory df = DaoFactory.instanceDaoF();
		Joueur player = new Joueur();
		
		try {
			Connection conn = df.getConn();
			String query = "SELECT * FROM joueur WHERE id = ?;";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
	        ResultSet rs= ps.executeQuery();

	        while(rs.next()){
	        	player.setId(rs.getInt("ID"));
	        	player.setNom(rs.getString("NOM"));
	        	player.setPrenom(rs.getString("PRENOM"));
	        	player.setSexe(rs.getString("SEXE"));
	        }
	        System.out.println(player);
	        return player;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
