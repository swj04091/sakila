package sakila.address.service;

import java.sql.*;
import java.util.List;

import sakila.address.model.Country;
import sakila.address.model.CountryDao;
import sakila.db.DBHelper;

public class CountryService {
	
	private CountryDao countryDao;
	
	public List<Country> selectCountryList() {
		List<Country> list = null;
		Connection conn = null;
		countryDao = new CountryDao();
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);
			list = countryDao.selectCountryList(conn);
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
		
		return list;
	}
	
	public void insertCountry(Country country) {
		
		System.out.println("Country Service로 넘어옴");
		
		countryDao = new CountryDao();
		Connection conn = null;
		
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);
			countryDao.insertCountry(conn, country);
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
