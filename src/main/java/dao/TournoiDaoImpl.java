package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import beans.Tournoi;

public class TournoiDaoImpl implements TournoiDao {
	

	public TournoiDaoImpl() {
	}

	@Override
	public void ajouterT(Tournoi tournoi) {
		DaoFactory df = DaoFactory.instanceDaoF();
		
		String query = "INSERT INTO `TOURNOI`(ID,NOM,CODE) VALUES " + "( ?, ?, ?);";
		
		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, tournoi.getId());
			ps.setString(2, tournoi.getNom());
            ps.setString(3, tournoi.getCode());
            ps.executeUpdate();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Tournoi> listerT() {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "SELECT * FROM Tournoi;";
		List<Tournoi> list = new ArrayList<Tournoi>();
		
		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);
	        ResultSet rs= ps.executeQuery(); 
	        while(rs.next()){
	        	Tournoi tournoi = new Tournoi();
	        	tournoi.setId(rs.getInt("ID"));
	        	tournoi.setNom(rs.getString("NOM"));
	        	tournoi.setCode(rs.getString("CODE"));
	            list.add(tournoi);
	        }
	        return list;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public Tournoi lectureT(int id) {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "SELECT * FROM Tournoi WHERE ID = " + id + ";";
		Tournoi tournoi = new Tournoi();
		
		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);
	        ResultSet rs= ps.executeQuery(); 
	        while(rs.next()){
	        	tournoi.setId(rs.getInt("ID"));
	        	tournoi.setNom(rs.getString("NOM"));
	        	tournoi.setCode(rs.getString("CODE"));
	        }
            return tournoi;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public boolean supprimerT(int id) {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "DELETE from Tournoi where ID = ?;";

		
	    try {
	        Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
            boolean row = ps.executeUpdate() > 0;
	        System.out.print("row");
	        return row;
	        } catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@Override
	public void modifierT(Tournoi tournoi) {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "UPDATE Tournoi set nom = ?, code = ? where id =?;";
		
		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1,tournoi.getNom());
            ps.setString(2,tournoi.getCode());
            ps.setInt(3,tournoi.getId());
            ps.executeUpdate();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public List<Tournoi> chercherT(String txt) {
		DaoFactory df = DaoFactory.instanceDaoF();
		List<Tournoi> result = new ArrayList<Tournoi>();
		//System.out.println(query);
		
		try {
			Connection conn = df.getConn();
			String query = "SELECT * FROM Tournoi WHERE nom LIKE ? OR code LIKE ?;";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%" + txt + "%");
			ps.setString(2, "%" + txt + "%");
			
	        ResultSet rs= ps.executeQuery();

	        while(rs.next()){
	        	Tournoi tournoi= new Tournoi();
	        	tournoi.setId(rs.getInt("ID"));
	        	tournoi.setNom(rs.getString("NOM"));
	        	tournoi.setCode(rs.getString("CODE"));
	            result.add(tournoi);
	        }
	        System.out.println(result);
	        return result;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
