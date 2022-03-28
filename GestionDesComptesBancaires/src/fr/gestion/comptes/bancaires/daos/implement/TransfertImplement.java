package fr.gestion.comptes.bancaires.daos.implement;

import java.util.List;
import fr.gestion.comptes.bancaires.dao.interfaces.TransfertDAO;
import fr.gestion.comptes.bancaires.obj.TransfertObj;
import fr.gestion.comptes.bancaires.pojos.Client;
import fr.gestion.comptes.bancaires.pojos.Transfert;

public class TransfertImplement implements TransfertDAO {

	@Override
	public TransfertObj getClientById(Integer id) {
		Transfert c = em.find(Transfert.class, id);	
		TransfertObj cc = modelMapper.map(c, TransfertObj.class);   //ON appelle la fonction de mapping pour mapper de Client vers clientObj
		return cc;
	}

	@Override
	public List getTransferts() {
		List<Transfert> lc =  em.createQuery("From Transfert", Transfert.class).getResultList();
		return lc;
	}

	@Override
	public TransfertObj updateTransfert(Integer id) {
		Transfert c = em.find(Transfert.class, id);	
		TransfertObj cc = modelMapper.map(c, TransfertObj.class); 
		return cc;
	}

	@Override
	public TransfertObj deleteTransfert(Integer id) {
		try {	
			Transfert c = em.find(Transfert.class, id);

			  em.getTransaction().begin();
			  em.remove(c);
			  em.getTransaction().commit();
			
			System.out.println("Transfert has been deleted");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Transfert has not  been deleted "+e);

		}
		return null;
	}

	@Override
	public void createTransfert(TransfertObj co) {
		em.persist(co);	
	}

}
