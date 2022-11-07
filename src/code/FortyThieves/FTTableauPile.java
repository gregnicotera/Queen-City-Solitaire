package code.FortyThieves;

import code.Card;
import code.Golf.GLFPile;

public class FTTableauPile extends FTPile {

	private String type ="FTTableauPile";
	
	
	
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
	public boolean addfrom(FTPile pile) {
		// TODO Auto-generated method stub
		if(this.PileList.size()<=1) {
			this.PileList.add(pile.removeTopCard());
			return true;
		}
		if(pile.getType()=="FTHomeCell") {
			return false;
		}
		Card outer = pile.getTopCard(); Card inner = PileList.get(PileList.size()-1);
		String outerSuit = outer.getSuit(); String innerSuit = inner.getSuit();
		int outerRank = outer.getRank();	int innerRank = inner.getRank();
		if(innerSuit.equals(outerSuit)&&innerRank-1==outerRank) {
			this.PileList.add(pile.removeTopCard());
			return true;
		}
		if(innerSuit.equals(outerSuit)) {
			if(outerRank==14&&innerRank==2) {
			this.PileList.add(pile.removeTopCard());
			return true;
			}
		}
		return false;
	}

	
}
