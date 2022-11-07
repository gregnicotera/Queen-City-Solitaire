package code.Golf;

import java.util.ArrayList;

import code.Card;

public abstract class GLFPile {
	/**
	 * Later in its subclasses will use this String instance to define the type of that pile.
	  * Ex. StockPile, HomeCell, TableauPiles 
	 */
 String type;
 /**
	 * Create an ArrayList instance with Card type to get cards' rank and suit easier.
	 */
	ArrayList<Card> PileList;

/**@author xuanhuaz
 * GLFPile is the super abstract class for all piles in golf game
 * (HomeCell, StockPile, TableauPiles) all extends GLFPile
 * 
 */
public GLFPile() {
	
}
	public abstract int size() ;
	public abstract Card getTopCard();
	public abstract  boolean remove();
	public abstract  String getType() ;
	public abstract boolean addfrom(GLFPile pile);
	public abstract Card get(int i);
	public abstract Card removeTopCard();
		
	public boolean remove(int i) {
		// TODO Auto-generated method stub
		return false;
	}

}
