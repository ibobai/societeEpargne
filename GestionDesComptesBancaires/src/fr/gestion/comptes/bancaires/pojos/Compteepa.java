package fr.gestion.comptes.bancaires.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the compteepas database table.
 * 
 */
@Entity
@Table(name="compteepas")
@NamedQuery(name="Compteepa.findAll", query="SELECT c FROM Compteepa c")
public class Compteepa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int compteEpaID;

	private int compteID;

	private int plafond;

	private int tauxInteret;

	public Compteepa() {
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