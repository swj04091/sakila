package sakila.inventory.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sakila.db.DBHelper;

public class FilmDao {
	
	public List<Film> selectFilmList() throws SQLException{
		List<Film> list = new ArrayList<Film>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT " + 
					 " film_id, " + 
					 " title, " + 
					 " description, " + 
					 " release_year, " + 
					 " language_id, " + 
					 " original_language_id, " + 
					 " rental_duration, " + 
					 " rental_rate, " + 
					 " LENGTH, " + 
					 " replacement_cost, " + 
					 " rating, " + 
					 " special_features, " + 
					 " last_update " + 
					 " FROM film";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Film film = new Film();
				film.setFilmId(rs.getInt("film_id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getString("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setOriginalLanguageId(rs.getInt("original_language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getInt("rental_rate"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				film.setLastUpdate(rs.getString("last_update"));
				film.setLength(rs.getInt("LENGTH"));
				list.add(film);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
		return list;
		
	}
	
}
