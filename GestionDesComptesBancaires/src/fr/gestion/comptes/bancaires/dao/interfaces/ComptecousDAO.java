package fr.gestion.comptes.bancaires.dao.interfaces;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.modelmapper.ModelMapper;

import fr.gestion.comptes.bancaires.obj.ComptecousObj;
import fr.gestion.comptes.bancaires.obj.CompteepaObj;
import fr.gestion.comptes.bancaires.pojos.Comptecous;

public interface ComptecousDAO {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionDesComptesBancaires");
	static EntityManager em = emf.createEntityManager();
	
	ModelMapper modelMapper = new ModelMapper();
	
	public Comptecous getComptecousByCompteId(Integer id);
	public List getComptecous();
	public ComptecousObj deleteComptecousByCompteId(Integer id);
	public void createComptecous(Comptecous co);
	public ComptecousObj updateComptecousByCompteId(Integer id, int Change, String indic);
}
