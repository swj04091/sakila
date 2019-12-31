package sakila.business.service;

import sakila.business.model.Staff;
import sakila.business.model.StaffDao;

public class LoginService {
	private StaffDao staffDao;
	
	public int loginResult(Staff staff) {
		System.out.println("Login Service");
		System.out.println(staff);
		
		staffDao = new StaffDao();
		int result = staffDao.staffLogin(staff);
		System.out.println("Service Result: "+result);
		return result;
	}
}
