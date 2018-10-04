/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : DirectorsSql.java
 * Name : Emily Williams Jeremy Jacobson
 * Date : 10 October 2018
 *
 * Description : (Narrative desciption, not code)
 *
 * 1) What is the purpose of the code; what problem does the code solve.
 * Creates sql commands that will create a table, fill a table, or drop a table for Directors 
 *
 * 2) What data-structures are used.
 * Classes, sql commands
 * 
 *
 * 3) What algorithms, techniques, etc. are used in implementing the data structures.
 * Sql Commands
 * 
 * Changes : <Description|date of modifications>
 *
 ********************************************************/
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
