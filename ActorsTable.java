package movies;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

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

				modelActors
						.addRow(new Object[] { actorID, firstName, lastName });

			}
			rs.last();
		} catch (SQLException e) {
			System.err.println(e);
		}

		return conn;
	}
}
