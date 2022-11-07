package code;

import java.util.ArrayList;
import java.util.Collections;
	/**
	 * @author xuanhuaz
	 * Deck class will construct deck for games
	 * 
	 * Parameter-less constructor will create in total 52 Cards and each have its unique rank and suit
	 * 
	 * Constructor with parameter will create a deck with as many decks of 52 as needed
	 */
public class Deck {
	private ArrayList<Card> stockPile;
	
	public Deck() {
		ArrayList<Card> list = new ArrayList<>();
		for(int i=2;i<15;i++) {
			list.add(new Card (i,"clubs"));
			list.add(new Card (i,"diamonds"));
			list.add(new Card (i,"hearts"));
			list.add(new Card (i,"spades"));
			this.stockPile = list;
			Shuffling();
			Shuffling();
			Shuffling();
			Shuffling();
		}
	}
	
	/**
	 * @param decks number of decks needed, each one has 52 cards
	 */
	public Deck(Integer decks) {
		ArrayList<Card> list = new ArrayList<>();
		for(int j=0;j<decks;j++) {
			for(int i=2;i<15;i++) {
				list.add(new Card (i,"clubs"));
				list.add(new Card (i,"diamonds"));
				list.add(new Card (i,"hearts"));
				list.add(new Card (i,"spades"));
				this.stockPile = list;
				Shuffling();
				Shuffling();
				Shuffling();
				Shuffling();
			}
		}
	}
	
	/**
	 * This will shuffle a pile instance
	 */
	public void Shuffling() {
	Collections.shuffle(stockPile);	
	}
	/**
	 * this will remove a card from the current deck instance
	 */
	public Card get(int i) {
		return this.stockPile.get(i);
	}
	public void remove(int i) {
		this.stockPile.remove(i);
	}
	
	public int size() {
		return this.stockPile.size();
	}
	public void remove(int rank, String suit) {
		for(int i=0;i<this.stockPile.size();i++) {
			if(this.stockPile.get(i).getRank().equals(rank)&&stockPile.get(i).getSuit().equals(suit) ){
				stockPile.remove(i);
			}
		}
		
	}
	public String toString() {
		String output="";
		for(int i=0;i<this.stockPile.size();i++) {
			output= output + this.stockPile.get(i).toString()+"\n";
		}
		return output ;
	}
	
}
