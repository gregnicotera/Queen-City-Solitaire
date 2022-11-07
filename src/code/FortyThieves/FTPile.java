package code.FortyThieves;

import java.util.ArrayList;

import code.Card;
import code.Golf.GLFPile;

public abstract class FTPile {

	String type;
	 /**
		 * Create an ArrayList instance with Card type to get cards' rank and suit easier.
		 */
		ArrayList<Card> PileList;
		public FTPile() {
			PileList = new ArrayList<Card>();
		}
		
	public abstract int size() ;
	public abstract Card getTopCard();
	public abstract  boolean remove();
	public abstract  String getType() ;
	public abstract boolean addfrom(FTPile original);
	public abstract Card get(int i);
	public abstract Card removeTopCard();
		
	public boolean remove(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
