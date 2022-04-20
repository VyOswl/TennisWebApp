package dao;

import java.util.List;
import beans.Tournoi;

public interface TournoiDao {
	void ajouterT (Tournoi joueur);
	List<Tournoi> listerT();
	Tournoi lectureT(int id);
	void supprimerT(int id);
	List<Tournoi> chercherT(String txt);
	void modifierT(Tournoi joueur);

}