package fr.gestion.comptes.bancaires.dao.interfaces;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.modelmapper.ModelMapper;

import java.util.List;
import fr.gestion.comptes.bancaires.obj.CompteepaObj;
import fr.gestion.comptes.bancaires.pojos.Compteepa;

public interface CompteepaDAO {
	
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionDesComptesBancaires");
	static EntityManager em = emf.createEntityManager();
	
	ModelMapper modelMapper = new ModelMapper();
	
	
	
	
	// get compte 
	public Compteepa getCompteepaByCompteId(Integer id);
	
	// update
	public CompteepaObj updateCompteepaByCompteId(Integer id, int Change, String indic);
	
	// supprimer 
	public CompteepaObj deleteCompteepaObjByCompteId(Integer id);
	
	
	// creation 
	public void createCompteepa(Compteepa co);

	// get list
	public java.util.List getCompteepa();


}
