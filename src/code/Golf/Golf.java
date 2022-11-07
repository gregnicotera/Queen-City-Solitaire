package code.Golf;

import java.util.ArrayList;

import code.Card;
import code.Deck;


/**
 * @author Greg
 *	This class represents an instance of the Golf game
 */
public class Golf {
	private ArrayList<GLFTableauPiles> TableauList;
	private GLFHomeCell homeCell;
	private GLFStockPile stockPile;
	
	/** 
	 * Create a Golf Game which has 7 TableauPiles in an ArrayList<GLFTableauPiles> 1 GLFHomeCell and 1 GLFStockPile
	 */
	public Golf() {
		ArrayList<GLFTableauPiles> list = new ArrayList<>();
		Deck deck = new Deck();
		
		for(int i=0;i<7;i++) {
			list.add(new GLFTableauPiles());
		}
		
		for(int i=0;i<7;i++) {
			list.get(i).addTestCard(new Card(99,"gold"));
			for(int x=0;x<5;x++) {	
			list.get(i).addTestCard((deck.get(0)));
			deck.remove(0);
			}
		}
		
		
		this.homeCell = new GLFHomeCell();
		this.stockPile = new GLFStockPile();
	
	stockPile.add(new Card(44,"gold"));
		while(deck.size()!=0) {
			this.stockPile.add(deck.get(0));
			deck.remove(0);
		}
		//System.out.println(stockPile.size());
		
		this.TableauList = list;
	}
	
	/**
	 * @author Greg
	 * getter for the homecell
	 * @return homecell
	 */
	public GLFHomeCell getHomeCell() {
		return this.homeCell;
	}
	
	/**
	 * @author Greg
	 * getter for the list of tableau piles
	 * @return The arrayList of Tableau
	 */
	public ArrayList<GLFTableauPiles> getTableauList(){
		return this.TableauList;
	}
	
	/**
	 * @author Greg
	 * getter for the stockpile
	 * @return return stockPile
	 */
	public GLFStockPile getStockPile() {
		return this.stockPile;
	}
	
	
}
