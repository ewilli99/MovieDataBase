/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : ActorsSql.java
 * Name : Emily Williams 
 * Date : 10 October 2018
 *
 * Description : (Narrative desciption, not code)
 *
 * 1) What is the purpose of the code; what problem does the code solve.
 * Creates sql commands that will create a table, fill a table, or drop a table 
 *
 * 2) What data-structures are used.
 * Classes, sql commans
 * 
 *
 * 3) What algorithms, techniques, etc. are used in implementing the data structures.
 * Sql Commands
 * 
 * Changes : <Description|date of modifications>
 *
 ********************************************************/

package movies;

public class ActorsSql {
	
	/**
	 * creates Table called Directors
	 * 
	 * @return
	 */
	public static String createTable() {
		return 				
				"CREATE TABLE Actor (" 
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
				"INSERT INTO Actor (FirstName, LastName) VALUES "
					+"('Robert', 'Downy Jr'),"
					+"('Chris', 'Evans'),"
					+"('Chris', 'Heamsworth'),"
					+"('Mark', 'Ruffalo'),"
					+"('Tom', 'Holland'),"
					+"('Tom', 'Hiddleston'),"
					+"('Scarlet', 'Johanson'),"
					+"('Benjamin', 'Cumberbath'),"
					+"('Chris', 'Pratt'),"
					+"('Josh', 'Broln')";



	}

	/**
	 * deletes Actor table
	 * 
	 * @return
	 */
	public static String dropTable() {
		return "DROP TABLE Actor";
	}

	//---------------Query Statements---------------//

	public static String query_All() {
		return
				"SELECT * from Actor";
	}
}
