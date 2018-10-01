package movies;

public class DirectorsSql {
	
	/**
	 * creates Table called Directors
	 * 
	 * @return
	 */
	public static String createTable() {
		return 				
				"CREATE TABLE Director (" 
				+ "ID int not null primary key "
				+ "GENERATED ALWAYS AS IDENTITY "
				+ "(START WITH 1, INCREMENT BY 1), "
				+ "LastName varchar(255), " 
				+ "FirstName varchar(255))";
	}

	/**
	 * fills Table Directors with data
	 * 
	 * @return
	 */
	public static String fillTable() {
		return 
				"INSERT INTO Director (FirstName, LastName) VALUES "
				+ "('Favreau', 'Jon'), "
				+ "('Ritchie', 'Guy'), "
				+ "('Russo', 'Joe'), "
				+ "('Evans', 'Chris'), "
				+ "('Waititi', 'Taika'), "
				+ "('Sanders', 'Rupert'), "
				+ "('Winick', 'Gary'), "
				+ "('Leterrier', 'Louis'), "
				+ "('Watts', 'Jon'), "
				+ "('Gomez-Rejon', 'Alfonso'), "
				+ "('Branagh', 'Kenneth'), "
				+ "('Vogt-Roberts', 'Jordan'), "
				+ "('Jonze', 'Spike'), "
				+ "('Coppola', 'Sofia'), "
				+ "('Tyldum', 'Morten'), "
				+ "('Derrickson', 'Scott'), "
				+ "('Favreau', 'Jon'), "
				+ "('Whedon', 'Joss'), "
				+ "('Bros', 'Russo'), "
				+ "('Gunn', 'James'), "
				+ "('Trevorrow', 'Colin'), "
				+ "('Villeneuve', 'Deni'), "
				+ "('Bros', 'Coen')";


	}

	/**
	 * deletes Director table
	 * 
	 * @return
	 */
	public static String dropTable() {
		return "DROP TABLE Director";
	}

	//---------------Query Statements---------------//

	public static String query_All() {
		return
				"SELECT * from Director";
	}
}
