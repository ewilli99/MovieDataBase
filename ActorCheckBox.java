/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : ActorCheckBox.java
 * Name : Emily Williams Jeremy Jacobson
 * Date : 10 October 2018
 *
 * Description : (Narrative desciption, not code)
 *
 * 1) What is the purpose of the code; what problem does the code solve.
 * does multiple if statements in order to determine what the Assosiation Table will show each if statement as 
 * a different sql command
 *
 * 2) What data-structures are used.
 * Classes, String, JCheckBox, JCombo box
 * 
 *
 * 3) What algorithms, techniques, etc. are used in implementing the data structures.
 * if statement, Encapsulation
 * 
 * Method ActorBox
 * uses if statements to determine what check boxes are selected 
 * and then uses a sql command based on Default Drop Down item that is selected
 * The method uses encapsulation for better readability
 * 
 * Changes : <Description|date of modifications>
 *
 ********************************************************/
package movies;

public class ActorCheckBox {	
	String preSqlCommand = "SELECT  m.Title, m.Genre, m.ImdbScore, "
			+ "m.Rating, a.FirstName, a.LastName " + "FROM Movie m "
			+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
			+ "JOIN Actor a ON ama.ActorID = a.ID ";
	public String checkActorBox(SearchParamaters s, String sqlAssosiationButton) {
		if (!s.CheckBoxGenre.isSelected() && !s.CheckBoxImdbRank.isSelected() && s.CheckBoxActor.isSelected()) {
			sqlAssosiationButton = preSqlCommand + "WHERE LastName = '"
					+ s.Actor.getSelectedItem() + "'";
		}
		if (s.CheckBoxGenre.isSelected() && s.CheckBoxImdbRank.isSelected() && !s.CheckBoxActor.isSelected()) {
			sqlAssosiationButton = preSqlCommand + "WHERE LastName = '"
					+ s.Actor.getSelectedItem() + "'" + "AND ImdbScore = "
					+ s.ImdbRating.getSelectedItem();
		}
		if (s.CheckBoxGenre.isSelected() && !s.CheckBoxImdbRank.isSelected() && s.CheckBoxActor.isSelected()) {
			sqlAssosiationButton = preSqlCommand
					+ "WHERE LastName = '" + s.Actor.getSelectedItem() + "'"
					+ "AND Genre = '" + s.Genre.getSelectedItem() + "'";
		}
		if (s.CheckBoxGenre.isSelected() && s.CheckBoxImdbRank.isSelected() && s.CheckBoxActor.isSelected()) {
			sqlAssosiationButton = preSqlCommand
					+ "WHERE LastName = '" + s.Actor.getSelectedItem() + "'"
					+ "AND Genre = '" + s.Genre.getSelectedItem() + "'"
					+ "AND ImdbScore = " + s.ImdbRating.getSelectedItem();
		}
		
		if (!s.CheckBoxGenre.isSelected() && !s.CheckBoxImdbRank.isSelected() && !s.CheckBoxActor.isSelected()) {
			sqlAssosiationButton = preSqlCommand;
		}
		return sqlAssosiationButton;
	}
	
	
}
