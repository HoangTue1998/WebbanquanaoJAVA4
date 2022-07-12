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

import DAO.categoryDao;
import DAO.userDao;
import entities.Category;
import entities.User;

@WebServlet({ "/cate/viewCate", "/cate/viewUpdate", "/cate/Categorycreate", "/cate/Categoryupdate","/cate/Categorydelete" })
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDao uDao;
	private categoryDao cateDao;

	public CategoryServlet() {
		super();
		this.uDao = new userDao();
		this.cateDao = new categoryDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("viewCate")) {
			this.viewCate(request, response);
		} else if (uri.contains("viewUpdate")) {
			this.viewUpdate(request, response);
		}else if (uri.contains("Categorydelete")) {
			this.Categorydelete(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		String uri = request.getRequestURI();
		if (uri.contains("Categorycreate")) {
			this.Categorycreate(request, response);
		} else if (uri.contains("Categoryupdate")) {
			this.Categoryupdate(request, response);
		}

	}

	protected void viewCate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<User> dsUser = this.uDao.selectAll();
		request.setAttribute("dsUser", dsUser);

		List<Category> dsCate = this.cateDao.selectAll();
		request.setAttribute("dsCate", dsCate);

		request.setAttribute("view", "/views/admin/caterory/viewCatery.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	protected void Categorycreate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		HttpSession session = request.getSession();
		Category cate = new Category();

		try {
			String tenCate = request.getParameter("ten");
			int id = Integer.parseInt(request.getParameter("User_id"));
			User user = this.uDao.findById(id);

			if (!Utils.StrUtils.isValue(tenCate)) {
				cate.setTen(tenCate);

				cate.setUser(user);
				this.cateDao.createCategory(cate);
				session.setAttribute("message", "Tạo thêm sản phẩm thành công");
				response.sendRedirect(request.getContextPath() + "/cate/viewCate");
			} else {
				session.setAttribute("orrer", "Bạn chưa nhập đủ thông tin!");
				response.sendRedirect(request.getContextPath() + "/cate/viewCate");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/cate/viewCate");
			session.setAttribute("error", "Thêm mới thất bại");
		}
	}

	protected void Categoryupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		HttpSession session = request.getSession();
		String ten = request.getParameter("ten");
		int id = Integer.parseInt(request.getParameter("User_id"));
		Category category = new Category();
		List<User> dsUser = this.uDao.selectAll();
		request.setAttribute("dsUser", dsUser);
		List<Category> dsCate = this.cateDao.selectAll();
		request.setAttribute("dsCate", dsCate);
		try {
			if (!Utils.StrUtils.isValue(ten) && !Utils.StrUtils.isValue(request.getParameter("User_id"))) {
				category.setTen(ten);
				User user = this.uDao.findById(id);
				category.setUser(user);
				BeanUtils.populate(category, request.getParameterMap());
				this.cateDao.updateCategory(category);
				session.setAttribute("message", "Cập nhật tài khoản thành công!");
			} else {
				session.setAttribute("error", "Cập nhật tài khoản không thành công chưa đủ thông tin!");
			}
			response.sendRedirect(request.getContextPath() + "/cate/viewCate");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/cate/viewUpdate?=" + id);
		}
	}

	protected void viewUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ID = request.getParameter("id");
		int id = Integer.parseInt(ID);
		Category category = this.cateDao.findById(id);
		List<User> dsUser = this.uDao.selectAll();
		List<Category> dsCate = this.cateDao.selectAll();
		request.setAttribute("category", category);
		request.setAttribute("dsUser", dsUser);
		request.setAttribute("view", "/views/admin/caterory/UpdateCate.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	
	protected void Categorydelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		HttpSession session = request.getSession();
		try {
			String idCate = request.getParameter("id");
			int id = Integer.parseInt(idCate);
			Category category = this.cateDao.findById(id);
			this.cateDao.deleteCategory(category);
			session.setAttribute("message", "Xoá thành công!");
			response.sendRedirect(request.getContextPath()+"/cate/viewCate");
		} catch (Exception e) {
	e.printStackTrace();
	session.setAttribute("error", "Xóa thất bại!");
		}
	}
}
