package sakila.address.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertAddress
 */
@WebServlet("/insertAddress")
public class InsertAddress extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String district = request.getParameter("district");
		String postalCode = request.getParameter("postalCode");
		String phone = request.getParameter("phone");
		
		System.out.println("cityId: "+cityId + "address: "+address +"address2: "+ address2 + "district: "+district + "postalCode: "+postalCode +"phone: "+ phone);
	}

}
