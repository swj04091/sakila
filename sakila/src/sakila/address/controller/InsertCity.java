package sakila.address.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.address.model.City;
import sakila.address.model.Country;
import sakila.address.service.CityService;

/**
 * Servlet implementation class InsertCity
 */
@WebServlet("/insertCity")
public class InsertCity extends HttpServlet {
	
	private CityService cityService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countryId = request.getParameter("countryId");
		System.out.println("countryId Servlet"+countryId);
		
		cityService = new CityService();
		City city = new City();
		city.setCountry(new Country());
		city.getCountry().setCountryId(Integer.parseInt(countryId));
		city.setCity(request.getParameter("city"));
		
		cityService.insertCity(city);
		
	}
}
