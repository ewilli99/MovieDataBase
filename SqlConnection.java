/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : SqlConnection.java
 * Name : Emily Williams 
 * Date : 10 October 2018
 *
 * Description : (Narrative desciption, not code)
 *
 * 1) What is the purpose of the code; what problem does the code solve.
 * creates a connection to the database and lists location of the derby Driver
 *
 * 2) What data-structures are used.
 * Connection
 * 
 *
 * 3) What algorithms, techniques, etc. are used in implementing the data structures.
 * Calling Drivermanager and listing where the Derby Driver is located
 * 
 * Method dbConnector
 * this method uses is used to list where the Derby Driver is located, if the database is not created it creates the database
 * 
 * Changes : <Description|date of modifications>
 *
 ********************************************************/
package movies;

import java.sql.*;
import javax.swing.JOptionPane;

public class SqlConnection {
	Connection conn = null;

	public static Connection dbConnector() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection conn = DriverManager
					.getConnection("jdbc:derby:MovieDataBase;create=true");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}

	}

}
