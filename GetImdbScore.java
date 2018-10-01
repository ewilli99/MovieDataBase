package movies;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetImdbScore {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private ArrayList<String> ratings = new ArrayList<String>();
	private String rating;

	public ArrayList<String> getAllRating(String statement)
			throws SQLException {
		conn = null;
		stmt = null;
		rs = null;
		ratings = new ArrayList<String>();
		try {
			conn = SqlConnection.dbConnector();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery(statement);
			rs.getMetaData();

			while (rs.next()) {
				rating = rs.getString("ImdbScore");
				ratings.add(rating);

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
		return ratings;
	}
}
