package code.FortyThieves;

import java.util.ArrayList;

import code.Card;
import code.Golf.GLFPile;
import code.LittleSpider.LSHomeCell;
import code.LittleSpider.LSPile;

public class FTHomeCell extends FTPile {
	private String type ="FTHomeCell";
	
	public FTHomeCell() {
		ArrayList<Card> homeCell = new ArrayList<>();
		this.PileList = homeCell;
	}

	/**
	 * @author lyndadillard
	 * @author Greg
	 * This creates a new homecell pile with 1 starting card
	 * @return homecell pile with an ace of diamonds
	 */
	public FTHomeCell AceOfDiamond() {
		Card card = new Card(14,"diamonds");
		this.PileList.add(card);
		return this;
	}

	/**
	 * @author lyndadillard
	 * @author Greg
	 * This creates a new homecell pile with 1 starting card
	 * @return homecell pile with an ace of hearts
	 */
	public FTHomeCell AceOfHeart() {
		Card card = new Card(14,"hearts");
		this.PileList.add(card);
		return this;
	}

	/**
	 * @author lyndadillard
	 * @author Greg
	 * This creates a new homecell pile with 1 starting card
	 * @return homecell pile with a king of clubs
	 */
	public FTHomeCell AceOfClubs() {
		Card card = new Card(14,"clubs");
		this.PileList.add(card);
		return this;
	}
	
	/**
	 * @author lyndadillard
	 * @author Greg
	 * This creates a new homecell pile with 1 starting card
	 * @return homecell pile with a king of spades
	 */
	public FTHomeCell AceOfSpades() {
		Card card = new Card(14,"spades");
		this.PileList.add(card);
		return this;
	}
	
	/**
	 * @author lyndadillard
	 * This method will allow you to clear the pile list by
	 * assigning the Arraylist to a new Arraylist
	 * @returns new cleared Arraylist
	 */
	public FTHomeCell clearAll() {
		ArrayList<Card> list= new ArrayList<>();
		this.PileList = list;
		return this;
	}
	
	/**
	 * @author lyndadillard
	 * Gets the size of the pile list
	 * @return the size of the pile
	 */
	public int size() {
		return this.PileList.size();
	}
	
	/**
	 * @author lyndadillard
	 * This method will allow you to get the pile list
	 *@return pile list of cards
	 */
	public ArrayList<Card> getCardList(){
		return this.PileList;
	}
	
	/**
	 * @author lyndadillard
	 * This method will allow you to add a card
	 * @param card the player would like to add
	 * @return pile list with one more card
	 */
	public void add(Card card) {
		this.PileList.add(card);
	}
	
	/**
	 * @author lyndadillard
	 * This method will allow you to remove a card
	 * @return pile list with one less card
	 */
	public Card removeTopCard() {
		// TODO Auto-generated method stub
				
		return  PileList.remove(PileList.size()-1);
	}
	
	/**
	 * @author lyndadillard
	 * This method will order the pilelist as a list
	 * @return pile list with as a list of strings
	 */
	public String toString() {
		String output = "";
		for(int i=0;i<this.PileList.size();i++) {
			output = output +this.PileList.get(i)+"\n";
		}	
	return output;
	}
	
	/**
	 * @author Greg
	 * This will get the top card for checking & moving purposes
	 * @return top card from the homecell pile
	 */
	@Override
	public Card getTopCard() {
		// TODO Auto-generated method stub
		
		return this.PileList.get(PileList.size()-1);
	}
	
	/**
	 * @author Greg
	 * This will remove a card
	 * @return true or false if it was able to remove
	 */
	@Override
	public boolean remove() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * @author Greg
	 * pile type getter
	 * @return type of pile
	 */
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}
	
	/**
	 * @author Greg
	 * will add a card from one pile to another
	 * @param pile Little Spider pile to add from
	 * @return true or false if it was successful
	 */
	public boolean addfrom(FTPile pile) {
		// TODO Auto-generated method stub
		Card outer = pile.getTopCard(); Card inner = PileList.get(PileList.size()-1);
		String outerSuit = outer.getSuit(); String innerSuit = inner.getSuit();
		int outerRank = outer.getRank();	int innerRank = inner.getRank();
		
		if(outerSuit==innerSuit&&outerRank==innerRank-1) {
		PileList.add(pile.removeTopCard());	
			return true;
		}
		if(outerSuit.equals(innerSuit)&&outerRank==2) {
			PileList.add(pile.removeTopCard());	
			return true;
		}
	
		
		return false;
	}
	
	/**
	 * @author Greg
	 * @param i index to get the card from
	 * @return Card at indicated instance
	 */
	@Override
	public Card get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @author Greg
	 * @param card new card instance to add to the pile
	 */
	public void addAt(int input,Card card) {
		PileList.add(input, card);
	}
	
	public void addTestCard(Card card) {
		this.PileList.add(card);
	}

}
