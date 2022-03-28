package fr.gestion.comptes.bancaires.obj;

public class ConseillerObj {
	
	private int conseillerID;

	private String email;

	private String motDePasse;

	private String nom;

	private String nomUtilisateur;

	private String prenom;

	private String tel;

	public ConseillerObj() {
	}

	public int getConseillerID() {
		return this.conseillerID;
	}

	public void setConseillerID(int conseillerID) {
		this.conseillerID = conseillerID;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


}
