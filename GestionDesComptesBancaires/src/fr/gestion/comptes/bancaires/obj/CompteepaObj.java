package fr.gestion.comptes.bancaires.obj;

public class CompteepaObj {
	
	private int compteEpaID;

	private int compteID;

	private int plafond;

	private int tauxInteret;

	public CompteepaObj() {
	}

	public int getCompteEpaID() {
		return this.compteEpaID;
	}

	public void setCompteEpaID(int compteEpaID) {
		this.compteEpaID = compteEpaID;
	}

	public int getCompteID() {
		return this.compteID;
	}

	public void setCompteID(int compteID) {
		this.compteID = compteID;
	}

	public int getPlafond() {
		return this.plafond;
	}

	public void setPlafond(int plafond) {
		this.plafond = plafond;
	}

	public int getTauxInteret() {
		return this.tauxInteret;
	}

	public void setTauxInteret(int tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

}
