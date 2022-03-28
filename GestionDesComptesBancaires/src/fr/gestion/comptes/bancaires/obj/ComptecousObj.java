package fr.gestion.comptes.bancaires.obj;

public class ComptecousObj {
	
	private int compteCouID;

	private int compteID;

	private int fraisTrans;

	private double soldeMin;

	public ComptecousObj() {
	}

	public int getCompteCouID() {
		return this.compteCouID;
	}

	public void setCompteCouID(int compteCouID) {
		this.compteCouID = compteCouID;
	}

	public int getCompteID() {
		return this.compteID;
	}

	public void setCompteID(int compteID) {
		this.compteID = compteID;
	}

	public int getFraisTrans() {
		return this.fraisTrans;
	}

	public void setFraisTrans(int fraisTrans) {
		this.fraisTrans = fraisTrans;
	}

	public double getSoldeMin() {
		return this.soldeMin;
	}

	public void setSoldeMin(double soldeMin) {
		this.soldeMin = soldeMin;
	}

}
