package sakila.address.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.address.model.Country;
import sakila.address.model.CountryDao;

/**
 * Servlet implementation class InsertCountry
 */
@WebServlet("/address/InsertCountry")
public class InsertCountry extends HttpServlet {
	
	private CountryDao countryDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String country = request.getParameter("country");
		System.out.println("Country: "+country);
		System.out.println("/address/InsertCountry");
		
		countryDao = new CountryDao();
		Country c = new Country();
		c.setCountry(country);
		System.out.println("c.setCountry: "+country);
		countryDao.insertCountry(c);
		
	}

}
