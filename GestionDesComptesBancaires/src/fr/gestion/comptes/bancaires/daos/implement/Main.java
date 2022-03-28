package fr.gestion.comptes.bancaires.daos.implement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.gestion.comptes.bancaires.pojos.Compte;
import fr.gestion.comptes.bancaires.pojos.Comptecous;

public class Main {

	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionDesComptesBancaires");
	private static EntityManager em = emf.createEntityManager();
	
	public static void getCompte(Integer id) {
		Compte p1 = em.find(Compte.class, id);
//		Comptecous c1 = em.find(Comptecous.class, id);
//		System.out.println(c1.getCompteID());
//		System.out.println(p1.getSolde());
	}

	


	public static void persistCompte(Compte  c) {

		Compte p2 = new Compte();
		p2.setNumCom(c.getNumCom());
		p2.setSolde(c.getSolde());
		p2.setClientID(c.getClientID());

		em.getTransaction().begin();
		em.persist(p2);
		em.getTransaction().commit();
		System.out.println("Compte has been persisted ");

	}
}
