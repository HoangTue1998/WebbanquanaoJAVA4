package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JpaUtils;
import entities.Category;

public class categoryDao {
	private EntityManager em;

	public categoryDao() {
		this.em = JpaUtils.getEntityManager();
	}

	public Category createCategory(Category entity) throws Exception {
		try {
			this.em.getTransaction().begin();
			this.em.persist(entity);
			this.em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
		}
	}

	public Category updateCategory(Category entity) throws Exception {
		try {
			this.em.getTransaction().begin();
			this.em.merge(entity);
			this.em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
		}
	}

	public Category deleteCategory(Category entity) throws Exception {
		try {
			this.em.getTransaction().begin();
			this.em.remove(entity);
			this.em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
		}
	}

	public List<Category> selectAll() {
		String jpql = "SELECT obj FROM Category obj";
		TypedQuery<Category> query = this.em.createQuery(jpql, Category.class);
		List<Category> result = query.getResultList();
		return result;
	}

	public Category findById(int id) {
		return this.em.find(Category.class, id);
	}
}
