package sakila.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.db.DBHelper;

public class CityDao {
	
	public void insertCity(Connection conn, City city) {
		PreparedStatement stmt = null;
		String sql ="INSERT INTO city(city, country_id, last_update) VALUES(?,?,now())";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, city.getCity());
			stmt.setInt(2, city.getCountry().getCountryId());
			System.out.println(stmt);
			
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, stmt, null);
		}
	}
	
	public List<City> selectCityListByCountry(int countryId){
		List<City> list = new ArrayList<City>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT city_id, city, last_update FROM city WHERE country_id=?";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, countryId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				City city = new City();
				city.setCityId(rs.getInt("city_id"));
				city.setCity(rs.getString("city"));
				city.setLastUpate(rs.getString("last_update"));
				list.add(city);
			}
			
		}catch(Exception e) {
			
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
	public int selectCityCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM city";
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
	
	public List<City> selectCityList(){
		/*
		 * city INNER JOIN country
		 * */
		List<City> list =new ArrayList<City>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ci.city_id, ci.city, co.country_id, co.country, ci.last_update from city ci INNER JOIN country co ON co.country_id = ci.country_id";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				City city = new City();
				city.setCityId(rs.getInt("ci.city_id"));
				city.setCity(rs.getString("ci.city"));
				
				city.setCountry(new Country());
				
				city.getCountry().setCountryId(rs.getInt("co.country_id"));
				city.getCountry().setCountry(rs.getString("co.country"));
				
				city.setLastUpate(rs.getString("ci.last_update"));
				list.add(city);
			}
			System.out.println("DAO list: "+list);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	} 
}
