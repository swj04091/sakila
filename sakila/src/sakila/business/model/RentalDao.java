package sakila.business.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sakila.customer.model.Customer;
import sakila.db.DBHelper;
import sakila.inventory.model.Film;
import sakila.inventory.model.Inventory;

public class RentalDao {
	
	public void returnVideo(int rentalId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "UPDATE rental SET `return_date`=NOW() WHERE  `rental_id`=?";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,rentalId);
			rs = stmt.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<Rental> selectRentalList(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Rental> list = new ArrayList<Rental>();
		String sql =  "SELECT r.rental_id, r.rental_date, ir.title, r.customer_id, r.staff_id FROM rental AS r" + 
					  " INNER JOIN (SELECT i.inventory_id, f.title" + 
	   				  "				  FROM inventory as i" + 
	   				  "				  INNER JOIN film as f" + 
	   				  "				  ON i.film_id = f.film_id)as ir" + 
	   				  " ON ir.inventory_id = r.inventory_id" + 
	   				  " WHERE r.return_date IS NULL" +
	   				  " ORDER BY r.rental_id ASC";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Rental rental = new Rental();
				rental.setRentalId(rs.getInt("r.rental_id"));
				rental.setRentalDate(rs.getString("r.rental_date"));
				
				rental.setInventory(new Inventory());
				rental.getInventory().setFilm(new Film());
				rental.getInventory().getFilm().setTitle(rs.getString("ir.title"));
				
				rental.setCustomer(new Customer());
				rental.getCustomer().setCustomerId(rs.getInt("r.customer_id"));
				
				rental.setStaff(new Staff());
				rental.getStaff().setStaffId(rs.getInt("r.staff_id"));
				list.add(rental);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int selectRentalCount(){
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM rental";
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
