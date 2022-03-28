package fr.gestion.comptes.bancaires.obj;

public class CompteObj {
	
	private int compteID;

	private int clientID;

	private int numCom;

	private double solde;

	public CompteObj() {
	}

	public int getCompteID() {
		return this.compteID;
	}

	public void setCompteID(int compteID) {
		this.compteID = compteID;
	}

	public int getClientID() {
		return this.clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getNumCom() {
		return this.numCom;
	}

	public void setNumCom(int numCom) {
		this.numCom = numCom;
	}

	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}


}
