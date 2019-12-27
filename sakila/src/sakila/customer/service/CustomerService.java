package sakila.customer.service;

import java.sql.*;
import java.util.List;

import sakila.address.model.Address;
import sakila.address.model.AddressDao;
import sakila.customer.model.Customer;
import sakila.customer.model.CustomerDao;
import sakila.db.DBHelper;

public class CustomerService {
	
	private AddressDao addressDao;
	private CustomerDao customerDao;
	
	public List <Customer> selectCustomerList() {
		System.out.println("CustomerService로 넘어옴");
		customerDao = new CustomerDao();
		List<Customer> CustomerList = null;
		
		Connection conn = null;
		
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);
			CustomerList = customerDao.SelectCustomerList(conn);
			System.out.println("CustomerList: "+CustomerList);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, conn);
		}
		System.out.println("Service list:"+CustomerList);
		return CustomerList;
	}
	
	public void insertCustomer(Address address, Customer customer) {
		
		System.out.println("CustomerService로 넘어옴");
		System.out.println(customer);
		
		Connection conn = null;
		
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);
			addressDao = new AddressDao();
			int addressId = addressDao.insertAddress(conn, address);
			customer.getAddress().setAdressId(addressId);
			System.out.println("Service: "+addressId);
			customerDao = new CustomerDao();
			customerDao.insertCustomer(conn, customer);
			
			System.out.println(address.toString());
			System.out.println(customer.toString());
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, conn);
		}
	}
}
