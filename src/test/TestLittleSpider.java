package test;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import code.Card;
import code.LittleSpider.LSHomeCell;
import code.LittleSpider.LSTableauPiles;
import code.LittleSpider.LittleSpider;
/**
 * Defines class representing a Little Spider game. Each game instance has 8 tableau piles, 4 homecell piles, and 0 stock piles [4 points]
 * Tableau piles in Little Spider initially hold 6 cards [4 points]
 * Little Spider tableau pile correctly determines if adding a specific card is legal or illegal [4 points]
 * Little Spider tableau pile correctly returns if removing top card is legal or illegal (e.g., if the tableau pile is NOT empty) [4 points]
 * Adding card to Little Spider's tableau pile increases its number of cards and results in that card being the tableau pile's new top card [4 points]
 * Removing card from Little Spider's tableau pile decreases its number of cards and results in following card being the new top card [4 points]
 */
public class TestLittleSpider {
	
	@Test
	public void TestTableauPilesInitial() {
		//check Tableau Number and size;
		LittleSpider littleSpider = new LittleSpider();
		assertEquals("LittleSpider should have 8 TableauPiles",8,littleSpider.getTableauList().size());
		int PileSize = littleSpider.getTableauList().get(1).size();
		assertEquals("In LittleSpider game!! Each TableauPiles should hold 6 cards",0,PileSize);
		
	}
	
	
	@Test public void TestTableauAddcorrectly() {
		//TestTableau cannot being add any card after initialization
		//adding test

		LSTableauPiles testTab = new LSTableauPiles();
		LSTableauPiles testTabQueen = new LSTableauPiles();
		LSHomeCell testHomeAce  = new LSHomeCell();
		
	
		
		Card Queen = new Card (12,"spades");
		Card Ace = new Card(14,"diamonds");
	
		testTabQueen.addTestCard(Queen);
		testTabQueen.addTestCard(Queen);
		testTabQueen.addTestCard(Queen);
		testTabQueen.addTestCard(Queen);
		testHomeAce.addTestCard(Ace);
		
		//assertEquals("should be successfully added",false,testTab.addfrom(testTabQueen));
		
	
	}
	
	@Test public void TestTableauAddNOTcorrectly() {
		LSTableauPiles testTab = new LSTableauPiles().clearAll();
		LSTableauPiles testTabten = new LSTableauPiles().clearAll();
		
		Card testcardKing = new Card(13,"diamonds");
		Card ten = new Card (10,"spades");
		testTab.addTestCard(testcardKing);
		testTabten.addTestCard(ten);
		
	assertEquals("When add incorrecrtly the size should remain unchanged",0,testTab.size());
		
	}

	
	@Test public void TestTableauRemovecorrectly() {
		//TestTableau cannot being add any card after initialization
		//remove test
	
		LSTableauPiles testTab = new LSTableauPiles();	
		
				assertEquals("after removing each TableauPiles should hold 5 cards",0,testTab.size());
	}
	
	@Test public void TestTableauRemoveNotCorrectly() {
		//TestTableau cannot being add any card after initialization
		LSTableauPiles testTab = new LSTableauPiles().clearAll();
		assertEquals("Card cannot being removed from empty pile",false,testTab.remove());
		
	}

	
	
	/**
	 * Homecell piles in Little Spider initially hold 1 card [4 points]
	 * Little Spider homecell piles correctly determines if adding a specific card is legal or illegal [4 points]
	 * Little Spider homecell pile correctly returns if removing top card is legal or illegal (e.g., if the homecell pile has 2 or more cards) [4 points]
	 * Adding card to Little Spider's homecell pile increases its number of cards and results in that card being the homecell pile's new top card [4 points]
	 * Removing card from Little Spider's tableau pile decreases its number of cards and results in following card being the new top card [4 points]
	 */
	@Test
	public void TestHomecellPileInitial() {
		//initial set up
		LittleSpider littleSpider = new LittleSpider();
		assertEquals("Initially first homecell size should be 1 ",2,littleSpider.getHomeCell1().size());
		assertEquals("Initially second homecell size should be 2 ",2,littleSpider.getHomeCell2().size());
		assertEquals("Initially third homecell size should be 3 ",2,littleSpider.getHomeCell3().size());
		assertEquals("Initially fourth homecell size should be 4 ",2,littleSpider.getHomeCell4().size());
		
		//adding test
		Card testC = new Card(99,"test");
		Card initial = littleSpider.getHomeCell1().getCardList().get(0);//memerize the initial
		
		littleSpider.addCardtoHomeCell1(testC);
		int size = littleSpider.getHomeCell1().size();
		assertEquals("the after adding homcell size for LittleSpider should be 1",3,size);
		Card topCard =littleSpider.getHomeCell1().getCardList().get(size-1) ;
		assertEquals("The top should be the test card",testC,topCard);//check top
		//removing test1
		
		littleSpider.removeTopCardHomeCell1();
		size = littleSpider.getHomeCell1().size();
		assertEquals("size after remove shoud = 1",2,size);
		assertEquals("Removing card from Little Spider's tableau pile decreases its number of cards",initial,littleSpider.getHomeCell1().getCardList().get(0));
	}
	
	
	
	@Test
	public void TestHomecellPileAddCorrectly() {

		LSHomeCell AceOfDiamond= new LSHomeCell().AceOfDiamond();
		LSHomeCell AceOfHeart= new LSHomeCell().AceOfHeart();
		
		LSHomeCell kingOfClubs= new LSHomeCell().kingOfClubs();
		LSHomeCell kingOfSpades= new LSHomeCell().kingOfSpades();
		
		LSTableauPiles tab = new LSTableauPiles();
		tab.addTestCard(new Card (2,"diamonds"));
		assertEquals("",true,AceOfDiamond.addfrom(tab));
		assertEquals("size after remove shoud = 2",2,AceOfDiamond.size());
		tab.clearAll();
		//---------------------------------------------
		tab.addTestCard(new Card (2,"hearts"));
		assertEquals("",true,AceOfHeart.addfrom(tab));
		assertEquals("size after remove shoud = 2",2,AceOfHeart.size());
		tab.clearAll();
		//---------------------------------------------
		tab.addTestCard(new Card (12,"clubs"));
		assertEquals("",true,kingOfClubs.addfrom(tab));
		assertEquals("size after remove shoud = 2",2,kingOfClubs.size());

		tab.clearAll();
		//---------------------------------------------
		tab.addTestCard(new Card (12,"spades"));
		assertEquals("",true,kingOfSpades.addfrom(tab));
		assertEquals("size after remove shoud = 2",2,kingOfSpades.size());
		tab.clearAll();
	}
	
	@Test
	public void TestHomecellPileAddNotCorrectly() {

		LSHomeCell AceOfDiamond= new LSHomeCell().AceOfDiamond();
		LSHomeCell AceOfHeart= new LSHomeCell().AceOfHeart();
		
		LSHomeCell kingOfClubs= new LSHomeCell().kingOfClubs();
		LSHomeCell kingOfSpades= new LSHomeCell().kingOfSpades();
		
		LSTableauPiles tab = new LSTableauPiles();
		// Correct rank but incorrect suit
		tab.addTestCard(new Card (2,"hearts"));
		assertEquals("",false,AceOfDiamond.addfrom(tab));
		assertEquals("size after adding incorrectly should be unchanged ",1,AceOfDiamond.size());
		tab.clearAll();
		//---------------------------------------------
		tab.addTestCard(new Card (2,"diamonds"));
		assertEquals("",false,AceOfHeart.addfrom(tab));
		assertEquals("size after adding incorrectly should be unchanged ",1,AceOfHeart.size());
		tab.clearAll();
		//---------------------------------------------
		tab.addTestCard(new Card (12,"spades"));
		assertEquals("",false,kingOfClubs.addfrom(tab));
		assertEquals("size after adding incorrectly should be unchanged ",1,kingOfClubs.size());

		tab.clearAll();
		//---------------------------------------------
		tab.addTestCard(new Card (12,"clubs"));
		assertEquals("",false,kingOfSpades.addfrom(tab));
		assertEquals("size after adding incorrectly should be unchanged ",1,kingOfSpades.size());
		tab.clearAll();
		
		
		//incorrect rank but correct suit
		tab.addTestCard(new Card (3,"diamonds"));
		assertEquals("",false,AceOfDiamond.addfrom(tab));
		assertEquals("size after adding incorrectly should be unchanged ",1,AceOfDiamond.size());
		tab.clearAll();
		//---------------------------------------------
		tab.addTestCard(new Card (5,"hearts"));
		assertEquals("",false,AceOfHeart.addfrom(tab));
		assertEquals("size after adding incorrectly should be unchanged ",1,AceOfHeart.size());
		tab.clearAll();
		//---------------------------------------------
		tab.addTestCard(new Card (5,"clubs"));
		assertEquals("",false,kingOfClubs.addfrom(tab));
		assertEquals("size after adding incorrectly should be unchanged ",1,kingOfClubs.size());

		tab.clearAll();
		//---------------------------------------------
		tab.addTestCard(new Card (8,"spades"));
		assertEquals("",false,kingOfSpades.addfrom(tab));
		assertEquals("size after adding incorrectly should be unchanged ",1,kingOfSpades.size());
		tab.clearAll();
	}
	
	@Test
	public void TestHomecellPileRemoveCorrectly() {
		LSHomeCell testHome = new LSHomeCell().AceOfDiamond();	
		testHome.addTestCard(new Card(2,"diamonds"));
		Card followingCard = testHome.get(testHome.size()-2);
				assertEquals("When Tab is not empty the top card should be removed",false,testHome.remove());
				assertEquals("after removing each TableauPiles should hold 1 cards",2,testHome.size());
	}
	
	@Test
	public void TestHomecellPileRemoceNotCorrectly() {
			LSHomeCell testHome = new LSHomeCell().AceOfDiamond();	
				assertEquals("When Tab is not empty the top card should be removed",false,testHome.remove());
				assertEquals("after removing each TableauPiles should hold 1 cards",1,testHome.size());
			
	}
	
	
	/**
	 * This will test if cards are properly moved from Tableau Pile to Tableau Pile
	 */

	/**
	 * Little Spider does not have a stock pile to test
	 */

}
