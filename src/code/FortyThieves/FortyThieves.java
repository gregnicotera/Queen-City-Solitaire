package code.FortyThieves;

import java.util.ArrayList;
import java.util.Collections;

import code.Card;
import code.Deck;


/**
 * @author Greg
 *	This class represents an instance of the Forty Thieves game
 */
public class FortyThieves {
	private ArrayList<FTTableauPile> tableauList;
	private ArrayList<FTHomeCell> homeCellList;
	private FTStockPile stockPile;
	private FTWastePile wastePile;
	
	/** 
	 * Create a Forty Thieves Game which has 13 tableau piles, 8 homecell piles, 1 waste pile and 1 stock pile
	 */
	public FortyThieves() {
		
		Deck deck = new Deck(2);
	//homeCell initialization
		ArrayList<FTHomeCell> homeList = new ArrayList<>();
		for(int i=0;i<2;i++) {
			homeList.add(new FTHomeCell().AceOfClubs());
			homeList.add(new FTHomeCell().AceOfDiamond());
			homeList.add(new FTHomeCell().AceOfHeart());
			homeList.add(new FTHomeCell().AceOfSpades());
		}
		Collections.shuffle(homeList);
		this.homeCellList=homeList;
		
		//tabuleau intialization
		this.tableauList = new ArrayList<FTTableauPile>();
		deck.remove(14,"diamonds");deck.remove(14,"hearts");deck.remove(14,"clubs");deck.remove(14,"spades");
		deck.remove(14,"diamonds");deck.remove(14,"hearts");deck.remove(14,"clubs");deck.remove(14,"spades");
		
		for(int i=0;i<13;i++) {
			this.tableauList.add(new FTTableauPile());
		}
		
		
		for(int i=0;i<tableauList.size();i++) {
			tableauList.get(i).addTestCard(new Card(99,"basecard"));
			for(int x=0;x<3;x++) {
				tableauList.get(i).addTestCard(deck.get(0));
				deck.remove(0);
			}
		}

		//StockPile initialization
		this.stockPile = new FTStockPile();
		int decksize = deck.size();
		for(int i=0;i<decksize;i++) {
			stockPile.add(deck.get(0));
			deck.remove(0);
		}
		//wastePile
		this.wastePile = new FTWastePile();
		wastePile.addTestCard(new Card(99,"WastePile"));
	}
	
	/**
	 * @author Greg
	 * getter for the homecell
	 * @return homecell
	 */
	public ArrayList<FTHomeCell> getHomeCellList() {
		return this.homeCellList;
	}
	
	/**
	 * @author Greg
	 * getter for the list of tableau piles
	 * @return The arrayList of Tableau
	 */
	public ArrayList<FTTableauPile> getTableauPileList(){
		return this.tableauList;
	}
	
	/**
	 * @author Greg
	 * getter for the stockpile
	 * @return return stockPile
	 */
	public FTStockPile getStockPile() {
		return this.stockPile;
	}
public FTWastePile getWatePile() {
	return this.wastePile;
}
	
	
}
