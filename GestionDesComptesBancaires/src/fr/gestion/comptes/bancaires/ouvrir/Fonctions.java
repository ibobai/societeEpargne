package fr.gestion.comptes.bancaires.ouvrir;

public class Fonctions {
	public int GenererNumCompte() {
		double nb = Math.random()*1000000;
		int res=(int)Math.floor(nb);
		return (res);
	}
	
}
