package fr.gestion.comptes.bancaires.daos.implement;

import java.util.List;
import fr.gestion.comptes.bancaires.dao.interfaces.ConseillerDAO;
import fr.gestion.comptes.bancaires.obj.ConseillerObj;
import fr.gestion.comptes.bancaires.pojos.Client;
import fr.gestion.comptes.bancaires.pojos.Conseiller;


public class ConseillerImplement implements ConseillerDAO {

	@Override
	public ConseillerObj getClientById(Integer id) {
		Conseiller c = em.find(Conseiller.class, id);	
		ConseillerObj cc = modelMapper.map(c, ConseillerObj.class);   //ON appelle la fonction de mapping pour mapper de Client vers clientObj
		return cc;
	}

	@Override
	public List getConseillers() {
		List<Conseiller> lc =  em.createQuery("From Conseiller", Conseiller.class).getResultList();
		return lc;
	}

	@Override
	public ConseillerObj updateConseiller(Integer id, String Change, String indic) {
		Conseiller c = em.find(Conseiller.class, id);	
		ConseillerObj cc = modelMapper.map(c, ConseillerObj.class);
		
		if (indic=="N") {
			cc.setNom(Change);
		}
		else if (indic=="P") {
			cc.setPrenom(Change);
		}
        else if (indic=="T") {
        	cc.setTel(Change);
		}
        else if (indic=="NU") {
        	cc.setNomUtilisateur(Change);
		}
        else if (indic=="E") {
        	cc.setEmail(Change);
		}
        else if (indic=="MD") {
        	cc.setMotDePasse(Change);
		}
		
		em.persist(cc); // sauvegarder l objet dans la base de donnée	
		return cc;
	}

	@Override
	public ConseillerObj deleteConseiller(Integer id) {
		try {
			Conseiller c = em.find(Conseiller.class, id);

			  em.getTransaction().begin();
			  em.remove(c);
			  em.getTransaction().commit();
			
			System.out.println("Conseiller has been deleted");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Conseiller has not  been deleted "+e);
		}
		return null;
	}

	@Override
	public void createConseiller(ConseillerObj c) {
		em.persist(c);
	}

	

}
