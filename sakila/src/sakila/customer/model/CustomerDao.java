package sakila.customer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.address.model.Address;
import sakila.business.model.Store;
import sakila.db.DBHelper;

public class CustomerDao {
	
	public List<Customer> SelectCustomerList(Connection conn){
		
		System.out.println("DAO로 넘어옴");
		
		List <Customer> list = new ArrayList<Customer>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT customer_id, store_id, first_name, last_name, email, address_id, active, create_date, last_update FROM customer";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Customer c= new Customer();
				c.setCustomerId(rs.getInt("customer_id"));
				c.setStore(new Store());
				c.getStore().setStoreId(rs.getInt("store_id"));
				c.setFirstName(rs.getString("first_name"));
				c.setLastName(rs.getString("last_name"));
				c.setEmail(rs.getString("email"));
				c.setAddress(new Address());
				c.getAddress().setAdressId(rs.getInt("address_id"));
				c.setActive(rs.getInt("active"));
				c.setCreateDate(rs.getString("create_date"));
				c.setLastUpdate(rs.getString("last_update"));
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, null);
		}
		System.out.println("DAO list: "+list);
		return list;
	}
	
	public void insertCustomer(Connection conn, Customer customer) throws Exception {
		
		System.out.println("DAO로 넘어옴");
		
		//Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO customer"+
					 "(store_id, first_name, last_name, email, address_id, active, create_date, last_update)"+
					 " VALUES(?,?,?,?,?,1,NOW(),NOW())";
		

			//conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, customer.getStore().getStoreId());
			stmt.setString(2, customer.getFirstName());
			stmt.setString(3,customer.getLastName());
			stmt.setString(4, customer.getEmail());
			stmt.setInt(5, customer.getAddress().getAdressId());
			
			System.out.println(stmt);
			stmt.executeUpdate();	
		
	}
	
	public int selectCustomerCount(){
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM customer";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
			
		}catch(Exception e) {
			
		}finally {
			DBHelper.close(rs, stmt, null);
		}
		return count;
	}
}
