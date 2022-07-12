package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.categoryDao;
import DAO.productDao;
import entities.Category;
import entities.Product;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private productDao proDao;
	private categoryDao cateDao;

	public HomeServlet() {
		super();
		this.proDao = new productDao();
		this.cateDao = new categoryDao();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> listPro = proDao.selectAll();
		List<Category> Listcategories = cateDao.selectAll();
		request.setAttribute("dsProduct", listPro);
		request.setAttribute("dsCategory", Listcategories);
		request.setAttribute("view", "/views/Shopping/viewShop.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
