package fr.gestion.comptes.bancaires.dao.interfaces;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.modelmapper.ModelMapper;

import fr.gestion.comptes.bancaires.obj.ClientObj;
import fr.gestion.comptes.bancaires.pojos.Client;

public interface ClientDAO {

	//To check the git !!
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionDesComptesBancaires");
	static EntityManager em = emf.createEntityManager();
	
	ModelMapper modelMapper = new ModelMapper();

	
	public Client getClientById(Integer id);
	public List getClients();
	public void deleteClient(Integer id);
	public ClientObj updateClient(Integer id, String Change, String indic);
	public void createClient(ClientObj co);
	
	

}
