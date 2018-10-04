/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : MoviesSql.java
 * Name : Emily Williams Jeremy Jacobson
 * Date : 10 October 2018
 *
 * Description : (Narrative desciption, not code)
 *
 * 1) What is the purpose of the code; what problem does the code solve.
 * Creates sql commands that will create a table, fill a table, or drop a table for Movies
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

public class MoviesSql {
	/**
	 * creates Table called Movie
	 * 
	 * @return
	 */
	public static String createTable() {
		return 					
				"CREATE TABLE Movie (" + "ID int not null primary key "
				+ "GENERATED ALWAYS AS IDENTITY "
				+ "(START WITH 1, INCREMENT BY 1), " + "Title varchar(255), "
				+ "ReleaseDate int, " + "ImdbScore int, "
				+ "Director varchar(255), " + "Genre varchar(255), "
				+ "Rating varchar(255))";
	}

	/**
	 * fills Table Movie with data
	 * 
	 * @return
	 */
	public static String fillTable() {
		return
				"INSERT INTO Movie (Title, ReleaseDate, ImdbScore, Genre, Director, Rating) VALUES "
				+ "('Iron Man', 2008, 7.9, 'Sci-Fi', 'Favreau', 'PG-13'),"
				+ "('Sherlock Holmes', 2009, 7.6, 'Adventure', 'Ritchie', 'PG-13'),"
				+ "('Captian America Winter Soldier', 2014, 7.8, 'Sci-Fi', 'Russo', 'PG-13'),"
				+ "('Before we go', 2014, 6.8, 'Drama', 'Evans', 'PG-13'),"
				+ "('Thor Ragnarock', 2017, 7.9, 'Sci-Fi', 'Waititi', 'PG-13'),"
				+ "('Snow white and the huntsman', 2012, 6.1, 'Adventure', 'Sanders', 'PG-13'),"
				+ "('30 Going on 30', 2004, 6.1, 'Romance', 'Winick', 'PG-13'),"
				+ "('Now You See Me', 2013, 7.3, 'Mystery', 'Leterrier', 'PG-13'),"
				+ "('Spiderman homecoming', 2017, 7.5, 'Sci-Fi', 'Watts', 'PG-13'),"
				+ "('The Current War', 2017, 6.1, 'Drama', 'Gomez-Rejon', 'PG-13'),"
				+ "('The Night Manager', 2016, 8.2, 'Drama', 'Branagh', 'PG-13'),"
				+ "('Kong Skull Island', 2017, 6.7, 'Action', 'Vogt-Roberts', 'PG-13'),"
				+ "('Her', 2013, 8, 'Drama', 'Jonze', 'R'),"
				+ "('Lost in Translation', 2003, 7.8, 'Drama', 'Coppola', 'R'),"
				+ "('The imitation game', 2014, 8, 'Biography', 'Tyldum', 'PG-13'),"
				+ "('Doctor Strange', 2016, 7.5, 'Sci-Fi', 'Derrickson', 'PG-13'),"
				+ "('Iron Man 2', 2010, 7, 'Sci-Fi', 'Favreau', 'PG-13'),"
				+ "('The Avengers', 2012, 8.1, 'Sci-Fi', 'Whedon', 'PG-13'),"
				+ "('Infinity War', 2018, 8.6, 'Sci-Fi', 'Russo', 'PG-13'),"
				+ "('Captain America Civil War', 2016, 7.8, 'Sci-Fi', 'Russo', 'PG-13'),"
				+ "('Guardians of the Galaxy', 2014, 8.1, 'Sci-Fi', 'Gunn', 'PG-13'),"
				+ "('Jurassic World', 2018, 7, 'Adventure', 'Trevorrow', 'PG-13'),"
				+ "('Sicario', 2015, 7.6, 'Action', 'Villeneuve', 'PG-13'),"
				+ "('Only you', 1994, 6.5, 'Comedy', 'Jewison', 'PG'),"
				+ "('The Pirate Fairy', 2014, 6.7, 'Animation', 'Holmes', 'G'),"
				+ "('No Country for Old Men', 2007, 8.1, 'Crime', 'Coen', 'R')";
	}

	/**
	 * deletes Movie table
	 * 
	 * @return
	 */
	public static String dropTable() {
		return "DROP TABLE Movie";
	}

	//---------------Query Statements---------------//

	public static String query_All() {
		return
				"SELECT * from Movie";
	}
}
