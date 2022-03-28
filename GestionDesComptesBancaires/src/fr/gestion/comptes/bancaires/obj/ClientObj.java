package fr.gestion.comptes.bancaires.obj;

public class ClientObj {

	private int clientID;

	private String adresse;

	private int conseillerID;

	private String email;

	private String nom;

	private String prenom;

	private String tel;

	public ClientObj() {
	}

	public int getClientID() {
		return this.clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
