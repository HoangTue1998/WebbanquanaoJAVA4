package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Cart;
import entities.Product;
import entities.User;
import Utils.JpaUtils;

public class cartDao {
	private EntityManager em;

	public cartDao() {
		this.em = JpaUtils.getEntityManager();
	}

	public Cart Cartcreate(Cart entity) throws Exception {
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

	public List<Cart> Selectall() {
		String jpql = "SELECT o FROM Cart o";
		TypedQuery<Cart> query = this.em.createQuery(jpql, Cart.class);
		List<Cart> result = query.getResultList();
		return result;
	}

	public void Update(Cart entity) throws Exception {
		try {
			this.em.getTransaction().begin();
			this.em.merge(entity);
			this.em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
		}
	}

	public void Delete(Cart entity) throws Exception {
		try {
			this.em.getTransaction().begin();
			this.em.remove(entity);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
		}
	}

	public void deleteByProduct_User(User user, Product product) throws Exception {
		try {
			Query query = this.em.createNamedQuery("Cart.DELETE_BY_ID_PRODUCT_USER");
			this.em.getTransaction().begin();
			query.setParameter("user", user);
			query.setParameter("product", product);
			query.executeUpdate();
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
		}
	}

	public Cart findById(int id) throws Exception {
		Cart cart = this.em.find(Cart.class, id);
		if (cart == null) {
			throw new Exception("NotFoundException: cart null");
		}
		return cart;
	}

	public List<Cart> findByUser(User user) {
		TypedQuery<Cart> querys = this.em.createNamedQuery("Cart.Find_By_User", Cart.class);
		List<Cart> list = querys.setParameter("user", user).getResultList();
		return list;
	}

	public void update_soLuong_by_product(Product product, int quantity) throws Exception {
		try {
			Query query = em
					.createQuery("UPDATE Cart c SET c.quantity = :soLuong WHERE c.product = :product");
			this.em.getTransaction().begin();
			query.setParameter("soLuong", quantity);
			query.setParameter("product", product);
			query.executeUpdate();
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
		}
	}

	public Cart findByUser_Product(User user, Product product) {
		try {Query query = em
				.createQuery("SELECT c FROM Cart c WHERE c.user = :user and c.product = :product");
	
			query.setParameter("user", user);
			query.setParameter("product", product);
			Cart cart = (Cart) query.getSingleResult();
			return cart;
		} catch (Exception e) {
			return null;
		}
		
	}

}
