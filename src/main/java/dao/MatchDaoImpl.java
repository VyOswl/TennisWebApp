package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.Joueur;
import beans.Match;

public class MatchDaoImpl implements MatchDao {

	public MatchDaoImpl() {
	}

	@Override
	public void ajouter(Match match) {
		DaoFactory df = DaoFactory.instanceDaoF();

		String query = "INSERT INTO MATCH_TENNIS (ID,ID_EPREUVE,ID_VAINQUEUR,ID_FINALISTE) VALUES " + "( ?, ?, ?,?);";

		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, match.getId());
			ps.setInt(2, match.getIdEpreuve());
			ps.setInt(3, match.getIdVainqueur());
			ps.setInt(4, match.getIdFinaliste());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Match> lister() {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "SELECT * FROM MATCH_TENNIS;";
		List<Match> list = new ArrayList<Match>();

		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Match match = new Match();
				match.setId(rs.getInt("ID"));
				match.setIdEpreuve(rs.getInt("ID_EPREUVE"));
				match.setIdVainqueur(rs.getInt("ID_VAINQUEUR"));
				match.setIdFinaliste(rs.getInt("ID_FINALISTE"));
				list.add(match);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Match lecture(int id) {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "SELECT * FROM MATCH_TENNIS WHERE ID = " + id + ";";
		Match match = new Match();

		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				match.setId(rs.getInt("ID"));
				match.setIdEpreuve(rs.getInt("ID_EPREUVE"));
				match.setIdVainqueur(rs.getInt("ID_VAINQUEUR"));
				match.setIdFinaliste(rs.getInt("ID_FINALISTE"));
			}
			return match;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void supprimer(int id) {
		DaoFactory df = DaoFactory.instanceDaoF();
		
		String q1 = "SET FOREIGN_KEY_CHECKS = 0;",
				q2 = "DELETE from MATCH_TENNIS WHERE ID = ?;",
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
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void modifier(Match match) {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "UPDATE MATCH_TENNIS set ID_EPREUVE = ?, ID_VAINQUEUR = ?, ID_FINALISTE = ? where id = ?;";

		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, match.getIdEpreuve());
			ps.setInt(2, match.getIdVainqueur());
			ps.setInt(3, match.getIdFinaliste());
			ps.setInt(4, match.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Match> chercher(String txt, String query) {
		DaoFactory df = DaoFactory.instanceDaoF();
		List<Match> result = new ArrayList<Match>();
		
		/* String query = "SELECT * FROM MATCH_TENNIS WHERE ID_VAINQUEUR IN (SELECT ID FROM JOUEUR WHERE NOM LIKE '%"
                + txt + "%' OR PRENOM LIKE '%" + txt + "%') OR ID_FINALISTE IN (SELECT ID FROM JOUEUR WHERE NOM LIKE '%"
                + txt + "%' OR PRENOM LIKE '%" + txt + "%');"; */
		// System.out.println(query);
		
		try {
			Connection conn = df.getConn();
			/*String query = "SELECT * FROM MATCH_TENNIS WHERE ID_VAINQUEUR IN (SELECT ID FROM JOUEUR "
					+ "WHERE NOM LIKE ? OR PRENOM LIKE ?) OR ID_FINALISTE IN (SELECT ID FROM JOUEUR "
					+ "WHERE NOM LIKE ? OR PRENOM LIKE ?);";*/
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Match match = new Match();
				match.setId(rs.getInt("ID"));
				match.setIdEpreuve(rs.getInt("ID_EPREUVE"));
				match.setIdVainqueur(rs.getInt("ID_VAINQUEUR"));
				match.setIdFinaliste(rs.getInt("ID_FINALISTE"));
				result.add(match);
			}
			
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Joueur searchFvsV(int id) {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "SELECT Nom, Prenom, Sexe FROM JOUEUR where Id = " + id + ";";
		//List<Joueur> list = new ArrayList<Joueur>();
		Joueur joueur = null;
		
		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);
	        ResultSet rs= ps.executeQuery(); 
	        while (rs.next()){
	        	joueur = new Joueur();
	        	joueur.setNom(rs.getString("NOM"));
	        	joueur.setPrenom(rs.getString("PRENOM"));
	        	joueur.setSexe(rs.getString("SEXE"));
	        }
        	return joueur;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
