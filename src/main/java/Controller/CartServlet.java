package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.cartDao;
import DAO.categoryDao;
import DAO.productDao;
import entities.Cart;
import entities.Product;
import entities.User;

@WebServlet({ "/cart/ViewTb", "/cart/viewCreate", "/cart/ViewDelete", "/cart/ViewUpdate" })
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private cartDao cartDao;
	private productDao proDao;
	private categoryDao cateDao;
	private User user;

	public CartServlet() {
		super();
		this.cartDao = new cartDao();
		this.proDao = new productDao();
		this.cartDao = new DAO.cartDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("ViewTb")) {
			this.ViewTb(request, response);
		} else if (uri.contains("viewCreate")) {
			this.viewCreate(request, response);
		} else if (uri.contains("ViewDelete")) {
			this.ViewDelete(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("ViewUpdate")) {
			this.ViewUpdate(request, response);
		}

	}

	protected void ViewTb(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		try {
			float tong = 0;
			HttpSession session = request.getSession();
			this.user = (User) session.getAttribute("user");
			List<Cart> listCarts = this.cartDao.findByUser(user);
			request.setAttribute("carts", listCarts);
			for (Cart cart : listCarts) {
				tong += (cart.getSoLuong() * cart.getProduct().getDonGia());
				request.setAttribute("tong", tong);
				request.setAttribute("view", "/views/admin/cart/ViewTbCart.jsp");
				request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void viewCreate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		HttpSession session = request.getSession();
		try {
			String id = request.getParameter("id");
			Product pro = this.proDao.findById(Integer.parseInt(id));
			this.user = (User) session.getAttribute("user");
			List<Cart> listcart = this.cartDao.findByUser(user);
			if (listcart == null) {
				Cart cart = new Cart();
				cart.setProduct(pro);
				cart.setSoLuong(1);
				cart.setUser(user);
				this.cartDao.Cartcreate(cart);
			} else {
				Cart cart = this.cartDao.findByUser_Product(user, pro);
				if (cart == null) {
					cart = new Cart();
					cart.setProduct(pro);
					cart.setSoLuong(1);
					cart.setUser(user);
					this.cartDao.Cartcreate(cart);
				} else {
					this.cartDao.update_soLuong_by_product(pro, cart.getSoLuong() + 1);
				}
			}
			response.sendRedirect(request.getContextPath() + "/cart/ViewTb");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void ViewDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void ViewUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
