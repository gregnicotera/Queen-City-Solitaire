package code.LittleSpider;

import java.util.ArrayList;

import code.Card;
import code.Deck;

/**
 * @author xuanhuaz
 * @author Greg
 * This class represents an instance of our Little Spider game
 * LittleSpider has 8 tableau piles and 4 homecell piles
 */
public class LittleSpider {
	private ArrayList<LSTableauPiles>TableauList;
	private LSHomeCell homeCell1;LSHomeCell homeCell2;LSHomeCell homeCell3;LSHomeCell homeCell4;
	
	/**
	 * @author xuanhuaz
	 * This constructor will initialize the LittleSpider game with:
	 * eight identical tableau piles and 
	 * four different homecell piles
	 * 1 - starting with ace of diamonds
	 * 2 - starting with ace of heards
	 * 3 - startig with king of clubs
	 * 4 - starting with king of spades
	 */
	public LittleSpider() {
		ArrayList<LSTableauPiles> list = new ArrayList<>();
		Deck deck = new Deck();
		deck.remove(14,"diamonds");
		deck.remove(14,"hearts");
		deck.remove(13,"clubs");
		deck.remove(13,"spades");
		System.out.println(deck.size());
		for(int i=0;i<8;i++) {
			list.add(new LSTableauPiles());
		}
		
		this.TableauList=list;
		this.homeCell1= new LSHomeCell().AceOfDiamond();homeCell1.addAt(0, new Card(100,"gold"));
		this.homeCell2= new LSHomeCell().AceOfHeart();homeCell2.addAt(0, new Card(100,"gold"));
		this.homeCell3= new LSHomeCell().kingOfClubs();homeCell3.addAt(0, new Card(100,"gold"));
		this.homeCell4= new LSHomeCell().kingOfSpades();homeCell4.addAt(0, new Card(100,"gold"));
		
		
		for(int i=0;i<8;i++) {
			list.get(i).addTestCard(new Card(99,"gold"));
			for(int x=0;x<6;x++) {
				list.get(i).addTestCard(deck.get(0));
				deck.remove(0);
			}
		}
		
		
	}
	
	/**
	 * @author Greg
	 * getter for this instance of TableauList
	 * @return this instance of TableauList
	 */
	public ArrayList<LSTableauPiles> getTableauList(){
		return this.TableauList;
	}
	/**
	 * @author lyndadillard
	 * This method will allow you to add a card
	 * @param card the player would like to add
	 * @param TableauNumber pile number its being removed from
	 */
	/**
	 * 
	 * This will remove a card from a tableau list
	 * @param card specific card you want to remove
	 * @param TableauNumber pile number its being removed from 
	 */
	public void removeCard(Card card,int TableauNumber) {
		this.TableauList.get(TableauNumber);
	}
	
	
	
	
	/**
	 * 
	 * Can we do this with 1 method w/ parameter indicated which pile?
	 * 
	 * homecell1 getter
	 * @return homeCell1
	 */
	public LSHomeCell getHomeCell1() {
		return this.homeCell1;
	}
	/**
	 * homecell2 getter
	 * @return homeCell2
	 */
	public LSHomeCell getHomeCell2() {
		return this.homeCell2;
	}
	/**
	 * homecell3 getter
	 * @return homeCell3
	 */
	public LSHomeCell getHomeCell3() {
		return this.homeCell3;
	}
	/**
	 * homecell4 getter
	 * @return homeCell4
	 */
	public LSHomeCell getHomeCell4() {
		return this.homeCell4;
	}
	
	/**
	 * @author lyndadillard
	 * These methods will allow the player to add to the 
	 * homecell pile.
	 * @param card the player would like to add
	 */
	public void addCardtoHomeCell1(Card card) {
		this.homeCell1.add(card);
	}
	public void addCardtoHomeCell2(Card card) {
		this.homeCell2.add(card);
	}
	public void addCardtoHomeCell3(Card card) {
		this.homeCell3.add(card);
	}
	public void addCardtoHomeCell4(Card card) {
		this.homeCell4.add(card);
	}
	/**
	 * @author lyndadillard
	 * These methods will allow the player to  remove from the 
	 * homecell pile.
	 * @param card the player wants to remove
	 */
	public void removeTopCardHomeCell1() {
		this.homeCell1.removeTopCard();
	}
	public void removeTopCardHomeCell2() {
		this.homeCell2.removeTopCard();
	}
	public void removeTopCardHomeCell3() {
		this.homeCell3.removeTopCard();
	}
	public void removeTopCardHomeCell4() {
		this.homeCell4.removeTopCard();
	}
	
	
	/**
	 * @author lyndadillard
	 * This method will allow the player to move
	 * piles onto other piles
	 * @param the stationary pile
	 * @param the pile which is being moved
	 */

}
