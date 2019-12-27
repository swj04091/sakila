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


@WebServlet("/selectCityList")
public class SelectCityList extends HttpServlet {
	
	private CityDao cityDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("apllication/json;charset=UTF-8");
		System.out.println("address/SelectCityList");
		
		cityDao = new CityDao();
		List <City> list = cityDao.selectCityList();
		
		System.out.println("CityList: "+list);
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		System.out.println("jsonList: "+jsonList);
		response.getWriter().write(jsonList);
		
	}

}
