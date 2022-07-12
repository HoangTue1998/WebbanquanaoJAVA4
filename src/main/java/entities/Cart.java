package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
	@NamedQuery(name = "Cart.Find_By_User", query = "SELECT c FROM Cart c WHERE c.user = :user"),
	@NamedQuery(name = "Cart.DELETE_BY_ID_PRODUCT_USER", query = "DELETE FROM Cart c WHERE c.user = :user AND c.product = :product "),
	@NamedQuery(name = "Cart.Find_By_User_Product", query = "SELECT c FROM Cart c WHERE c.user = :user and c.product = :product")
	})
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@GeneratedValue(strategy =  GenerationType.IDENTITY)

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private int soLuong;

	public Cart() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}