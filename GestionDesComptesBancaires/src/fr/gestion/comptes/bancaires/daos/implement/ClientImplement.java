package fr.gestion.comptes.bancaires.daos.implement;

import java.util.List;
import fr.gestion.comptes.bancaires.dao.interfaces.ClientDAO;
import fr.gestion.comptes.bancaires.obj.ClientObj;
import fr.gestion.comptes.bancaires.pojos.Client;

public class ClientImplement implements ClientDAO {
	@Override
	public Client getClientById(Integer id) {
		Client c = em.find(Client.class, id);
		Client cc = modelMapper.map(c, Client.class);   //ON appelle la fonction de mapping pour mapper de Client vers clientObj
		System.out.println(cc.getNom() +" "+ cc.getPrenom());
		return cc;
	}
	@Override
	public List getClients() {
		List<Client> lc =  em.createQuery("From Client", Client.class).getResultList();
		System.out.println("Listing all the client ! ");
		
		for(Client c : lc) {
			System.out.println(c.getNom());
		}
		
		return lc;
	}
	@Override
	public ClientObj updateClient(Integer id, String Change, String indic) {
		
		Client c = em.find(Client.class, id);
		ClientObj cc = modelMapper.map(c, ClientObj.class); 
		
		if (indic=="N") {
			cc.setNom(Change);
		}
		else if (indic=="P") {
			cc.setPrenom(Change);
		}
        else if (indic=="T") {
        	cc.setTel(Change);
		}
        else if (indic=="A") {
        	cc.setAdresse(Change);
		}
        else if (indic=="E") {
        	cc.setEmail(Change);
		}
		
		em.persist(cc); // sauvegarder l objet dans la base de donn�e
		return cc;
	}

	@Override
	public void deleteClient(Integer id) {
		try {
			//em.createQuery("DELETE from Client WHERE clientID ="+id);
			
			Client c = em.find(Client.class, id);

			  em.getTransaction().begin();
			  em.remove(c);
			  em.getTransaction().commit();
			
			System.out.println("Client has been deleted");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Client has not  been deleted "+e);

		}
	}
	
	
	public void createClient(Client co) {
		  em.getTransaction().begin();
		  em.persist(co);
		  em.getTransaction().commit();
	}
	
	@Override
	public void createClient(ClientObj co) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}