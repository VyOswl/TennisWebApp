package beans;

public class Joueur {

	protected int id;
	protected String nom;
	protected String prenom;
	protected String sexe;

	public Joueur(int id, String nom, String prenom, String sexe) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
	}

	public Joueur(String nom, String prenom, String sexe) {
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
	}

	public Joueur() {
		super();
		// TODO Auto-generated constructor stub
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

	public void setNom(String nom) throws BeanException {
		if(nom.length() > 20){
			throw new BeanException("20 charactères maximum");
		} else {
			this.nom = nom;
		}
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) throws BeanException {
		if(prenom.length() > 20){
			throw new BeanException("20 charactères maximum");
		} else {
			this.prenom = prenom;
		}
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return "Joueur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + "]";
	}
}