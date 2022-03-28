package fr.gestion.comptes.bancaires.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comptecous database table.
 * 
 */
@Entity
@Table(name="comptecous")
@NamedQuery(name="Comptecous.findAll", query="SELECT c FROM Comptecous c")
public class Comptecous implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int compteCouID;

	private int compteID;

	private int fraisTrans;

	private double soldeMin;

	public Comptecous() {
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