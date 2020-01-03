package sakila.business.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.business.model.Rental;
import sakila.business.service.RentalService;

/**
 * Servlet implementation class getRentalList
 */
@WebServlet("/getRentalList")
public class getRentalList extends HttpServlet {
	
	private RentalService rentalService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getRentalList 요청");
		response.setContentType("apllication/json;charset=UTF-8");
		
		rentalService = new RentalService();
		List<Rental> list = rentalService.selectRental();
		System.out.println("Controller Service: "+list);
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		System.out.println(jsonList);
		response.getWriter().write(jsonList);
		
	}

}
