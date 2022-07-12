package Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.LoadBalancedAutoCommitInterceptor;

public class CookieUtil {
	public synchronized static Cookie addCookie(String name, String values, int hour, HttpServletResponse res) {
		Cookie cookie = new Cookie(name, values);// khởi tạo 1 cookie có name và add value là tham số truyền vào
		cookie.setPath("/");// set đường dẫn hoạt động cook
		cookie.setMaxAge(hour * 24 * 60);
		res.addCookie(cookie);// add cookie ào response để hiển thị
		return cookie;
	}

	public synchronized static String getCookie(String name, HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();// lấy danh sách cook từ phía server
		if (cookies != null) {
			for (Cookie x : cookies) {
				if (name.equals(x.getName()))
					return x.getValue();
			}

		}
		return null;
	}
}
