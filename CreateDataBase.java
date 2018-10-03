/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : CreateDataBase.java
 * Name : Emily Williams 
 * Date : 10 October 2018
 *
 * Description : (Narrative desciption, not code)
 *
 * 1) What is the purpose of the code; what problem does the code solve.
 * This class is used to createTables,dropTables, or fillTables for specified Classes that are being called 
 *
 * 2) What data-structures are used.
 * Classes, Statement, Connection
 * 
 *
 * 3) What algorithms, techniques, etc. are used in implementing the data structures.
 * try catch, foreach
 * 
 * Method executeSqlStatement
 * this method calls the sqlStatement makes sure that the database is created and executes the specified Sql statement
 * 
 * Changes : <Description|date of modifications>
 *
 ********************************************************/
package movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBase {

	public static void main(String[] args) throws SQLException {
		/*executeSqlStatement(ActorsSql.dropTable(),ActorsSql.createTable(),ActorsSql.fillTable());
		executeSqlStatement(AssociationSql.dropTable(),AssociationSql.createTable(),AssociationSql.fillTable());
		System.out.println("Done");*/

	}

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
