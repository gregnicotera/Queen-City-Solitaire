package code.Golf;

import java.util.ArrayList;

import code.Card;

/**
 * @author Greg
 *	The class represents a tableau pile in the Golf game
 */
public class GLFTableauPiles extends GLFPile  {

private boolean initialization;

/**
 * @author Greg
 * constructor to create a new tableau pile with default instance variables
 */
public GLFTableauPiles () {
	ArrayList<Card> cards = new ArrayList<>();
	this.type="TableauPiles";
	this.PileList=cards;
	this.initialization=true;


}

/**
 * @author lyndadillard
 * This method will add 5 random cards to the tableau pile
 * @return this instance of tableau pile with 5 random cards
 */
public GLFTableauPiles addRandom5() {
	this.PileList.add(new Card().random());
	this.PileList.add(new Card().random());
	this.PileList.add(new Card().random());
	this.PileList.add(new Card().random());
	this.PileList.add(new Card().random());

	return this;
}

/**
 * @author lyndadillard
 * This method will allow you to add a card
 * @param card the player would like to add
 * @return pile list with one more card
 */
public void addTestCard(Card card) {
	this.PileList.add(card);
}

/**
 * @author lyndadillard
 * @author Greg
 * This method will return the pile type
 * @return type this instances pile type
 */
public String getType() {
	return this.type;
}

/**
 * @author lyndadillard
 * This method will allow you get the pile list size
 * @return pile list size
 */
public int size() {
	return this.PileList.size();
}

/**
 * @author lyndadillard
 * This method will allow you get the top card 
 * @return top card of pile
 */
public Card getTopCard() {
	System.out.println(this.PileList.size()-1);
	return this.PileList.get(PileList.size()-1);
}

/**
 * @author lyndadillard
 * This method gets i from the pile list
 * @param i inde of card to get
 * @return int i from pile list
 */
public Card get(int i) {
	return this.PileList.get(i);
}

/**
 * @author lyndadillard
 * This method will allow a card to be added to the pilelist
 * if this.initialization equals false
 * @param card being added to pile
 * @return true if the card is added else false
 */
public boolean add(Card input) {
		this.PileList.add(input);
		return false;
	}
	
	


/**
 * @author lyndadillard
 * This method will order the pilelist as a list
 * @return pile list as a list of strings
 */
public String toString() {
	String output = "";
	for(int i=0;i<this.PileList.size();i++) {
		output = output +this.PileList.get(i)+"\n";
	}
	return output;
}
/**
 * @author lyndadillard
 * This method will check if the last last index 
 * returns true and if not false
 * @param i index of card to remove
 * @return true if last index if removed else false
 */
@Override
public boolean remove(int i) {   
	// TODO Auto-generated method stub
	if( i== (this.PileList.size()-1)) {  
		this.PileList.remove(i);
		return true;
	}
	return false;
}
@Override
public boolean remove() {
	// TODO Auto-generated method stub
	return false;
}
public Card removeTopCard() {
	
	Card ret = this.PileList.remove(PileList.size()-1);
	
	return ret;
}
@Override
public boolean addfrom(GLFPile pile) {
	// TODO Auto-generated method stub
	//this.PileList.add(pile.removeTopCard());
	
	return false;
}



}
