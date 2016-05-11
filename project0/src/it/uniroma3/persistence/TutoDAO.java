package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.model.Utente;

public class TutoDAO implements Dao<Tuto>{

	private EntityManagerFactory emf;

	public TutoDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Tuto tuto){
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	

		tx.begin();
		em.persist(tuto);
		tx.commit();
		em.close();

	}
	public Tuto update(Tuto tuto){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		return null;
	}
	public Tuto findByPrimaryKey(Long id){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Tuto tuto = em.find(Utente.class, id);

		em.close();
		return tuto;
	}
	
	public List<Tuto> findByParameter(String parameter, String column){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		return null;
	}
	public List<Tuto> findByParameter(String parameter1,String column1,String parameter2, String column2){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		return null;
	}
	public Tuto remove(Tuto tuto){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		return null;
	}
}
