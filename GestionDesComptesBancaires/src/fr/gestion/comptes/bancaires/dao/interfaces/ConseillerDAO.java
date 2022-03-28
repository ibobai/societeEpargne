package fr.gestion.comptes.bancaires.dao.interfaces;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.modelmapper.ModelMapper;

import java.util.List;
import fr.gestion.comptes.bancaires.obj.ConseillerObj;


public interface ConseillerDAO {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionDesComptesBancaires");
	static EntityManager em = emf.createEntityManager();
	
	ModelMapper modelMapper = new ModelMapper();
	
	public ConseillerObj getClientById(Integer id);
	public List getConseillers();
	public ConseillerObj deleteConseiller(Integer id);
	public ConseillerObj updateConseiller(Integer id, String Change, String indic);
	public void createConseiller(ConseillerObj c);
}
