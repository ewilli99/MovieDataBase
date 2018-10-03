package movies;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class ActorCheckBox {
	public String checkActorCheckBox(JCheckBox chckbxSearchActor, JCheckBox chckbxImdbRating, JCheckBox checkBoxGenre, String sqlAssosiationButton, JComboBox<Object> actorBox, JComboBox<Object> imdbBox, JComboBox<Object> genreBox ){
		if(chckbxSearchActor.isSelected() && !chckbxImdbRating.isSelected() && !checkBoxGenre.isSelected()){
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.ImdbScore, "
					+ "m.Rating, a.FirstName, a.LastName "
					+ "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID "
					+"WHERE LastName = '"
					+ actorBox.getSelectedItem()
					+ "'";
		}
		if(chckbxSearchActor.isSelected() && chckbxImdbRating.isSelected() && !checkBoxGenre.isSelected()){
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.ImdbScore, "
					+ "m.Rating, a.FirstName, a.LastName "
					+ "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID "
					+ "WHERE LastName = '"
					+ actorBox.getSelectedItem()
					+ "'"
					+ "AND ImdbScore = " + imdbBox.getSelectedItem();
		}
		if(chckbxSearchActor.isSelected() && checkBoxGenre.isSelected() && !chckbxImdbRating.isSelected()){
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.ImdbScore, "
					+ "m.Rating, a.FirstName, a.LastName "
					+ "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID "
					+ "WHERE LastName = '"
					+ actorBox.getSelectedItem()
					+ "'"
					+ "AND Genre = '"
					+ genreBox.getSelectedItem()
					+ "'";
		}
		if(chckbxImdbRating.isSelected() && checkBoxGenre.isSelected() && chckbxSearchActor.isSelected()){
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.ImdbScore, "
					+ "m.Rating, a.FirstName, a.LastName "
					+ "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID "
					+ "WHERE LastName = '"
					+ actorBox.getSelectedItem()
					+ "'"
					+ "AND Genre = '"
					+ genreBox.getSelectedItem()
					+ "'" + "AND ImdbScore = " + imdbBox.getSelectedItem();
		}
		if(!chckbxImdbRating.isSelected() && !checkBoxGenre.isSelected() && !chckbxSearchActor.isSelected()){
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.Rating, m.ImdbScore, a.FirstName, a.LastName "
					+ "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID ";
		}
		return sqlAssosiationButton;
	}
}
