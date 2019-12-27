package sakila.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.customer.model.Customer;
import sakila.customer.model.CustomerDao;
import sakila.customer.service.CustomerService;


@WebServlet("/selectCustomerList")
public class SelectCustomerList extends HttpServlet {
    
	private CustomerService customerService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("apllication/json;charset=UTF-8");
		customerService = new CustomerService();
		List <Customer> list = null;
		
		System.out.println("/selectCustomerList");
		list = customerService.selectCustomerList();
		System.out.println("Servlet List: "+list);
				
		Gson gson = new Gson();
		String JsonStr = gson.toJson(list);
		System.out.println("JsonStr: "+JsonStr);
		
		response.getWriter().write(JsonStr);
	}

}
