package sakila.address.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.Country;
import sakila.address.model.CountryDao;
import sakila.address.service.CountryService;


@WebServlet("/address/SelectCountryList")
public class SelectCountryList extends HttpServlet {
	
	private CountryService countryService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("apllication/json");
		System.out.println("/sakila/adress/selectCountryList");
		List<Country> list = null;
		
		countryService = new CountryService();
		list = countryService.selectCountryList();
		
		System.out.println("ServletList: "+list);
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		System.out.println(jsonList);
		response.getWriter().write(jsonList);
		
	}
}
