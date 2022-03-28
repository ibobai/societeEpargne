package fr.gestion.comptes.bancaires.daos.implement;

import java.util.List;

import javax.persistence.TypedQuery;

import fr.gestion.comptes.bancaires.dao.interfaces.CompteepaDAO;
import fr.gestion.comptes.bancaires.obj.ComptecousObj;
import fr.gestion.comptes.bancaires.obj.CompteepaObj;
import fr.gestion.comptes.bancaires.pojos.Comptecous;
import fr.gestion.comptes.bancaires.pojos.Compteepa;

public class CompteepaImplement implements CompteepaDAO {

	public Compteepa getCompteepaByCompteId(Integer id) {

		Object cc = em.createQuery("SELECT b FROM Comptecous b WHERE b.compteID = "+id);
		//ComptecousObj cc = modelMapper.map(c, ComptecousObj.class);   //ON appelle la fonction de mapping pour mapper de Client vers clientObj
		TypedQuery<Compteepa> q = em.createQuery("SELECT b FROM Compteepa b WHERE b.compteID = "+id, Compteepa.class); 
		List<Compteepa> res = q.getResultList();
//		 for (Compteepa str : res)
//	      { 		      
//	           System.out.println(str.getCompteID() + " This is the id of the comptC"); 		
//	      }
		if(res.size() > 0) {
			return res.get(0);
		}else {
		//	System.out.println("Didin't find a compteepa ! ");
			return new Compteepa();
		}
	}

	@Override
	public List getCompteepa() {
		List<Compteepa> lc =  em.createQuery("From Compteepa", Compteepa.class).getResultList();
		return lc;
	}
	
	

	@Override
	public CompteepaObj updateCompteepaByCompteId(Integer id, int Change, String indic) {
		Compteepa c = em.find(Compteepa.class, id);
		CompteepaObj cc = modelMapper.map(c, CompteepaObj.class); 
		
		if (indic=="TI") {
			cc.setTauxInteret(Change);
		}
		else if (indic=="P") {
			cc.setPlafond(Change);		}
		
		em.persist(cc); // sauvegarder l objet dans la base de donn�e
		return cc;
	}  

	@Override
	public CompteepaObj deleteCompteepaObjByCompteId(Integer id){
		try {
			//em.createQuery("DELETE from Client WHERE clientID ="+id);
			
			Compteepa c = em.find(Compteepa.class, id);

			  em.getTransaction().begin();
			  em.remove(c);
			  em.getTransaction().commit();
			
			System.out.println("Comptecous has been deleted");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Comptecous has not  been deleted "+e);

		}
		return null;
	}

	public void createCompteepa(Compteepa compteepa) {
		em.getTransaction().begin();
		em.persist(compteepa);
		em.getTransaction().commit();
	}


}
