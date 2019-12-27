package sakila.address.service;

import java.sql.Connection;

import sakila.address.model.City;
import sakila.address.model.CityDao;
import sakila.db.DBHelper;

public class CityService {
	
	CityDao cityDao;
	
	public void insertCity(City city) {
		System.out.println("City Service로 넘어옴");
		
		cityDao = new CityDao();
		Connection conn = null;
		
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);
			cityDao.insertCity(conn, city);
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
