package sakila.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sakila.db.DBHelper;

public class AddressDao {
	public int insertAddress(Connection conn, Address address) throws Exception {
		System.out.println("CustomerService로 넘어옴");
		int addressId = 0;
		//Connection conn = null;
		System.out.println(address);
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO address(address, address2, district, city_id, postal_code, phone, last_update) VALUES(?,?,?,?,?,?,now())";
		
		
			//conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);	//옵션 추가
			
			stmt.setString(1, address.getAdress());
			stmt.setString(2, address.getAdress2());
			stmt.setString(3, address.getDistrict());
			stmt.setInt(4, address.getCity().getCityId());
			stmt.setString(5, address.getPostalCode());
			stmt.setString(6, address.getPhone());
			
			System.out.println("insertAddress: "+stmt);
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();	//방금 입력한 행에 대한 primarykey값을 리턴함
			
			if(rs.next()) {
				addressId = rs.getInt(1);
			}
			System.out.println(stmt);
			
		return addressId;
	}
	
	public List<Address> selectAddressList(){
		List<Address> list = new ArrayList<Address>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT a.address_id,a.address,a.address2,a.district,a.city_id,a.postal_code, a.phone, a.last_update"  + 
					 " FROM address a" + 
					 " INNER JOIN city ci" + 
					 " INNER JOIN country co" + 
					 " ON a.city_id = ci.city_id" + 
					 " AND ci.country_id = co.country_id";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Address a = new Address();
				a.setAdressId(rs.getInt("a.address_id"));
				a.setAdress(rs.getString("a.address"));
				a.setAdress2(rs.getString("a.address2"));
				a.setDistrict(rs.getString("a.district"));
				
				a.setCity(new City());
				a.getCity().setCityId(rs.getInt("a.city_id"));
				a.setPostalCode(rs.getString("a.postal_code"));
				a.setPhone(rs.getString("a.phone"));
				a.setLastUpdate(rs.getString("a.last_update"));
				
				list.add(a);
			}
				
			}catch(Exception e) {
				
			}finally {
				DBHelper.close(rs, stmt, conn);
			}
			return list;
	}
	
	public int selectAddressCount(){
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM address";
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
