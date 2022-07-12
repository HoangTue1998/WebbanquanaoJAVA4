package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.userDao;
import Utils.CookieUtil;
import Utils.EncryptUtil;
import entities.User;

@WebServlet({ "/loginServlet", "/logOut", "/lg" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDao UDAO;
	public loginServlet() {
		super();
		this.UDAO = new userDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		String uri = request.getRequestURI();
		if (uri.contains("loginServlet")) {
			this.loginServlet(request, response);
		}else if (uri.contains("logOut")) {
			this.logOut(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("lg")) {
			this.lg(request, response);
		} else if (uri.contains("logOut")) {
			this.logOut(request, response);
		}
	}

	protected void loginServlet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("view", "/views/admin/users/login.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

	protected void lg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		HttpSession session = request.getSession();
		String email = request.getParameter("email"), pwd = request.getParameter("password");
		if (email.length() == 0 || pwd.length() == 0) {
			session.setAttribute("error", "Thông tin không được để trống!");
			response.sendRedirect(request.getContextPath() + "/loginServlet");
		} else {
			try {
				User user = this.UDAO.findByEmail(email);

				if (EncryptUtil.check(pwd, user.getPassword())) {
					CookieUtil.addCookie("email", email, 2, response);
					CookieUtil.addCookie("password", pwd, 2, response);
					session.setAttribute("user", user);
					response.sendRedirect(request.getContextPath()+"/Home");
					session.setAttribute("message", "Đăng nhập thành công");

				} else {
					session.setAttribute("error", "Đăng nhập thất bại mời kiểm tra lại tài khoản hoặc mật khẩu!");
					response.sendRedirect(request.getContextPath() + "/loginServlet");
				}
			} catch (Exception e) {
				response.sendRedirect(request.getContextPath() + "/loginServlet");
			}

		}

	}

	protected void logOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
	    HttpSession session = request.getSession();  
	    session.removeAttribute("user");
        session.invalidate(); 

		response.sendRedirect(request.getContextPath() + "/loginServlet");
	

	}

}
