/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : AssosiationTable.java
 * Name : Emily Williams 
 * Date : 10 October 2018
 *
 * Description : (Narrative desciption, not code)
 *
 * 1) What is the purpose of the code; what problem does the code solve.
 * creates a connection to the database and populates a JTable filled with Movie Table 
 *
 * 2) What data-structures are used.
 * Classes, String, int, Connection, Statement, ResultSet, DefaultTableModel
 * 
 *
 * 3) What algorithms, techniques, etc. are used in implementing the data structures.
 * while loop, try catch,
 * 
 * Method getConnectionAssosiation
 * this method uses a ResultSet in order to find information for each column in the Assosiation Table of the DataBase
 * while there is data the  ResultSet the information is added to each column specified and display the information on a JTable
 * 
 * Changes : <Description|date of modifications>
 *
 ********************************************************/

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
