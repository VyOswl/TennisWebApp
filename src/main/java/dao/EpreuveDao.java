package dao;

import java.util.List;
import beans.Epreuve;
import beans.Joueur;

public interface EpreuveDao {

	void ajouter(Epreuve epreuve);

	List<Epreuve> lister();

	Epreuve lecture(int id);

	boolean supprimer(int id);

	List<Joueur> chercher(int year, String type);
	
	List<Epreuve> chercherE(int year, String type);

	void modifier(Epreuve epreuve);
	

}
