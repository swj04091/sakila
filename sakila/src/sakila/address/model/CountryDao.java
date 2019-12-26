package sakila.address.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.print.PrintException;

import java.sql.*;
import sakila.db.DBHelper;

public class CountryDao {
	
	//페이지의 마지막을 구하기 위한 전체의 갯수 구하기.
	public int selectCount() {
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
	
	//리스트를 출력하되, 페이징 작업을 하기 위해 현재의 페이지를 매게변수로 받아옴.
	public List<Country> selectCountryList(int currentPage){
		List<Country> list = new ArrayList<Country>();
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql ="SELECT * FROM country ORDER BY country_id DESC LIMIT ?,?";
		ResultSet rs = null;
		
		int ROW_PER_PAGE = 10;
		int beginRow = (currentPage-1)*ROW_PER_PAGE;
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, ROW_PER_PAGE);
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
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
	//Country를 새로 넣기 위해 coutry데이터타입으로 매게변수로 받아옴
	public void insertCountry(Country country) {
		Connection conn = null;
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
			DBHelper.close(null, stmt, conn);
		}
	}
}
