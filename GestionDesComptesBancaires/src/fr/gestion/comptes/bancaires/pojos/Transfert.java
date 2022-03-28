package fr.gestion.comptes.bancaires.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the transferts database table.
 * 
 */
@Entity
@Table(name="transferts")
@NamedQuery(name="Transfert.findAll", query="SELECT t FROM Transfert t")
public class Transfert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transfertID;

	private int conseillerID;

	@Temporal(TemporalType.DATE)
	private Date date;

	private double montant;

	private int numCompte;

	private String typeOperation;

	public Transfert() {
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