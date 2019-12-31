package sakila.business.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetSessioninfo
 */
@WebServlet("/GetSessioninfo")
public class GetSessioninfo extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet 도착");
		//json 타입으로
		response.setContentType("application/json;charset=utf-8");
		
		HttpSession session = request.getSession();
		System.out.println("GetSessionInfo: "+session);
		Object sessionInfo = session.getAttribute("sessionInfo");
		System.out.println("GetSessionInfo: "+sessionInfo);
		//session.setAttribute("", "test@test.com");
		//session.invalidate();
		
		System.out.println("Servlet sessoinInfo : "+sessionInfo);
		
		Gson gson = new Gson();
		String json = gson.toJson(sessionInfo);
		
		response.getWriter().write(json);
	}

}
