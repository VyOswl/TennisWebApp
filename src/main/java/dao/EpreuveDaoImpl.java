package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import beans.Epreuve;
import beans.Joueur;

public class EpreuveDaoImpl implements EpreuveDao {

	public EpreuveDaoImpl() {
	}

	@Override
	public void ajouter(Epreuve epreuve) {
		DaoFactory df = DaoFactory.instanceDaoF();

		String query = "INSERT INTO epreuve (ID,ANNEE,TYPE_EPREUVE,ID_TOURNOI) VALUES "
				+ "( ?, ?, ?,?);";

		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, epreuve.getId());
			ps.setInt(2, epreuve.getAnnee());
			ps.setString(3, String.valueOf(epreuve.getType()));
			ps.setInt(4, epreuve.getIdTournoi());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Epreuve> lister() {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "SELECT * FROM epreuve;";
		List<Epreuve> list = new ArrayList<Epreuve>();

		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Epreuve epreuve = new Epreuve();
				epreuve.setId(rs.getInt("ID"));
				epreuve.setAnnee(rs.getInt("ANNEE"));
				epreuve.setType(rs.getString("TYPE_EPREUVE").charAt(0));
				epreuve.setIdTournoi(rs.getInt("ID_TOURNOI"));
				list.add(epreuve);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Epreuve lecture(int id) {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "SELECT * FROM epreuve WHERE ID = " + id + ";";
		Epreuve epreuve = new Epreuve();

		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				epreuve.setId(rs.getInt("ID"));
				epreuve.setAnnee(rs.getInt("ANNEE"));
				epreuve.setType(rs.getString("TYPE_EPREUVE").charAt(0));
				epreuve.setIdTournoi(rs.getInt("ID_TOURNOI"));
			}
			return epreuve;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean supprimer(int id) {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "DELETE from epreuve WHERE ID = ?;";

		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, id);
			boolean row = ps.executeUpdate() > 0;
			System.out.print("row");
			return row;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void modifier(Epreuve epreuve) {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "UPDATE epreuve set ANNEE = ?, TYPE_EPREUVE = ?, ID_TOURNOI = ? where id = ?;";

		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, epreuve.getAnnee());
			ps.setString(2, String.valueOf(epreuve.getType()));
			ps.setInt(3, epreuve.getIdTournoi());
			ps.setInt(4, epreuve.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Joueur> chercher(int year, String type) {
		DaoFactory df = DaoFactory.instanceDaoF();
		List<Joueur> result = new ArrayList<Joueur>();

		try {
			Connection conn = df.getConn();
			String query = "SELECT NOM, PRENOM FROM JOUEUR WHERE ID IN "
					+ "(SELECT ID_VAINQUEUR FROM MATCH_TENNIS WHERE ID_EPREUVE IN "
					+ "(SELECT ID FROM EPREUVE WHERE ANNEE=? AND TYPE_EPREUVE=?)) "
					+ "UNION SELECT NOM, PRENOM FROM JOUEUR WHERE ID IN "
					+ "(SELECT ID_FINALISTE FROM MATCH_TENNIS WHERE ID_EPREUVE IN "
					+ "(SELECT ID FROM EPREUVE WHERE ANNEE=? AND TYPE_EPREUVE=?));";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, year);
			ps.setString(2, type);
			ps.setInt(3, year);
			ps.setString(4, type);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Joueur joueur = new Joueur();
				joueur.setNom(rs.getString("NOM"));
	        	joueur.setPrenom(rs.getString("PRENOM"));
				result.add(joueur);
			}
			//System.out.println(result);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Epreuve> chercherE(int year, String type) {
		DaoFactory df = DaoFactory.instanceDaoF();
		String query = "SELECT * FROM epreuve WHERE annee = ? AND type_epreuve = ?;";
		List<Epreuve> list = new ArrayList<Epreuve>();

		try {
			Connection conn = df.getConn();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, year);
			ps.setString(2, type);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Epreuve epreuve = new Epreuve();
				epreuve.setId(rs.getInt("ID"));
				epreuve.setAnnee(rs.getInt("ANNEE"));
				epreuve.setType(rs.getString("TYPE_EPREUVE").charAt(0));
				epreuve.setIdTournoi(rs.getInt("ID_TOURNOI"));
				list.add(epreuve);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
