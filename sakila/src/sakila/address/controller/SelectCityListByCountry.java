package sakila.address.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.City;
import sakila.address.model.CityDao;


@WebServlet("/selectCityListByCountry")
public class SelectCityListByCountry extends HttpServlet {
	
	private CityDao cityDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		System.out.println("Controller: selectCityListByCountry");
		int countryId = Integer.parseInt(request.getParameter("countryId"));
		System.out.println("Servlet countryId: "+countryId);
		cityDao = new CityDao();
		List<City> list = cityDao.selectCityListByCountry(countryId);
		Gson gson = new Gson();
		String JsonStr = gson.toJson(list);
		System.out.println("JsonStr: "+JsonStr);
		
		response.getWriter().write(JsonStr);
	}

}
