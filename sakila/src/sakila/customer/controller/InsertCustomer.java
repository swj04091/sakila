package sakila.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.address.model.Address;
import sakila.address.model.City;
import sakila.business.model.Store;
import sakila.customer.model.Customer;
import sakila.customer.service.CustomerService;


@WebServlet("/insertCustomer")
public class InsertCustomer extends HttpServlet {

	private CustomerService customerService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		customerService = new CustomerService();
		System.out.println("Servlet넘어옴");
		//address 관련 request.getParameter("")
		int CityId = Integer.parseInt(request.getParameter("cityId"));
		System.out.println("INSERT Customer CITY ID: "+CityId);
		
		Address address = new Address();
		address.setCity(new City());
		address.getCity().setCityId(CityId);
		address.setAdress(request.getParameter("address"));
		address.setAdress2(request.getParameter("address2"));
		address.setDistrict(request.getParameter("district"));
		address.setPostalCode(request.getParameter("postalCode"));
		address.setPhone(request.getParameter("phone"));
		System.out.println("Insert Customer Address: "+address);
		
		
		int storeId = Integer.parseInt(request.getParameter("storeId"));
		System.out.println(storeId);
		//customer 관련 request.getParameter("")
		Customer customer = new Customer();
		customer.setStore(new Store());
		customer.getStore().setStoreId(storeId);
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setEmail(request.getParameter("email"));
		customer.setAddress(new Address());
		System.out.println("Insert Customer customer: "+customer);
		
		customerService.insertCustomer(address, customer);
		
	}

}
