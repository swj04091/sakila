package sakila.business.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.address.model.Address;
import sakila.address.model.City;
import sakila.business.model.Staff;
import sakila.business.model.Store;
import sakila.business.service.StaffService;

@WebServlet("/insertStaff")
public class InsertStaff extends HttpServlet {
	
	private StaffService staffService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("InsertStaff Controller");
		int cityId       = Integer.parseInt(request.getParameter("cityId"));
		String address   = request.getParameter("address");
		String address2  = request.getParameter("address2");
		String district  = request.getParameter("district");
		String postalCode= request.getParameter("postalCode");
		String phone     = request.getParameter("phone");
		int storeId      = Integer.parseInt(request.getParameter("storeId"));
		String firstName = request.getParameter("firstName");
		String lastName  = request.getParameter("lastName");
		String email     = request.getParameter("email");
		String userName  = request.getParameter("userName");
		String password  = request.getParameter("password");
		
		System.out.println("CityId: "+cityId+" Address: "+address+" Address2: "+address2+" dostrict: "+district);
		System.out.println("postalCode: "+postalCode+ " phone: "+phone+" storeId: "+storeId);
		System.out.println("firstName: "+firstName+" lastName: "+lastName+" email: "+email+" userName: "+userName+" password: "+password);
		
		Address ad = new Address();
		ad.setAdress(address);
		ad.setAdress2(address2);
		ad.setCity(new City());
		ad.getCity().setCityId(cityId);
		ad.setDistrict(district);
		ad.setPhone(phone);
		ad.setPostalCode(postalCode);
		System.out.println(ad);
		
		Staff staff = new Staff();
		staff.setFirstName(firstName);
		staff.setLastName(lastName);
		staff.setEmail(email);
		staff.setUserName(userName);
		staff.setPassword(password);
		staff.setStore(new Store());
		staff.getStore().setStoreId(storeId);
		System.out.println(staff);
		
		StaffService staffService = new StaffService();
		staffService.insertStaff(ad, staff);
		
	}

}
