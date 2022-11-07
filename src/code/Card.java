package code;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;


/**
 * @author xuanhuaz
 * @author Greg
 * This class represents an instance of Card with several instance variables:
 * Integer of rank from 1-A ex: J=11,Q=12,K=13,A=14 
 * String of Suit either "club" "diamonds" "hearts", or "spades"
 * boolean of faceUp to determine if card is facing up or down
 */
public class Card {
	private Integer rank= null;
	private String suit = null ;
	private boolean faceUp = true;
	private String url;
	/**
	 * @author Greg
	 * This constructor will create a Card instance will null values
	 */
	public Card() {
		this.url =
				this.getClass().getResource("").toString().replace("file:", "").replace("/bin", "/src");
		
				
	}
	/**
	 * @author xuanhuaz
	 * @param rank
	 * @param suit
	 * This constructor will create a Card instance with (int rank :  String suit); Creator can put any int for rank and any String for suit; 
	 * It allows you to create test card like (99 : "test" ) for testing purpose. However, you should be extra careful about the suit
	 * and rank because in solitare the rank only from (1-14) and there are only "club" "diamonds" "hearts" "spades" for suit;
	 */
	public Card(int rank, String suit) {
		this.rank= rank;
		this.suit = suit;
		this.url = this.getClass().getResource("").toString().replace("file:", "").replace("/bin", "/src");

	}
	
	
	/**@author xuanhuaz
	 * @author Greg
	 * @return current instance of random card
	 * The random() return a Random Card; Card.random();
	 */
	public Card random() {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<String> suitList = new ArrayList<>();
		suitList.add("clubs");
		suitList.add("diamonds");
		suitList.add("hearts");
		suitList.add("spades");
		Collections.shuffle(suitList);
		for(int i=0;i<14;i++) {
			list.add(i);
			Collections.shuffle(list);
		}
		this.rank = list.get(1);
		this.suit = suitList.get(1);
		return this;
	}
	
	/**
	 * @author Greg
	 * rank getter
	 * @return rank type of int
	 */
	public Integer getRank() {
		return this.rank;
	}
	
	/**
	 * @author Greg
	 * suit getter
	 * @return suit type of String
	 */
	public String getSuit() {
		return this.suit;
	}
	
	/**
	 * @author Greg
	 * getter for if the card is face up or not
	 * @param tureOrFalse true is face up and false is face down
	 */
	public void setFaceUp(boolean tureOrFalse ) {
		this.faceUp = tureOrFalse;
	}
	
	public String getUrl() {
		if(this.rank ==99) {
			return (this.url+"gold"+".gif").toString();
		}
		if(this.rank ==100) {
			return (this.url+"home"+".gif").toString();
		}
		
		if(this.rank == 14) {
			
			return (this.url+"a"+this.suit.toLowerCase().charAt(0)+".gif").toString();
		}else if(this.rank == 11) {
			return (this.url+"j"+this.suit.toLowerCase().charAt(0)+".gif").toString();
		}else if(this.rank == 12) {
			return (this.url+"q"+this.suit.toLowerCase().charAt(0)+".gif").toString();
	}else if(this.rank == 13) {
		return (this.url+"k"+this.suit.toLowerCase().charAt(0)+".gif").toString();		
	}else {
		 return this.url.toString()+ this.rank+this.suit.toLowerCase().charAt(0)+".gif";
	}
		
	}
	public ImageIcon getImageIcon() {
		
		ImageIcon image = new ImageIcon(this.getUrl());	
		return image;
	}
	/**
	 * @author Greg
	 * String getter for rank & suit
	 * @return String w/ rank & suit w/ labels
	 */
	public String toString() {
		return "rank : "+ this.rank +" suit : "+ this.suit;
	}
}
