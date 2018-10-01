package movies;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetAllGenres {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private ArrayList<String> genres = new ArrayList<String>();
	private String genre;
	
	public ArrayList<String> getAllGenres(String statement)
			throws SQLException {
		conn = null;
		stmt = null;
		rs = null;
		genres = new ArrayList<String>();
		try {
			conn = SqlConnection.dbConnector();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery(statement);
			rs.getMetaData();

			while (rs.next()) {
				genre = rs.getString("Genre");
				genres.add(genre);

			}

			rs.last();
		} catch (SQLException e) {
			System.err.println(e);
		}
		if (rs != null) {
			conn.close();
		}
		if (stmt != null) {
			conn.close();
		}
		if (conn != null) {
			conn.close();
		}
		return genres;
	}

}
