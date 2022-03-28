package fr.gestion.comptes.bancaires.dao.interfaces;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.modelmapper.ModelMapper;

import java.util.List;
import fr.gestion.comptes.bancaires.obj.TransfertObj;
import fr.gestion.comptes.bancaires.pojos.Transfert;

public interface TransfertDAO {
	
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionDesComptesBancaires");
	static EntityManager em = emf.createEntityManager();
	
	ModelMapper modelMapper = new ModelMapper(); // pour pouvoir passer d un objet "base de donnée" et objet "transfert de donnée DTO"
	
	public TransfertObj getClientById(Integer id);
	public List getTransferts();
	public  TransfertObj updateTransfert(Integer  id);
	public TransfertObj deleteTransfert(Integer id);
	public void createTransfert(TransfertObj co);
	

}
