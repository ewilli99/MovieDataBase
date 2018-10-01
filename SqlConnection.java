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
