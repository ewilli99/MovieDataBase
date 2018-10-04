/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : AssosiationSql.java
 * Name : Emily Williams Jeremy Jacobson
 * Date : 10 October 2018
 *
 * Description : (Narrative desciption, not code)
 *
 * 1) What is the purpose of the code; what problem does the code solve.
 * Creates sql commands that will create a table, fill a table, or drop a table for Assosiation
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

public class AssociationSql {

	public static String createTable() {
		return 					
				"CREATE TABLE AssociationMovieActor (" 
				+ "ActorID int, "
				+ "MovieID int)";
	}

	/**
	 * fills Table Movie with data
	 * 
	 * @return
	 */
	public static String fillTable() {
		return
				"INSERT INTO AssociationMovieActor (ActorID, MovieID) VALUES "
				+ "(1, 1),"
				+ "(1, 2),"
				+ "(1, 3),"
				+ "(1, 9),"
				+ "(1, 17),"
				+ "(1, 18),"
				+ "(1, 19),"
				+ "(1, 20),"
				+ "(1, 24),"
				+ "(2, 3),"
				+ "(2, 4),"
				+ "(2, 18),"
				+ "(2, 19),"
				+ "(2, 20),"
				+ "(3, 5),"
				+ "(3, 6),"
				+ "(3, 18),"
				+ "(3, 19),"
				+ "(3, 20),"
				+ "(4, 7),"
				+ "(4, 8),"
				+ "(4, 18),"
				+ "(4, 19),"
				+ "(5, 9),"
				+ "(5, 10),"
				+ "(5, 19),"
				+ "(6, 11),"
				+ "(6, 12),"
				+ "(6, 18),"
				+ "(6, 2),"
				+ "(6, 19),"
				+ "(6, 25),"
				+ "(7, 3),"
				+ "(7, 13),"
				+ "(7, 14),"
				+ "(7, 18),"
				+ "(7, 19),"
				+ "(7, 20),"
				+ "(8, 15),"
				+ "(8, 16),"
				+ "(8, 19),"
				+ "(9, 19),"
				+ "(9, 21),"
				+ "(9, 22),"
				+ "(10, 19),"
				+ "(10, 21),"
				+ "(10, 24),"
				+ "(10, 23),"
				+ "(10, 26)";
		
		
	}

	/**
	 * deletes Movie table
	 * 
	 * @return
	 */
	public static String dropTable() {
		return "DROP TABLE AssociationMovieActor";
	}

	//---------------Query Statements---------------//

	public static String query_All() {
		return
				"SELECT * from AssociationMovieActor";
	}
}
