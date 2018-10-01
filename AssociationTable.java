package movies;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AssociationTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String firstName;
	String lastName;
	String movieActed;
	String rating;
	int imdbScore;
	private String genre;
	int movieID;
	int actorID;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public AssociationTable() throws SQLException {
		
	}
	public Connection getConnectionAssosiation(String statement, DefaultTableModel modelAssociation) throws SQLException {
		conn = null;
		stmt = null;
		rs = null;
		
		try {
			conn = SqlConnection.dbConnector();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery(statement);
			ResultSetMetaData rsmdMovie = rs.getMetaData();

			rsmdMovie.getColumnCount();

			while (rs.next()) {
				movieActed = rs.getString("Title");
				firstName = rs.getString("FirstName");
				lastName = rs.getString("LastName");
				genre = rs.getString("Genre");
				rating = rs.getString("Rating");
				imdbScore = rs.getInt("ImdbScore");

				modelAssociation.addRow(new Object[] { firstName, lastName,
						movieActed, genre, rating, imdbScore });

			}
			rs.last();
		} catch (SQLException e) {
			System.err.println(e);
		}

		return conn;
	}

}
