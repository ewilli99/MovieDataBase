/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : MainWindow.java
 * Name : Emily Williams 
 * Date : 10 October 2018
 *
 * Description : (Narrative desciption, not code)
 *
 * 1) What is the purpose of the code; what problem does the code solve.
 * creates a connection to the database and populates a JTable filled with Movie Table 
 *
 * 2) What data-structures are used.
 * Classes, String, int, Connection, Statement, ResultSet, DefaultTableModel, JComboBox, JTable, JButton, 
 * Default ComboBox
 * 
 *
 * 3) What algorithms, techniques, etc. are used in implementing the data structures.
 * while loop, try catch, sql commands
 * 
 * Method populatJTables()
 * This method calls AssosiationTable, MoviesTable, and AssosiationTable and calls the getConnection on each class. 
 * The method populates each corresponding JTable and fills it with information from the database.
 * 
 * Method actorComboBox()
 * call class GetAllActors that uses an array list to populate items in the Actor table. Then sends the array list back
 * and is added to the Default ComboBox and calls the .ToArray() method
 * The methods imdbcomBox(), genreComboBox() uses the same form
 * 
 * Method searchDataBase()
 * is for the submit button after the user selects each drop down list the method calls a sql command using the 
 * WHERE, AND, SELECT, and JOIN statements. After the command the method the method myAssosiationTable is called and
 * populates information dynamically based on what the user selected.
 * 
 * Method resetSearch()
 * when the reset button is pressed the assosiation table resets with information with all actors and movies
 * 
 * Method tableActors(), tableAssosiation(), tableMovies()
 * creates DefaultTableModel, and adds columns to each table based on database table
 * 
 * Changes : <Description|date of modifications>
 *
 ********************************************************/
package movies;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel sortDataBase;

	private JTable tableMovies;
	private JTable tableAssosiates;
	private JTable tableActors;

	private JScrollPane paneMovies;
	private JScrollPane paneAssosiates;
	private JScrollPane paneActors;

	private DefaultTableModel modelMovies;
	private DefaultTableModel modelAssosiates;
	private DefaultTableModel modelActors;

	private JButton sortMovie;
	private JButton btnReset;

	private MoviesTable myMoviesTable = new MoviesTable();
	private AssociationTable myAssosiationTable = new AssociationTable();
	private ActorsTable myActorTable = new ActorsTable();

	private JComboBox<Object> actorBox;
	private JComboBox<Object> genreBox;
	private JComboBox<Object> imdbBox;

	private String sqlMovies = "SELECT * FROM Movie ";
	private String sqlActor = "SELECT * FROM Actor ";
	private String sqlAssosiation = "SELECT  m.Title, m.Genre, m.Rating, m.ImdbScore, a.FirstName, a.LastName "
			+ "FROM Movie m "
			+ "JOIN AssociationMovieActor ama ON ama.MovieID = m.ID "
			+ "JOIN Actor a ON ama.ActorID = a.ID ";

	private PreparedStatement ps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public MainWindow() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1381, 486);
		JPanel movieDataBase = new JPanel();
		movieDataBase.setLayout(new BorderLayout(0, 0));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(movieDataBase, BorderLayout.WEST);
		setContentPane(contentPane);

		JScrollPane movieTableScrollPane = tableMovies();
		JScrollPane paneAssosiate = tableAssosiates();
		JScrollPane paneActors = tableActors();
		
		populateJTables();
		sortDataBase();
		resetSearch();
		
		movieDataBase.add(movieTableScrollPane, BorderLayout.WEST);
		movieDataBase.add(paneAssosiate, BorderLayout.CENTER);
		movieDataBase.add(paneActors, BorderLayout.EAST);
		movieDataBase.add(sortDataBase, BorderLayout.SOUTH);
	}

	/**
	 * creates JTables with populated information from the database
	 * 
	 * @throws SQLException
	 */
	private void populateJTables() throws SQLException {
		myMoviesTable.getConnectionMovies(ps, sqlMovies, modelMovies);
		myActorTable.getConnectionActors(sqlActor, modelActors);
		myAssosiationTable.getConnectionAssosiation(sqlAssosiation,
				modelAssosiates);
	}

	/**
	 * Creates panel for searching database with Jcombo Boxes and JButtons
	 * 
	 * @throws SQLException
	 */
	private void sortDataBase() throws SQLException {
		sortDataBase = new JPanel();
		searchDataBase();
		actorComboBox();
		genreComboBox();
		imdbComboBox();

		sortDataBase.add(actorBox);
		sortDataBase.add(genreBox);
		sortDataBase.add(imdbBox);
		sortDataBase.add(sortMovie);
	}

	/**
	 * creates JComboBox that lists the rating for movies to select
	 * 
	 * @throws SQLException
	 */
	private void imdbComboBox() throws SQLException {
		imdbBox = new JComboBox<Object>();
		String ratingStatement = "SELECT DISTINCT ImdbScore FROM Movie ";
		GetImdbScore myGetAllRatings = new GetImdbScore();
		DefaultComboBoxModel<Object> modelRating = new DefaultComboBoxModel<>(
				myGetAllRatings.getAllRating(ratingStatement).toArray());
		imdbBox = new JComboBox<Object>(modelRating);
		imdbBox.setFont(new Font("Lucida Grande", Font.PLAIN, 13));

	}

	/**
	 * creates JComboBox that lists the actors for movies to select
	 * 
	 * @throws SQLException
	 */
	private void actorComboBox() throws SQLException {
		actorBox = new JComboBox<Object>();
		GetAllActors myGetAllActors = new GetAllActors();
		String actorStatement = "SELECT DISTINCT ID, FirstName, LastName FROM Actor ";
		DefaultComboBoxModel<Object> modelActor = new DefaultComboBoxModel<>(
				myGetAllActors.getAllActors(actorStatement).toArray());
		actorBox = new JComboBox<Object>(modelActor);
		actorBox.setFont(new Font("Lucida Grande", Font.PLAIN, 13));

	}

	/**
	 * creates JComboBox that lists the Genre for movies to select
	 * 
	 * @throws SQLException
	 */
	private void genreComboBox() throws SQLException {
		String genreStatement = "SELECT DISTINCT Genre FROM Movie ";
		GetAllGenres myGetAllGenres = new GetAllGenres();
		DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(
				myGetAllGenres.getAllGenres(genreStatement).toArray());
		genreBox = new JComboBox<Object>(model);
		genreBox.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	}

	/**
	 * creates JButton that searches database with JcomboBox
	 * 
	 * @throws SQLException
	 */
	private void searchDataBase() throws SQLException {
		sortMovie = new JButton("Search");
		sortMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sqlAssosiationButton = "SELECT  m.Title, m.Genre, m.ImdbScore, "
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

				try {
					modelAssosiates.setRowCount(0);
					myAssosiationTable.getConnectionAssosiation(
							sqlAssosiationButton, modelAssosiates);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
	}
	
	/**
	 * Resets the Assosiation Panel with all information for actors and movies
	 */
	private void resetSearch() {
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelAssosiates.setRowCount(0);
				try {
					myAssosiationTable.getConnectionAssosiation(sqlAssosiation,
							modelAssosiates);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		sortDataBase.add(btnReset);
	}

	/**
	 * JScroll Pane that displays column headers and creates JTable for Actors
	 * Table in DataBase
	 * 
	 * @throws SQLException
	 * @return
	 */
	private JScrollPane tableActors() {
		modelActors = new DefaultTableModel();
		modelActors.addColumn("Movie ID");
		modelActors.addColumn("First Name");
		modelActors.addColumn("Last Name");

		tableActors = new JTable(modelActors);
		tableActors.setCellSelectionEnabled(true);
		tableActors.setEnabled(false);

		paneActors = new JScrollPane(tableActors);
		return paneActors;
	}

	/**
	 * JScroll Pane that displays column headers and creates JTable for
	 * Assosiation Table in DataBase
	 * 
	 * @throws SQLException
	 * @return
	 */
	private JScrollPane tableAssosiates() {
		modelAssosiates = new DefaultTableModel();
		modelAssosiates.addColumn("First Name");
		modelAssosiates.addColumn("Last Name");
		modelAssosiates.addColumn("Movie");
		modelAssosiates.addColumn("Genre");
		modelAssosiates.addColumn("Rating");
		modelAssosiates.addColumn("Imdb Score");

		tableAssosiates = new JTable(modelAssosiates);
		tableAssosiates.setEnabled(false);

		paneAssosiates = new JScrollPane(tableAssosiates);
		return paneAssosiates;
	}

	/**
	 * JScroll Pane that displays column headers and creates JTable for Movies
	 * Table in DataBase
	 * 
	 * @throws SQLException
	 * @return
	 */
	private JScrollPane tableMovies() {
		modelMovies = new DefaultTableModel();
		modelMovies.addColumn("Movie ID");
		modelMovies.addColumn("Title");
		modelMovies.addColumn("Release Date");
		modelMovies.addColumn("Imdb Score");
		modelMovies.addColumn("Director");
		modelMovies.addColumn("Genre");
		modelMovies.addColumn("Rating");

		tableMovies = new JTable(modelMovies);
		tableMovies.setEnabled(false);

		paneMovies = new JScrollPane(tableMovies);
		return paneMovies;
	}
}
