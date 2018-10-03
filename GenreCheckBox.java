/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : GenreCheckBox.java
 * Name : Emily Williams 
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
 * if statement
 * 
 * Method checkGenreCheckBox
 * uses if statements to determine what check boxes are selected 
 * and then uses a sql command based on Default Drop Down item that is selected
 * the method returns a string based on a sql statement
 * 
 * Changes : <Description|date of modifications>
 *
 ********************************************************/
package movies;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class GenreCheckBox {
	
	public String checkGenreCheckBox(JCheckBox chckbxSearchActor,
			JCheckBox chckbxImdbRating, JCheckBox checkBoxGenre,
			String sqlAssosiationButton, JComboBox<Object> actorBox,
			JComboBox<Object> imdbBox, JComboBox<Object> genreBox) {
		if (checkBoxGenre.isSelected() && !chckbxImdbRating.isSelected()
				&& !chckbxSearchActor.isSelected()) {
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.ImdbScore, "
					+ "m.Rating, a.FirstName, a.LastName " + "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID " + "WHERE Genre = '"
					+ genreBox.getSelectedItem() + "'";
		}
		if (checkBoxGenre.isSelected() && chckbxImdbRating.isSelected()
				&& !chckbxSearchActor.isSelected()) {
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.ImdbScore, "
					+ "m.Rating, a.FirstName, a.LastName " + "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID " + "WHERE Genre = '"
					+ genreBox.getSelectedItem() + "'" + "AND ImdbScore = "
					+ imdbBox.getSelectedItem();
		}
		if (checkBoxGenre.isSelected() && chckbxSearchActor.isSelected()
				&& !chckbxImdbRating.isSelected()) {
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.ImdbScore, "
					+ "m.Rating, a.FirstName, a.LastName " + "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID "
					+ "WHERE LastName = '" + actorBox.getSelectedItem() + "'"
					+ "AND Genre = '" + genreBox.getSelectedItem() + "'";
		}
		if (chckbxImdbRating.isSelected() && checkBoxGenre.isSelected()
				&& chckbxSearchActor.isSelected()) {
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.ImdbScore, "
					+ "m.Rating, a.FirstName, a.LastName " + "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID "
					+ "WHERE LastName = '" + actorBox.getSelectedItem() + "'"
					+ "AND Genre = '" + genreBox.getSelectedItem() + "'"
					+ "AND ImdbScore = " + imdbBox.getSelectedItem();
		}
		if (!chckbxImdbRating.isSelected() && !checkBoxGenre.isSelected()
				&& !chckbxSearchActor.isSelected()) {
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.Rating, m.ImdbScore, a.FirstName, a.LastName "
					+ "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID ";
		}
		return sqlAssosiationButton;
	}
}
