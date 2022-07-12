package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.jasper.tagplugins.jstl.core.Remove;

import DAO.categoryDao;
import DAO.productDao;
import entities.Category;
import entities.Product;
import entities.User;

@WebServlet({ "/product/viewCreatepr", "/product/viewUpdatepr", "/product/viewDelete",

		"/product/Createpr", "/product/Updatepr", "/product/Deletepr", "/product/Tablepr" })
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private categoryDao catedao;
	private productDao proDao;

	public productServlet() {
		super();
		this.catedao = new categoryDao();
		this.proDao = new productDao();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("viewCreatepr")) {
			this.viewCreatepr(request, response);
		} else if (uri.contains("Tablepr")) {
			this.Tablepr(request, response);
		} else if (uri.contains("viewUpdatepr")) {
			this.viewUpdatepr(request, response);
		} else if (uri.contains("Deletepr")) {
			this.Deletepr(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		String uri = request.getRequestURI();
		if (uri.contains("Createpr")) {
			this.Createpr(request, response);
		} else if (uri.contains("Updatepr")) {
			this.Updatepr(request, response);
		}
	}

	protected void Tablepr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		List<Product> dsPro = this.proDao.selectAll();
		request.setAttribute("dsPro", dsPro);

		List<Category> dsCate = this.catedao.selectAll();
		request.setAttribute("dsCate", dsCate);
		request.setAttribute("view", "/views/admin/product/ViewtbPr.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

	protected void viewCreatepr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		List<Product> dsPro = this.proDao.selectAll();
		request.setAttribute("dsPro", dsPro);

		List<Category> dsCate = this.catedao.selectAll();
		request.setAttribute("dsCate", dsCate);
		request.setAttribute("view", "/views/admin/product/CreatePr.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

	protected void viewUpdatepr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> dsCate = catedao.selectAll();
		request.setAttribute("dsCate", dsCate);

		List<Product> dsProduct = proDao.selectAll();
		request.setAttribute("dsProduct", dsProduct);

		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		Product entity = proDao.findById(id);
		request.setAttribute("product", entity);

		request.setAttribute("view", "/views/admin/product/UpdatePr.jsp");

		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

	protected void Createpr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		HttpSession session = request.getSession();
		String cate_id = request.getParameter("category_id");
		try {
			int id = Integer.parseInt(cate_id);
			Category entityCategory = this.catedao.findById(id);
			Product entityProduct = new Product();
			BeanUtils.populate(entityProduct, request.getParameterMap());
			entityProduct.setCategory(entityCategory);
			this.proDao.createPro(entityProduct);
			session.setAttribute("message", "Thêm sản phẩm thành công!");
			response.sendRedirect(request.getContextPath()+"/product/Tablepr");

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Thêm sản phẩm thất bại!");
			response.sendRedirect(request.getContextPath()+"/product/viewCreatepr");
		}
	}

	protected void Updatepr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String cate_idString = request.getParameter("category_id");
		String idString = request.getParameter("id");
		try {
			int cate_id = Integer.parseInt(cate_idString);
			int id = Integer.parseInt(idString);

			Category entityCategory = this.catedao.findById(cate_id);
			Product entityProduct = new Product();
			BeanUtils.populate(entityProduct, request.getParameterMap());
			entityProduct.setCategory(entityCategory);
			this.proDao.updatePro(entityProduct);
			session.setAttribute("message", "Bạn cập nhật tài khoản thành công!");
			response.sendRedirect(request.getContextPath() +"/product/Tablepr");

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Bạn cập nhật tài khoản thất bại");
			response.sendRedirect(request.getContextPath()+"/product/?id=" + idString);
		}

	}

	protected void Deletepr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idString = request.getParameter("id");
		try {
			int id = Integer.parseInt(idString);

			Product entity = this.proDao.findById(id);

			this.proDao.deletePro(entity);

			response.sendRedirect(request.getContextPath()+"/product/Tablepr");
			session.setAttribute("message", "Xoá thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Xoá thất bại!");
			response.sendRedirect(request.getContextPath() +"/product/Tablepr");
		}

	}

}
