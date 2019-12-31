package sakila.business.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.business.model.Staff;
import sakila.business.model.StaffDao;
import sakila.business.service.LoginService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private LoginService loginService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login Servlet");
		int staffId = Integer.parseInt(request.getParameter("staffId"));
		String password = request.getParameter("password");
		
		System.out.println("Servlet Staffid: "+staffId);
		System.out.println("Servlet password: "+password);
		
		Staff staff = new Staff();
		staff.setStaffId(staffId);
		staff.setPassword(password);
		System.out.println("Servlet staff: "+staff);
		
		loginService = new LoginService();
		int result = loginService.loginResult(staff);
		
		if(result == 0) {
			System.out.println("로그인 실패");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("sessionInfo", staff.getStaffId());
			System.out.println("로그인 성공");
		}
		
	}

}
