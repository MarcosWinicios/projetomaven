package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidade.EPessoa;

public class PessoaDAO {
	private static PessoaDAO instance;
	protected EntityManager entityManager;
	
	private PessoaDAO() {
		entityManager = getEntityManager();
	}
	
	
	public static PessoaDAO getInstance() {
		if(instance == null) {
			instance = new PessoaDAO();
		}
		
		return instance;
	}
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default"); //Nome da Unit no persistence.xml
		
		if(entityManager == null) {
			entityManager =  factory.createEntityManager();
		}
		return entityManager;
	}
	
	public void salvar(EPessoa pessoa) {
		try {
			entityManager.getTransaction().begin(); // Iniciando a transação
			entityManager.persist(pessoa); //Fazendo a inserção no banco
			entityManager.getTransaction().commit(); // Efetivar a transação
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback(); // Desfaz a operação no banco
		}
	}
}
