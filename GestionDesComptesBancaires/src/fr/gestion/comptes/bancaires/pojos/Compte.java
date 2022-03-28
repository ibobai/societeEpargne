package fr.gestion.comptes.bancaires.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comptes database table.
 * 
 */
@Entity
@Table(name="comptes")
@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int compteID;

	private int clientID;

	private int numCom;

	private double solde;

	public Compte() {
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