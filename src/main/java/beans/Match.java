package beans;

public class Match {

	protected int id;
	protected int idEpreuve;
	protected int idVainqueur;
	protected int idFinaliste;
	
	public Match(int id, int idEpreuve, int idVainqueur, int idFinaliste) {
		super();
		this.id = id;
		this.idEpreuve = idEpreuve;
		this.idVainqueur = idVainqueur;
		this.idFinaliste = idFinaliste;
	}
	
	public Match(int idEpreuve, int idVainqueur, int idFinaliste) {
		this.idEpreuve = idEpreuve;
		this.idVainqueur = idVainqueur;
		this.idFinaliste = idFinaliste;
	}

	public Match() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEpreuve() {
		return idEpreuve;
	}

	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}

	public int getIdVainqueur() {
		return idVainqueur;
	}

	public void setIdVainqueur(int idVainqueur) {
		this.idVainqueur = idVainqueur;
	}

	public int getIdFinaliste() {
		return idFinaliste;
	}

	public void setIdFinaliste(int idFinaliste) {
		this.idFinaliste = idFinaliste;
	}

	
}