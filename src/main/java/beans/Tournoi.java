package beans;

public class Tournoi {
	protected int id;
	protected String nom;
	protected String code;
	
	public Tournoi() {}

	public Tournoi(int id, String nom, String code) {
		this.id = id;
		this.nom = nom;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}