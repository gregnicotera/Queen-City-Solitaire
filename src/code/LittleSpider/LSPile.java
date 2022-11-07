package code.LittleSpider;

import java.util.ArrayList;

import code.Card;

/**
 * @author xuanhuaz
 * LSPile is the super abstract class for all piles in littlespider game
 * (HomeCell, TableauPiles) all extends LSPile
 * 
 */
public abstract class LSPile {
	String type;
	ArrayList<Card> PileList;

	
	public LSPile() {
		
	}
	public abstract void addTestCard(Card card);
	public abstract int size() ;
	public abstract Card getTopCard();
	public abstract  boolean remove();
	public abstract  String getType() ;
	public abstract boolean addfrom(LSPile pile);
	public abstract Card get(int i);
	public abstract Card removeTopCard();
	public boolean remove(int i) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
