package sakila.business.service;

import java.sql.Connection;
import java.util.List;

import sakila.address.model.Address;
import sakila.address.model.AddressDao;
import sakila.business.model.Staff;
import sakila.business.model.StaffDao;
import sakila.db.DBHelper;

public class StaffService {
	
	private AddressDao addressDao;
	private StaffDao staffDao;
	
	public List<Staff> SelectStaff(){
		System.out.println("SelectStaff StaffService");
		List <Staff> list = null;
		staffDao = new StaffDao();
		list = staffDao.selectStaff();
		System.out.println("ResultDao: "+list);
		return list;
	} 
	
	public void insertStaff (Address address, Staff staff) {
		System.out.println("StaffService!");
		System.out.println("Service Address: "+address);
		System.out.println("Service Staff: "+staff);
		
		Connection conn = null;
		
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);
			addressDao = new AddressDao();
			int addressId = addressDao.insertAddress(conn, address);
			System.out.println("StaffService: "+addressId);
			staff.setAddress(new Address());
			staff.getAddress().setAdressId(addressId);
			System.out.println("Service staff2:"+staff);
			//System.out.println(staff.getStore().getStoreId());
			staffDao = new StaffDao();
			staffDao.insertStaff(conn, staff);
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, conn);
		}
	}
}
