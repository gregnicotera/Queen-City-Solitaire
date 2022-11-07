package code.Golf;

import java.util.ArrayList;

import code.Card;

/**
 * @author Greg
 *	This class represents a homecell pile in the Golf game.
 *	It will take methods from its abstract superclass GLFPile
 */
public class GLFHomeCell extends GLFPile   {


	/**
	 * @author lyndadillard
	 * Assigns ArrayList of type card to a new ArrayList
	 * 
	 * @author Greg
	 * Creates a new homecell pile
	 */
	public GLFHomeCell() {
		this.type= "HomeCell";
		ArrayList<Card> homeCell = new ArrayList<>();
		this.PileList = homeCell;
	}
	
	/**
	 * @author lyndadillard
	 * @author Greg
	 * simple getter
	 * @return the size of the current pile instance
	 */
	public int size() {
		return this.PileList.size();
	} 
	
	/**
	 * @author Greg
	 * getter for list of cards in the current homecell
	 * @return ArrayList<Card> this is a list of the cards in the current instance of a homecell pile
	 */
	public ArrayList<Card> getCardList(){
		return this.PileList;
	}
	
	/**
	 * @author Greg
	 * getter for tpye of pile
	 * @return type String containing type of pile(homecell, tableau, or stock)
	 */
	public  String getType() {
		return this.type;
	}
	
	/**
	 * @author Greg
	 * getter for test card for unit tests
	 * @param card to specify new Card instance of suit and rank desired for testing
	 */
	public void addTestCard(Card card) {
		this.PileList.add(card);
	}
	
	/**
	 * This method will check which type of GLFPile is the parameter 1st. Then use the specified method "addFromTableauPiles()" and "addFromStock()" to check if it's legal to add the card. 
	 */
	/**
	 * @author lyndadillard
	 * @author Greg
	 * This method allows the user to add from one pile to another.
	 * Depending on what time the pile passed in is, we will add from that pile.
	 * @param pile passing in the pile that the card is coming from
	 * @return pile added from stock pile, else pile added from 
	 * tableau pile, else return false if invalid type 
	 */
	public boolean addfrom(GLFPile pile) {
		if(pile.getType()=="StockPile") {
			this.PileList.add(pile.removeTopCard());
			return true;
		}
		
		if(pile.getType()=="TableauPiles") {
			int fromSuit = pile.getTopCard().getRank();
			int HomeTopSuit;
		if(this.PileList.size()==0){
			this.PileList.add(pile.removeTopCard());
			return true;
		}
	
			
			
			if(this.PileList.size()!=0) {
		
				
				HomeTopSuit = PileList.get(PileList.size()-1).getRank();
				 if(fromSuit ==  HomeTopSuit-1||fromSuit == HomeTopSuit+1) {
					
					this.PileList.add(pile.removeTopCard());
					return true;
				 }
				
			 if(HomeTopSuit== 14 && (fromSuit ==2 || fromSuit ==13)) {
					this.PileList.add(pile.removeTopCard());
					return true;
				}
			 
			if(fromSuit == 14 && (HomeTopSuit == 2||HomeTopSuit ==13)) {
				this.PileList.add(pile.removeTopCard());
				return true;
			}else {
				return false;
			}
			
			}
		}
		
		
		return false;
	}

	/**
	 * This method will check if it's legal to remove the top card of TableauPiles onto homecell.
	 * the rank of the top card of TableauPiles should be one more or less than the ranked of the top card of the homecell 
	 * @param pile--TableauPiles
	 * @return true if the top card of TableauPiles is legal to remove onto homecell, otherwise return false and print out that "error at GLFHomeCell addFromTableauPiles(GLFTableauPiles tab)". 
	 */
	/**
	 * @author lyndadillard
	 * @author Greg
	 * @param pile name of the pill to take from
	 * @return ture or false depending on 
	 */
	public boolean addFromTableauPiles(GLFPile pile) {
		int inputRank = pile.getTopCard().getRank();

		int homeTopRank = this.getTopCard().getRank();

		if((inputRank == (homeTopRank+1)) || (inputRank == (homeTopRank-1))) {

			this.PileList.add(pile.getTopCard()) ;

			return true;

		}
		System.out.println("error at GLFHomeCell addFromTableauPiles(GLFTableauPiles tab)");
		return false;
	}


	/**
	 * This method will allow us to remove the top card of StockPile onto a homecell directly.
	 * @param stock -- StockPile
	 * @return true
=======
	
	/**
	 * @author lyndadillard
	 * This method allows the user to add a card from the stock pile
	 * @return true if card is added from the stock pile
>>>>>>> branch 'master' of https://github.com/CSE116-Fall2018/f18semesterproject-a3-penta_esport.git
	 */
	public boolean addFromStock(GLFPile stock) {
		this.PileList.add(stock.getTopCard());
		return true;
	}
	
	/**
	 * @author lyndadillard
	 * This method removes i from the pile list
	 * @param i index to remove from the pile
	 * @return false after removing i
	 */
	@Override
	public boolean remove(int i) {
		//System.out.println("GLFHomeCell cannot remove after initialization");
		this.PileList.remove(i);
		return false;
	}
	
	/**
	 *Offered a easier way to access top card of a pile. 	
	 */
	/**
	 * @author lyndadillard
	 * This method will allow you get the top card 
	 * @return top card of pile
	 */
	public Card getTopCard() {
		int topIndex = this.size()-1;
		return this.PileList.get(topIndex);
	}
	/**
	 * @author lyndadillard
	 * This method will order the pile list as a list
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
	 * These methods are getter and setters
	 */
	@Override
	public boolean remove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Card get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card removeTopCard() {
		// TODO Auto-generated method stub
		Card ret = this.PileList.remove(PileList.size()-1);
		return ret;
	}

	
}
