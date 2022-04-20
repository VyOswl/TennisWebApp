package dao;

import java.util.List;

import beans.Joueur;
import beans.Match;

public interface MatchDao {

	void ajouter(Match match);

	List<Match> lister();

	Match lecture(int id);

	void supprimer(int id);

	List<Match> chercher(String txt, String query);

	void modifier(Match match);
	
	Joueur searchFvsV(int id);

}
