package sakila.address.model;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import sakila.db.DBHelper;

public class CountryDao {
	
	public List<Country> selectCountryListAll(){
		List<Country> list = new ArrayList<Country>();
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql ="SELECT * FROM country ORDER BY country_id DESC";
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Country c = new Country();
				c.setCountryId(rs.getInt("country_id"));
				c.setCountry(rs.getString("country"));
				list.add(c);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
	public int selectCountryCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM country";
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
	
	public List<Country> selectCountryList(Connection conn){
		List<Country> list = new ArrayList<Country>();
		PreparedStatement stmt = null;
		String sql ="SELECT * FROM country ORDER BY country_id DESC LIMIT 100";
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Country c = new Country();
				c.setCountryId(rs.getInt("country_id"));
				c.setCountry(rs.getString("country"));
				c.setLastUpdate(rs.getString("last_update"));
				list.add(c);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println(list);
			DBHelper.close(rs, stmt, null);
		}
		return list;
	}
	
	public void insertCountry(Connection conn, Country country) {
		PreparedStatement stmt = null;
		String sql ="INSERT INTO country(country, last_update) VALUES(?,now())";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, country.getCountry());
			System.out.println(stmt);
			
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, stmt, null);
		}
	}
}
