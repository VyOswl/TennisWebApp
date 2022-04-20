package beans;

public class Epreuve {

	protected int id;
	protected int annee;
	protected char type;
	protected int idTournoi;

	public Epreuve() {
	}

	public Epreuve(int id, int annee, char type, int idTournoi) {
		super();
		this.id = id;
		this.annee = annee;
		this.type = type;
		this.idTournoi = idTournoi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public int getIdTournoi() {
		return idTournoi;
	}

	public void setIdTournoi(int idTournoi) {
		this.idTournoi = idTournoi;
	}

	
}