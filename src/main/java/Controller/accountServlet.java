package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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

@WebServlet("/accCreate")
@MultipartConfig
public class accountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDao UDAO;
	private List<User> dsUsers;

	public accountServlet() {
		super();
		this.UDAO = new userDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("view", "/views/admin/users/viewCreate.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		HttpSession session = request.getSession();
		User entity = new User();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
			if (!Utils.NumberUtil.isValue(entity.getId()) && !Utils.StrUtils.isValue(entity.getPassword())
					&& !Utils.StrUtils.isValue(entity.getEmail()) && !Utils.StrUtils.isValue(entity.getSdt())
					&& !Utils.NumberUtil.isValue(entity.getVaitro()) && Utils.PhoneUtil.isPhoneValid(entity.getSdt())
					&& Utils.EmailUtil.isValidEmail(entity.getEmail())) {
			
				String encypted = EncryptUtil.encrypt(request.getParameter("password"));

				entity.setPassword(encypted);
				entity.setVaitro(1);
				this.UDAO.createUser(entity);
				this.dsUsers = UDAO.selectAll();
				session.setAttribute("message", "bạn đăng ký tài khoản thành công");
				response.sendRedirect(request.getContextPath() + "/loginServlet");
			} else {
				session.setAttribute("error", "Bạn chưa nhập đủ dữ liện xin mời kiểm tra!");
				response.sendRedirect(request.getContextPath() + "/accCreate");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Thêm mới thất bạn xin bạn kiểu tra lại");
			response.sendRedirect(request.getContextPath() + "/accCreate");
		}
	}

}
