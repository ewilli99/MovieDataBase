package movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//executeSqlStatement(MoviesSql.dropTable(),MoviesSql.createTable(),MoviesSql.fillTable());
		/*executeSqlStatement(MoviesSql.fillTable());*/
		/*executeSqlStatement(ActorsSql.createTable());
		executeSqlStatement(ActorsSql.fillTable());*/
		//executeSqlStatement(AssociationSql.createTable());
		//executeSqlStatement(AssociationSql.fillTable());
		//executeSqlStatement(AssociationSql.dropTable());
		System.out.println("Done");

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
