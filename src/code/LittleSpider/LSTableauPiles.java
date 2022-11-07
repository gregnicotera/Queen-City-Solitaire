package code.LittleSpider;

import java.util.ArrayList;

import code.Card;
import code.Golf.GLFPile;

/**
 * @author xuanhuaz
 * @author Greg
 *	This class is a tableau pile in the Little Spider Game
 */
public class LSTableauPiles extends LSPile {
	/**
	 * @author Greg
	 * Constructor creats 6 tableau piles 
	 */
	public LSTableauPiles () {
		ArrayList<Card> cards = new ArrayList<>();
		for(int i=0;i<6;i++) {
			cards.add(new Card().random());
		}
		this.PileList = cards;
	}
	
	/**
	 * @author lyndadillard
	 * This method will allow you to clear the pile list by
	 * assigning the Arraylist to a new Arraylist
	 * @returns new cleared Arraylist
	 */
	public LSTableauPiles clearAll() {
		ArrayList<Card> list = new ArrayList<>();
		this.PileList=list;
		return this;
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
	 * @author lyndadillard
	 * This method will allow you to add a card
	 * @param card the player would like to add
	 * @return pile list with added card
	 */
	public void addTestCard(Card card) {
		this.PileList.add(card);
	}
	
	/**
	 * @author Greg
	 * Gets the size of the pile list
	 * @return the size of the pile
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
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
		return null;
	}
	
	/**
	 * @author Greg
	 * will add a card from one pile to another
	 * @param pile Little Spider pile to add from
	 * @return true or false if it was successful
	 */
	@Override
	public boolean addfrom(LSPile pile) {
		// TODO Auto-generated method stub
	
		if(pile.size()==2 &&pile.getType()=="LSHomeCell") {
			return false;
		}
		
		if(PileList.size()<=7) {
			this.PileList.add(pile.removeTopCard());
			return true;
		}
		
		int TableauTopSuit;
		int fromSuit = pile.getTopCard().getRank();
		TableauTopSuit = PileList.get(PileList.size()-1).getRank();
		 if(fromSuit ==  TableauTopSuit-1||fromSuit == TableauTopSuit+1) {
			
			this.PileList.add(pile.removeTopCard());
			return true;
		 }
		
		 if(TableauTopSuit== 14 && (fromSuit ==2 || fromSuit ==13)) {
				this.PileList.add(pile.removeTopCard());
				return true;
			}
		 
		if(fromSuit == 14 && (TableauTopSuit == 2||TableauTopSuit ==13)) {
			this.PileList.add(pile.removeTopCard());
			return true;
		}else {
			return false;
		}
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

	@Override
	public Card removeTopCard() {
		// TODO Auto-generated method stub
		return  PileList.remove(PileList.size()-1);
	}
}
