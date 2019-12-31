package sakila.business.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.db.DBHelper;

public class RentalDao {
	
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
	   				  " WHERE r.return_date IS NULL";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Rental rental = new Rental();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
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
