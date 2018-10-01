package movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
	public static void main(String[] args) throws SQLException {
		// executeSqlStatement(StudentSql.dropTable());
		//executeSqlStatement(StudentSql.createTable(),StudentSql.fillTable());
		// executeQueries();
		// printStudents();
		//executeQueries(StudentSql.query_NameMajorCS());
		//executeQueries(StudentSql.query_NameMajorCS(),StudentSql.query_All());
		
		//executeSqlStatement(StudentCollegeSql.fillTable());
		//executeSqlStatement(CollegeSql.fillTable());
		//executeSqlStatement(CollegeSql.query_All());
		//executeQueries(CollegeSql.query_All());
		
		/*executeSqlStatement("INSERT INTO StudentCollege (StudentID, CollegeID) VALUES "
				+"(124, 11)");*/
		
		//executeSqlStatement(StudentCollegeSql.createTable());
		//executeSqlStatement(StudentCollegeSql.createTable());
		
		String assosiationMovieActor = "SELECT  m.Title, a.FirstName, a.LastName "
				   					 + "FROM Movie m " 
				   					 + "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
				   					 + "JOIN Actor a ON ama.ActorID = a.ID ";
		executeQueries(assosiationMovieActor);
									   
		//-----------EXECUTE STATEMENTS FOR DIRECTORS-----------//
		//executeSqlStatement(MoviesSql.createTable());
		//executeSqlStatement(MoviesSql.fillTable());
		//executeQueries(MoviesSql.query_All());
		
		//-----------EXECUTE STATEMENTS FOR DIRECTORS-----------//
		//executeSqlStatement(DirectorsSql.createTable());
		//executeSqlStatement(DirectorsSql.fillTable());
		//executeQueries(DirectorsSql.query_All());
		
		//-----------EXECUTE STATEMENTS FOR ACTORS-----------//
		//executeSqlStatement(ActorsSql.createTable());
		//executeSqlStatement(ActorsSql.fillTable());
		//executeQueries(ActorsSql.query_All());
		
		//-----------EXECUTE STATEMENTS FOR ASSOCIATION TABLE-----------//
		//executeSqlStatement(AssociationSql.createTable());
		//executeSqlStatement(AssociationSql.fillTable());
		//executeQueries(AssociationSql.query_All());
		System.out.println("Done");

	}
	
	public static void executeQueries(String... sqlQueries)
			throws SQLException {
		try (Connection connection = DriverManager
				.getConnection("jdbc:derby:MovieDataBase;create=true");
				Statement statement = connection.createStatement();) {

			for (String query : sqlQueries) {
				ResultSet results = statement.executeQuery(query);
				ResultSetMetaData metaData = results.getMetaData();
				printData(results, metaData);
			}
		}
	}
	
	private static void printData(ResultSet results, ResultSetMetaData metaData)
			throws SQLException {
		printHeader(metaData);
		// print data
		while (results.next()) {
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				System.out.printf("%-" + metaData.getColumnLabel(i).length()
						+ "s ", results.getObject(i));
			}
			System.out.println();
		}
	}

	@SuppressWarnings("unused")
	private static void printStudents() throws SQLException {
		try (Connection connection = DriverManager
				.getConnection("jdbc:derby:MovieDataBase;create=true");
				Statement statement = connection.createStatement();) {
			ResultSet results = statement
					.executeQuery("SELECT * FROM Students");
			ResultSetMetaData metaData = results.getMetaData();

			printData(results, metaData);
		}
	}

	private static void printHeader(ResultSetMetaData metaData)
			throws SQLException {
		int columntCount = metaData.getColumnCount();
		for (int i = 1; i <= columntCount; i++) {
			System.out.print(metaData.getColumnLabel(i) + " ");
		}
		System.out.println();
		for (int i = 1; i <= columntCount; i++) {
			for (int j = 0; j < metaData.getColumnLabel(i).length(); j++) {
				System.out.print('-');
			}
			if (i != columntCount) {
				System.out.print("--");
			}
		}
		System.out.println();
	}

	/**
	 * Executes the sql statements in the order passed by the user the sql
	 * statements that are passed as arguments do not return any data
	 * 
	 * @param sqlStatements
	 * @throws SQLException
	 */
	public static void executeSqlStatement(String... sqlStatements)
			throws SQLException {
		try (Connection connection = DriverManager
				.getConnection("jdbc:derby:MovieDataBase;create=true");
				Statement statement = connection.createStatement();) {

			for (String sqlStatement : sqlStatements) {
				statement.execute(sqlStatement);
			}

		}
	}
}
