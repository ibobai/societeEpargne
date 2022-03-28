package fr.gestion.comptes.bancaires.daos.implement;

import java.util.List;

import javax.persistence.TypedQuery;

import fr.gestion.comptes.bancaires.dao.interfaces.CompteDAO;
import fr.gestion.comptes.bancaires.obj.CompteObj;
import fr.gestion.comptes.bancaires.pojos.Client;
import fr.gestion.comptes.bancaires.pojos.Compte;
import fr.gestion.comptes.bancaires.pojos.Comptecous;

public class CompteImplement implements CompteDAO {

	@Override
	public CompteObj getCompteById(Integer id) {
		Compte c = em.find(Compte.class, id);	
		CompteObj cc = modelMapper.map(c, CompteObj.class);   //ON appelle la fonction de mapping pour mapper de Client vers clientObj
		return cc;	
	}

	@Override
	public List getComptes() {
		List<Compte> lc =  em.createQuery("From Compte", Compte.class).getResultList();
		return lc;
	}

	@Override
	public CompteObj updateCompte(Integer id, int Change, String indic){
		Compte c = em.find(Compte.class, id);	
		CompteObj cc = modelMapper.map(c, CompteObj.class); 
		if (indic=="S") {
			cc.setSolde(Change);
		}
		em.persist(cc);	
		return cc;
	}

	@Override
	public Compte deleteCompte(Integer id) {
		try {
			//em.createQuery("DELETE from Client WHERE clientID ="+id);
			
			Compte c = em.find(Compte.class, id);

			  em.getTransaction().begin();
			  em.remove(c);
			  em.getTransaction().commit();
			
			System.out.println("Compte has been deleted");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Compte has not  been deleted "+e);
		}
		return null;
	}

	@Override
	public void createCompte(Compte c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}

	@Override
	public Compte getCompteByNumeroCompte(Integer numeroCompte) {
		Object cc = em.createQuery("SELECT b FROM Comptecous b WHERE b.compteID = "+numeroCompte);
		//ComptecousObj cc = modelMapper.map(c, ComptecousObj.class);   //ON appelle la fonction de mapping pour mapper de Client vers clientObj
		TypedQuery<Compte> q = em.createQuery("SELECT b FROM Compte b WHERE b.numCom ="+numeroCompte, Compte.class); 
		List<Compte> res = q.getResultList();
//		 for (Comptecous str : res)
//	      { 		      
//	           System.out.println(str.getCompteCouID() + " This is the id of the comptC"); 		
//	      }
//		ComptecousObj ccc = new ComptecousObj();
		if(res.size() > 0) {
			return res.get(0);
		}else {
			System.out.println("Didin't find a comptecous ! ");
			return new Compte();
		}	
	}


}
