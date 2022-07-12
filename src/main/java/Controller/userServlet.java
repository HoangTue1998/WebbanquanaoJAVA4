package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.beanutils.BeanUtils;
import DAO.userDao;
import Utils.EncryptUtil;
import entities.User;

@WebServlet({ "/users/viewUser", "/users/Update", "/users/Delete", "/users/viewCreate", "/users/viewUpdate",
		"/users/viewDelete", })
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDao UDAO;

	public userServlet() {
		super();
		this.UDAO = new userDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		String uri = request.getRequestURI();
		if (uri.contains("viewUser")) {
			this.viewUser(request, response);
		}else if (uri.contains("viewUpdate")) {
			this.viewUpdate(request, response);
		} else if (uri.contains("Delete")) {
			this.Delete(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		String uri = request.getRequestURI();
		if (uri.contains("Update")) {
			this.Update(request, response);
		}
	}

	protected void viewUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idUser = request.getParameter("id");
		int id = Integer.parseInt(idUser);
		User entity = this.UDAO.findById(id);
		request.setAttribute("user", entity);
		request.setAttribute("view", "/views/admin/users/viewUpdate.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	protected void Create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void Update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		HttpSession session = request.getSession();
		String idUpdateAc = request.getParameter("id");
		User newValue = new User();
		try {
			int id = Integer.parseInt(idUpdateAc);
			User oldValue = this.UDAO.findById(id);
			BeanUtils.populate(newValue, request.getParameterMap());
			newValue.setPassword(oldValue.getPassword());
			if(!Utils.NumberUtil.isValue(newValue.getId()) && !Utils.StrUtils.isValue(newValue.getPassword())) {
				this.UDAO.updateUser(newValue);	
				session.setAttribute("message", "Bạn cập nhật tài khoản thành công");
			}else {
				session.setAttribute("error", "Bạn cập nhật tài khoản không thành công");
			}
			response.sendRedirect(request.getContextPath() + "/users/viewUser");
	

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Cập nhật thất bại bạn xin vui lòng thử lại!");
			response.sendRedirect(request.getContextPath() + "/users/viewUpdate?id=" + idUpdateAc);
		}
	}

	protected void Delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idAccount = request.getParameter("id");
		int id = Integer.parseInt(idAccount);
		User entity = this.UDAO.findById(id);
		try {
			this.UDAO.deleteUser(entity);
			session.setAttribute("message", "Bạn đã xóa thành công!");
			response.sendRedirect(request.getContextPath() + "/users/viewUser");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Xoá thất bại!");
			response.sendRedirect(request.getContextPath() + "/users/viewUser");
		}
	}

	protected void viewUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> ListUser = this.UDAO.selectAll();
		request.setAttribute("ListUser", ListUser);
		request.setAttribute("view", "/views/admin/users/viewUserTb.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

}
