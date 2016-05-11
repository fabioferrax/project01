package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.uniroma3.model.Utente;

public class UserDAO implements DAO<Utente> {

	
	private EntityManagerFactory emf;
	
	public UserDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void save(Utente user){

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	

		tx.begin();
		em.persist(user);
		tx.commit();
		em.close();
	}

	@Override
	public Utente update(Utente user) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		return null;
	}

	@Override
	public Utente findByPrimaryKey(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		
		tx.begin();
		Utente user = em.find(Utente.class, id);

		em.close();
		return user;
	}

	@Override
	public Utente remove(Utente user) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		return null;
	}
	
	public void closeEmf() {
		emf.close();
	}

	@Override
	public List<Utente> findByParameter(String parameter,String column){
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		/*
		Configuration cfg = new Configuration();
		cfg.addXML("hibernate.cfg.xml");	
				
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Utente.class);
		
		criteria.add(Restrictions.eq(column, parameter));		
		List<Utente> list = criteria.list();
		
		em.close();
		*/
		return null;
	}

	@Override
	public List<Utente> findByParameter(String parameter1, String column1, String parameter2, String column2) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		
		Query query = em.createQuery("from Utente u where u.username=:p1 and u.password=:p2");
		query.setParameter("p1", parameter1);
		query.setParameter("p2", parameter2);
		List<Utente> list = query.getResultList();
		
		em.close();
		
		return list;
	}
	
	
}
