package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import code.Card;
import code.Golf.GLFHomeCell;
import code.Golf.GLFStockPile;
import code.Golf.GLFTableauPiles;
import code.Golf.Golf;


public class TestGolf {

	/**
	 * Golf - Tableau Pile Tests
	 * 7 Tableau Piles
	 * Initial setup
	 * When the game begins each tableau pile should be dealt 5 cards. These cards should be face-up (but only the top one matters).
	 * Removing a Card
	 * Only the card which is currently at the top of the tableau pile can be removed. Once a card is removed, the card following it in the pile becomes the top card and can be removed.
	 * Adding a Card
	 * Once the initial setup is complete, cards cannot be added to a tableau pile.
	 * 
	 */
	
@Test
public void TestTableauPilesInitial() {
	//check Tableau Number and size;
	Golf golf = new Golf();
	assertNotNull("Golf should not be null",golf);
	assertEquals("Golf should have 7 TableauPiles",7,golf.getTableauList().size());
	int PileSize = golf.getTableauList().get(1).size();
	assertEquals("Each TableauPiles should hold 5 cards",6,PileSize);
	//Golf tableau pile correctly determines if adding a specific card is legal or illegal 
	//(e.g., the method should always return false) [4 points]
			//assertEquals();
}

@Test public void TestTableauAddcorrectly() {
	//TestTableau cannot being add any card after initialization
}

@Test 
public void TestTableauAddIncorrectly() {
	//adding test
	Golf golf = new Golf();
	GLFHomeCell testHomeCell = golf.getHomeCell();
	GLFStockPile testStock = golf.getStockPile();
	
		GLFTableauPiles t1= golf.getTableauList().get(0);
		//false run
		assertEquals("Card cannot being added to TableauPile after initialization",false,t1.add(new Card().random()));
		assertEquals("Card cannot being added to TableauPile after initialization",false,t1.addfrom(testStock));
}

@Test
public void TestTableauRemoveCorrectly() {
	//remove test
	Golf golf = new Golf();
	int PileSize = golf.getTableauList().get(0).size();
	GLFTableauPiles testTableau= golf.getTableauList().get(0);
	Card followingCard = testTableau.get(testTableau.size()-2);//memerize the original followingcard
	assertEquals("should be true if remove the top card",true, testTableau.remove(testTableau.size()-1));
	
	PileSize = golf.getTableauList().get(0).size();
	assertEquals("after removing the followingCard shoud become the topCard",followingCard,testTableau.getTopCard());
	assertEquals("after removing each TableauPiles should hold 6 cards",5,PileSize);
}



public void TestTableauRemoveNoCorrectly() {
	Golf golf = new Golf();
	GLFTableauPiles testTableau= golf.getTableauList().get(0);
	assertEquals("only the topCard can be removed",false,testTableau.remove(0));
	assertEquals("Size should remain the same",5,testTableau.size());
}

/**
 * Golf - Homecell Pile tests
 * Homecell pile in Golf initially holds 0 cards [4 points]
 * Golf homecell pile correctly determines if adding a card is legal or illegal
 * 		To receive points, your test(s) cannot call one method for when the card comes from the stock pile 
 * 		and a different method for when the card comes from a tableau pile. [6 points]
 * Golf homecell pile correctly returns if removing top card is legal or illegal (e.g., always false) [4 points]
 * Adding card to Golf homecell pile increases its number of cards and results in that card being the homecell pile's new top card [4 points]
 * 
 */
@Test
public void TestHomecellPile() {
	//check initial setup
	Golf golf = new Golf();
	assertEquals("the initial homcell size for golf should be 0",0,golf.getHomeCell().size());
}

@Test
public void TestHomecellRemoveCorrect() {
	//It should always be false 
}

@Test 
public void TestHomecellRemoveNoCorrect() {
	Golf golf = new Golf();
	GLFHomeCell testHomeCell = golf.getHomeCell();
	assertEquals("",false,testHomeCell.remove());//remove should always be false
}


@Test public void TestHomecellAddCorrectly() {
	
	Golf golf = new Golf();
	//adding test
		GLFTableauPiles testTab = new GLFTableauPiles();//Creat a test TableauPiles because TableauPile in golf game will randomly generate 5 cards
		GLFHomeCell testHomeCell = golf.getHomeCell();int size = testHomeCell.size();// testHomeCell
		GLFStockPile testStock = golf.getStockPile();//Stock from the golf thus will contain 47 card in Random order
		
		assertEquals("initial testHomeCell should be 0",0,testHomeCell.size());//add Card from testTab to TestHomeCell

		
		Card testCard =new Card( 13,"diamonds") ;//test card 1 "king of diamond"
		Card testCard2 = new Card(12,"diamonds") ;//test card 2 "queen of diamond"
	
		testHomeCell.addTestCard(testCard);//add test card 1 (king of diamond) to testHomeCell so now homecell contain 1 king of diamond
		testTab.addTestCard(testCard2);//add test card 2 (queen of diamond) to test TableauPiles;
		assertEquals("after add test card should be",1,testHomeCell.size());//add Card from testTab to TestHomeCell

		assertEquals("testCard 12 : diamonds should be added to testHomeCell",true,testHomeCell.addfrom(testTab));//add Card from testTab to TestHomeCell
		assertEquals("after add  should be 2",2,testHomeCell.size());//add Card from testTab to TestHomeCell

		assertEquals("It is always legal to add a card from the stock pile to the homecell pile",true,testHomeCell.addfrom(testStock));//add
		Card topCard = testStock.getTopCard();//since stock aways generate random, need to set a topCard from Stock
		assertEquals("after add  should be 3",3,testHomeCell.size());//check if testHomeCell if it successfully added

}

@Test public void TestHomecellAddfromNoCorrectly() {
	Golf golf = new Golf();
	//adding test
		GLFTableauPiles testTab = new GLFTableauPiles();//Creat a test TableauPiles because TableauPile in golf game will randomly generate 5 cards
		GLFHomeCell testHomeCell = golf.getHomeCell();int size = testHomeCell.size();// testHomeCell
		GLFStockPile testStock = golf.getStockPile();//Stock from the golf thus will contain 47 card in Random order
		
		assertEquals("initial testHomeCell should be 0",0,testHomeCell.size());//add Card from testTab to TestHomeCell
		Card kingofdiamond =new Card( 13,"diamonds") ;//test card 1 "king of diamond"
		Card tenOfdiamond = new Card(10,"diamonds") ;//test card 2 "10 of diamond"
		testHomeCell.addTestCard(kingofdiamond);
		testTab.addTestCard(tenOfdiamond);
		assertEquals("card is not +-1 cannot being added to homecell from tabealu",false,testHomeCell.addfrom(testTab));
		assertEquals("testHomeCell should only hold 1 test card kingofdiamond",1,testHomeCell.size());

}

/**
 * Golf - Stock Pile Tests
 * Golf stock initially holds 17 cards [2 points]
 * Golf stock pile correctly returns if adding a specific card is legal or illegal (e.g., the method should always return false) [2 points]
 * Golf stock pile correctly returns if removing top card is legal or illegal (e.g., if the stock pile is NOT empty) [2 points]
 * Removing card from Golf's stock pile decreases its number of cards and results in following card being the new top card [2 points]
 */
@Test
public void testStockPileInitial() {
	Golf golf = new Golf();
	GLFStockPile testStock = golf.getStockPile();
	assertEquals("Golf stock initially holds 17 cards",18,testStock.size());
	
}
@Test
public void testStockPileaddCorrectly() {
	//StockPile cannot being added correctly according to the rule.
}
@Test
public void testStockPileaddNoCorrectly() {
	Golf golf = new Golf();
	GLFStockPile testStock = golf.getStockPile();
	GLFTableauPiles testTab = new GLFTableauPiles();
	testTab.addRandom5();
	assertEquals("Stock cannot be added",false,testStock.addfrom(testTab));
	
}
@Test
public void testStockPileRemoveCorrectly() {
	Golf golf = new Golf();
	GLFStockPile testStock = golf.getStockPile();
	int PileSize = golf.getStockPile().size();
	
	Card followingCard = testStock.get(testStock.size()-2);//memerize the original followingcard
	assertEquals("should be true if remove the top card",true, testStock.remove(testStock.size()-1));
	
	PileSize = golf.getStockPile().size();
	
	assertEquals("after removing the followingCard shoud become the topCard",followingCard,testStock.getTopCard());
	assertEquals("after removing each TableauPiles should hold 4 cards",17,PileSize);
}
@Test
public void testStockPileRemoveNoCorrectly() {
	Golf golf = new Golf();
	GLFStockPile testStock = new GLFStockPile().clearAll();;
	int PileSize = golf.getStockPile().size();
	assertEquals("Should return false",false,testStock.remove());
	
	
}

}
