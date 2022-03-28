package fr.gestion.comptes.bancaires.obj;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TransfertObj {
	
	private int transfertID;

	private int conseillerID;

	@Temporal(TemporalType.DATE)
	private Date date;

	private double montant;

	private int numCompte;

	private String typeOperation;

	public TransfertObj() {
	}

	public int getTransfertID() {
		return this.transfertID;
	}

	public void setTransfertID(int transfertID) {
		this.transfertID = transfertID;
	}

	public int getConseillerID() {
		return this.conseillerID;
	}

	public void setConseillerID(int conseillerID) {
		this.conseillerID = conseillerID;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public int getNumCompte() {
		return this.numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public String getTypeOperation() {
		return this.typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}



}
