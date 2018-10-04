/********************************************************
 *
 * Project : A02 MovieDataBase
 * File : SearchParamater.java
 * Name : Emily Williams Jeremy Jacobson
 * Date : 1 October 2018
 *
 * Description : (Narrative desciption, not code)
 *
 * 1) What is the purpose of the code; what problem does the code solve.
 * does multiple if statements in order to determine what the Assosiation Table will show each if statement as 
 * a different sql command
 *
 * 2) What data-structures are used.
 * JCheckBox, JCombo box
 * 
 *
 * 3) What algorithms, techniques, etc. are used in implementing the data structures.
 * The purpose of this class is for encapsulation and putting objects into functions for searching
 * 
 * Changes : <Description|date of modifications>
 *
 ********************************************************/
package movies;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class SearchParamaters {
	public JComboBox<Object> Actor;
	public JComboBox<Object> Genre;
	public JComboBox<Object> ImdbRating;
	public JCheckBox CheckBoxActor;
	public JCheckBox CheckBoxGenre;
	public JCheckBox CheckBoxImdbRank;

}
