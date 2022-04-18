package dao;

import java.util.List;
import beans.Joueur;

public interface JoueurDao {
	
	void ajouter (Joueur joueur);
	List<Joueur> lister();
	Joueur lecture(int id);
	boolean supprimer(int id);
	List<Joueur> chercher(String txt);
	Joueur searchFvsH(int id);
	void modifier(Joueur joueur);

}
