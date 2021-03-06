package sakila.business.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.db.DBHelper;

public class StaffDao {
	
	public List<Staff> selectStaff(){
		System.out.println("selectStaff DAO!");
		List<Staff> list = new ArrayList<Staff>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql =  "SELECT staff_id, CONCAT(first_name,' ',last_name) AS Name, email, store_id, active, username FROM staff";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Staff staff = new Staff();
				staff.setStaffId(rs.getInt("staff_id"));
				staff.setFirstName(rs.getString("Name"));
				staff.setEmail(rs.getString("email"));
				
				staff.setStore(new Store());
				staff.getStore().setStoreId(rs.getInt("store_id"));
				
				staff.setActive(rs.getInt("active"));
				staff.setUserName(rs.getString("username"));
				
				list.add(staff);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
	public void insertStaff(Connection conn, Staff staff) {
		System.out.println(conn);
		PreparedStatement stmt = null;
		System.out.println("DAO Staff: "+staff);
		String sql = "INSERT INTO staff (first_name, last_name, address_id, store_id, email,active, username , PASSWORD, last_update)" 
					+" VALUES (?, ?, ?, ?, ?, '1', ?, ?, NOW())";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,staff.getFirstName());
			stmt.setString(2,staff.getLastName());
			stmt.setInt(3,staff.getAddress().getAdressId());
			stmt.setInt(4,staff.getStore().getStoreId());
			stmt.setString(5,staff.getEmail());
			stmt.setString(6,staff.getUserName());
			stmt.setString(7,staff.getPassword());
			
			System.out.println("STMT: "+stmt);
			stmt.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, stmt, null);
		}
	}
	
	public int staffLogin(Staff staff) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(staff_id) FROM staff WHERE staff_id = ? AND PASSWORD = ?";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, staff.getStaffId());
			stmt.setString(2, staff.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("COUNT(staff_id)");
			}
			
		}catch(Exception e) {
			
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return result;
	}
	
	public int selectStaffCount(){
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM staff";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
			
		}catch(Exception e) {
			
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return count;
	}
}
