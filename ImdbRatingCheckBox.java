package movies;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class ImdbRatingCheckBox {
	public String checkImdbCheckBox(JCheckBox chckbxSearchActor,
			JCheckBox chckbxImdbRating, JCheckBox checkBoxGenre,
			String sqlAssosiationButton, JComboBox<Object> actorBox,
			JComboBox<Object> imdbBox, JComboBox<Object> genreBox) {
		if (chckbxImdbRating.isSelected() && !chckbxSearchActor.isSelected()
				&& !checkBoxGenre.isSelected()) {
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.ImdbScore, "
					+ "m.Rating, a.FirstName, a.LastName " + "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID "
					+ "WHERE ImdbScore = " + imdbBox.getSelectedItem();
		}
		if (chckbxImdbRating.isSelected() && chckbxSearchActor.isSelected()
				&& !checkBoxGenre.isSelected()) {
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.ImdbScore, "
					+ "m.Rating, a.FirstName, a.LastName " + "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID "
					+ "WHERE LastName = '" + actorBox.getSelectedItem() + "'"
					+ "AND ImdbScore = " + imdbBox.getSelectedItem();
		}
		if (chckbxImdbRating.isSelected() && checkBoxGenre.isSelected()
				&& !chckbxSearchActor.isSelected()) {
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.ImdbScore, "
					+ "m.Rating, a.FirstName, a.LastName " + "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID " + "WHERE Genre = '"
					+ genreBox.getSelectedItem() + "'" + "AND ImdbScore = "
					+ imdbBox.getSelectedItem();
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
		if(!chckbxImdbRating.isSelected() && !checkBoxGenre.isSelected() && !chckbxSearchActor.isSelected()){
			sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.Rating, m.ImdbScore, a.FirstName, a.LastName "
					+ "FROM Movie m "
					+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
					+ "JOIN Actor a ON ama.ActorID = a.ID ";
		}
		return sqlAssosiationButton;
	}

}
