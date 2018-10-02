/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : GetImdbScore.java
 * Name : Emily Williams 
 * Date : 10 October 2018
 *
 * Description : (Narrative desciption, not code)
 *
 * 1) What is the purpose of the code; what problem does the code solve.
 * creates an ArrayList that connects to the database and displays information onto a JComboBox that is being created in MainWindow 
 *
 * 2) What data-structures are used.
 * Classes, Connection, Statement, ResultSet, int, String, ArrayList
 * 
 *
 * 3) What algorithms, techniques, etc. are used in implementing the data structures.
 * connects to the database and displays the Actors last name onto the imdbScoreJcomboBox
 * 
 * Changes : <Description|date of modifications>
 *
 ********************************************************/
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
	private ArrayList<String> imdbScores = new ArrayList<String>();
	private String imdbScore;

	public ArrayList<String> getAllRating(String statement)
			throws SQLException {
		conn = null;
		stmt = null;
		rs = null;
		imdbScores = new ArrayList<String>();
		try {
			conn = SqlConnection.dbConnector();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery(statement);
			rs.getMetaData();

			while (rs.next()) {
				imdbScore = rs.getString("ImdbScore");
				imdbScores.add(imdbScore);

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
		return imdbScores;
	}
}
