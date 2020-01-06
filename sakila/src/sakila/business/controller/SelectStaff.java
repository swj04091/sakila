package sakila.business.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.business.model.Staff;
import sakila.business.service.StaffService;

/**
 * Servlet implementation class selectStaff
 */
@WebServlet("/selectStaff")
public class SelectStaff extends HttpServlet {
	
	private StaffService staffService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("apllication/json;charset=UTF-8");
		System.out.println("SelectService Controller!");
		List<Staff> list = null;
		staffService = new StaffService();
		list = staffService.SelectStaff();
		
		System.out.println("Result Controller: "+list);
		
		Gson gson = new Gson();
		String JsonStr = gson.toJson(list);
		System.out.println("JsonStr: "+JsonStr);
		
		response.getWriter().write(JsonStr);
		
	}

}
