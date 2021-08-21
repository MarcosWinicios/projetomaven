package util;

import java.util.List;

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
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit-jsf"); //Nome da Unit no persistence.xml
		
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
	
	public EPessoa buscarPorId(final long id) { //final pq o valor não será alterado
		return entityManager.find(EPessoa.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<EPessoa> listarTodos(){
		return entityManager.createQuery("FROM " + EPessoa.class.getName()).getResultList();
	}
	
	public void alterar(EPessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void remover(EPessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			pessoa = entityManager.find(EPessoa.class, pessoa.getId());
			entityManager.remove(pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void removerPorId(final long id) {
		try {
			EPessoa pessoa =  this.buscarPorId(id);
			this.remover(pessoa);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
