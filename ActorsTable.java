/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : ActorsTable.java
 * Name : Emily Williams Jeremy Jacobson
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
 * Method getConnectionActors
 * this method uses a ResultSet in order to find information for each column in the Actors Table of the DataBase
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

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ActorsTable extends JTable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String firstName;
	String lastName;
	int actorID;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public ActorsTable() throws SQLException {

	}
	
	public JScrollPane tableMovies(DefaultTableModel modelMovies, JTable tableMovies, JScrollPane paneMovies) {
		modelMovies = new DefaultTableModel();
		modelMovies.addColumn("Movie ID");
		modelMovies.addColumn("Title");
		modelMovies.addColumn("Release Date");
		modelMovies.addColumn("Imdb Score");
		modelMovies.addColumn("Director");
		modelMovies.addColumn("Genre");
		modelMovies.addColumn("Rating");

		tableMovies = new JTable(modelMovies);
		tableMovies.setEnabled(false);

		paneMovies = new JScrollPane(tableMovies);
		return paneMovies;
	}

	public Connection getConnectionActors(String statement,
			DefaultTableModel modelActors) throws SQLException {
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
				actorID = rs.getInt("ID");
				firstName = rs.getString("FirstName");
				lastName = rs.getString("LastName");

				modelActors.addRow(new Object[] { actorID, firstName, lastName });

			}
			rs.last();
		} catch (SQLException e) {
			System.err.println(e);
		}

		return conn;
	}
}
