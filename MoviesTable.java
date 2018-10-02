/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : MoviesTable.java
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
 * Method getConnectionMovies
 * this method uses a ResultSet in order to find information for each column in the Movies Table of the DataBase
 * while there is data the  ResultSet the information is added to each column specified and display the information on a JTable
 * 
 * Changes : <Description|date of modifications>
 *
 ********************************************************/

package movies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class MoviesTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int movieID;
	String title;
	String releaseDate;
	int imdbScore;
	String genre;
	String director;
	String rating;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public MoviesTable() throws SQLException {


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

	/**
	 * creates a JTable where you can view items in movie database
	 * 
	 * @return
	 */
	public Connection getConnectionMovies(PreparedStatement ps, String statement, DefaultTableModel modelMovies)throws SQLException {
		conn = null;
		stmt = null;
		rs = null;
		try {
			conn = SqlConnection.dbConnector();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ps = conn.prepareStatement(statement);
			rs = ps.executeQuery();
			ResultSetMetaData rsmdMovie = rs.getMetaData();

			rsmdMovie.getColumnCount();

			while (rs.next()) {
				movieID = rs.getInt("ID");
				title = rs.getString("TITLE");
				releaseDate = rs.getString("RELEASEDATE");
				imdbScore = rs.getInt("IMDBSCORE");
				director = rs.getString("DIRECTOR");
				genre = rs.getString("GENRE");
				rating = rs.getString("Rating");

				modelMovies.addRow(new Object[] { movieID, title, releaseDate,
						imdbScore, director, genre, rating });

			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return conn;
	}

}
