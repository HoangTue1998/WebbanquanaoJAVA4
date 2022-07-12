package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JpaUtils;
import entities.Product;

public class productDao {
	EntityManager em;
	
	public productDao() {
		em= JpaUtils.getEntityManager();

	}

	public Product createPro(Product entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e ;
		}
	}
	public Product updatePro(Product entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e ;
		}
	}
	public Product deletePro(Product entity) {
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e ;
		}
	}
	
	public List<Product> selectAll() {
		String jqpl = "SELECT o FROM Product o" ;
		TypedQuery<Product> query = this.em.createQuery(jqpl, Product.class);
		List<Product> ds = query.getResultList();
		return ds ;
	}
	
	public Product findById(int id) {
		Product entity = this.em.find(Product.class, id);
		return entity;
	}
}

