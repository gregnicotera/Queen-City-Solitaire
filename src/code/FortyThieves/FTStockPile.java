package code.FortyThieves;

import java.util.ArrayList;

import code.Card;
import code.Golf.GLFPile;
import code.Golf.GLFStockPile;


public class FTStockPile extends FTPile {
	private String type;
	
	public FTStockPile() {
		super();

		this.type="StockPile";

		ArrayList<Card> list = new ArrayList<>();
	
		
		this.PileList=list;
	}
	/**
	 * @author lyndadillard
	 * This method will allow you to clear the pile list by
	 * assigning the Arraylist to a new Arraylist
	 * @returns new cleared Arraylist
	 */
	public FTStockPile clearAll() {
		ArrayList<Card> list = new ArrayList<Card>();
		this.PileList= list;
		return this;
	}

	
	/**
	 * @author lyndadillard
	 * This method will check if the StockPile is empty.
	 * If the StockPile is not empty then the top Card will be 
	 * removed from the pile list.
	 * @return true if size of StockPile is empty, else false with
	 * "StockPile is empty", else return true.
	 * 
	 */
	public boolean remove() {
		int topIndex = this.size()-1;
		if(this.size()==0) {
			System.out.println("StockPile is empty");
			return false;
		}else{ 
			this.PileList.remove(topIndex);
		}
		return true;
	}
	/**
	 * @author lyndadillard
	 * This method will check if the last last index 
	 * returns true and if not false
	 * @return true if last index if removed else false
	 */
	public boolean remove(int i) {
		// TODO Auto-generated method stub
		if( i== (this.PileList.size()-1)) { //only i = the last index return true else return false 
			this.PileList.remove(i);
			return true;
		}
		return false;
	}
	/**
	 * @author lyndadillard
	 * These methods are getter and setters
	 */
	public  String getType() {
		return this.type;
	}

	public int size() {
		return this.PileList.size() ;
	}
	/**
	 * @author lyndadillard
	 * This method gets the top card of the pile
	 * @return index of the top card
	 */
	public Card getTopCard() {
		int index = this.size()-1;
		return this.PileList.get(index);
	}
	public String toString() {
		return this.PileList.toString();
	}
	public void add(Card input) {
		this.PileList.add(input);
	}

	@Override
	public boolean addfrom(FTPile pile) {
		// TODO Auto-generated method stub
		//this.PileList.add(pile.removeTopCard());
		return false;
	}
	/**
	 * @author lyndadillard
	 * This method gets i from the pile list
	 * @return int i from pile list
	 */
	@Override
	public Card get(int i) {
		// TODO Auto-generated method stub
		return this.PileList.get(i);
	}
	
	@Override
	public Card removeTopCard() {
		// TODO Auto-generated method stub
		
		Card ret = this.PileList.remove(PileList.size()-1);
		return ret;
	}

}
