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
import code.Deck;
import code.FortyThieves.FTHomeCell;
import code.FortyThieves.FTStockPile;
import code.FortyThieves.FTTableauPile;
import code.FortyThieves.FTWastePile;
import code.FortyThieves.FortyThieves;
import code.Golf.GLFHomeCell;
import code.Golf.GLFStockPile;
import code.Golf.GLFTableauPiles;
import code.Golf.Golf;


public class TestFortyTheives {
/*
 * Fourty Thieves uses two full decks of cards (so each suit and rank 
 * combination appears twice for a total of 104 cards). The two copies of each card are used interchangably.
 *  In Fourty Thieves, an Ace is the LOWEST valued card in each suit. 
 * (These rules are for a specific variant of Forty Thieves called "Lucas".)
 */
	
	
@Test
public void TestFortyTheivesInitial() {
	FortyThieves ft = new FortyThieves();
	//deck
	assertEquals("104 cards",104,new Deck(2).size());
	//tab
	assertEquals("In game of ft should have 13 Tab piles",13,ft.getTableauPileList().size());
	
	//home
	assertEquals("8 homecell",8,ft.getHomeCellList().size());
	assertEquals("1 card",1,ft.getHomeCellList().get(0).size());
	//stock
	assertEquals("57 cards",57,ft.getStockPile().size());
	//wast
	assertEquals("0 card",0,ft.getWatePile().size()-1);
	
	
}
@Test
public void TestTabInitial(){//Tableau piles in Forty Thieves initially hold 3 cards [2 points]
	FortyThieves ft = new FortyThieves();
	assertEquals("In each tab pile should contain 3 card",3,ft.getTableauPileList().get(0).size()-1);
	assertEquals("","FTTableauPile",ft.getTableauPileList().get(0).getType());Card test = new Card(99,"base");
	FTTableauPile t = new FTTableauPile(); t.add(new Card(5,"spade"));t.add(test);
	assertEquals("",test,t.removeTopCard());
	
}
@Test public void TestTableauAddcorrectly() {//Forty Thieves tableau pile method correctly determines if adding a specific card is legal or illegal. [4 points]

	FTTableauPile t = new FTTableauPile();
	FTWastePile w = new FTWastePile();w.addTestCard(new Card(5,"spade"));
	FTHomeCell h = new FTHomeCell(); h.addTestCard(new Card(5,"spade"));
	
	//empty 
	
	assertEquals("when empty should always be true",true, t.addfrom(w));
	//non empty t top 5,"spade"
	w.addTestCard(new Card(4,"spade"));
	assertEquals("when empty should always be true",true, t.addfrom(w));
}
public void TestTableauAddResult() {//Adding a card to Forty Thieves tableau pile increases its number of cards and results in that card being the tableau pile's new top card [4 points]
	FTTableauPile t = new FTTableauPile(); t.add(new Card(99,"base")); t.add(new Card(5,"spade"));
	FTTableauPile t2 = new FTTableauPile(); t.add(new Card(99,"base")); 
	Card test = new Card(4,"spade");t2.addTestCard(test);
	 assertEquals("",true,t.addfrom(t2));
	 assertEquals("",test,t.getTopCard());
}

@Test 
public void TestTableauAddIncorrectly() {//Forty Thieves tableau pile method correctly determines if adding a specific card is legal or illegal. [4 points]
	//adding test
	FTTableauPile t = new FTTableauPile(); t.add(new Card(99,"base")); t.add(new Card(5,"spade"));
	FTWastePile w = new FTWastePile();w.addTestCard(new Card(5,"spade"));
	FTHomeCell h = new FTHomeCell();
	FTStockPile s = new FTStockPile();
	//non empty same suit
	int wasteSizeBefore = w.size();
	assertEquals("",false, t.addfrom(w));
	assertEquals("",wasteSizeBefore, w.size());//should remain unmoved
	//non empty different suit
	w.addTestCard(new Card(4,"heart"));
	assertEquals("",false, t.addfrom(w));
	try {
		assertEquals("",false,t.remove());
		assertEquals("",false,t.remove(2));
	
		} catch(Exception e) {
			
		}
}
@Test
public void TestTabPileRemove() {//Forty Thieves tableau pile method correctly determines if removing a specific card is legal or illegal. [4 points]

	FTTableauPile t = new FTTableauPile(); t.add(new Card(99,"base")); 
	FTTableauPile t2 = new FTTableauPile(); t.add(new Card(99,"base"));t.add(new Card(6,"spade")); 
	Card test = new Card(4,"spade");t2.addTestCard(test);t2.addTestCard(test);
	 assertEquals("",false,t.addfrom(t2));
	 assertEquals("",test,t2.getTopCard());
	 
	 
}

@Test public void TestRemoveResult() {//Removing a card from Forty Thieves tableau pile decreases its number of cards and results in following card being the new top card [4 points]
	FTTableauPile t = new FTTableauPile(); t.add(new Card(99,"base")); 
	FTTableauPile t2 = new FTTableauPile(); t.add(new Card(99,"base"));t.add(new Card(6,"spade")); 
	Card test = new Card(4,"spade");t2.addTestCard(test);t2.addTestCard(test);
	 assertEquals("",false,t.addfrom(t2));
	 assertEquals("",test,t2.getTopCard());
}

//HomeCell
@Test
public void TestHomecellPile() {//Forty Thieves homecell piles initially hold 1 card [2 points]
	FortyThieves ft = new FortyThieves();
	assertEquals("1 card",1,ft.getHomeCellList().get(0).size());
	assertEquals("",false,ft.getHomeCellList().get(0).remove());
}


@Test 
public void TestHomecellRemoveNoCorrect() {//HomeCell cannot be moved

	FTHomeCell h = new FTHomeCell(); h.addTestCard(new Card(2,"spades"));
	
	assertEquals("",false,h.remove());
	try {
		assertEquals("",false,h.remove());
		assertEquals("",false,h.remove(2));
	
		} catch(Exception e) {
			
		}
}


@Test public void TestHomecellAddCorrectly() {//add correct
	FTTableauPile t = new FTTableauPile(); t.add(new Card(2,"spades"));
	FTWastePile w = new FTWastePile();
	FTHomeCell h = new FTHomeCell().AceOfSpades();
	FTStockPile s = new FTStockPile();
	assertEquals("",true,h.addfrom(t));

}

@Test public void TestHomecellAddfromNoCorrectly() {//add incorrectlly
	FTTableauPile t = new FTTableauPile();t.add(new Card(2,"hearts"));	
	FTHomeCell h = new FTHomeCell().AceOfSpades();
	assertEquals("",false,h.addfrom(t));
}
@Test public void TestHomeCellAddResult() {
	FTTableauPile t = new FTTableauPile(); t.add(new Card(3,"spades")); Card test = new Card(2,"spades"); t.addTestCard(test);
	
	FTHomeCell h = new FTHomeCell().AceOfSpades();
	h.addfrom(t);// h addfrom t
	assertEquals("",test,h.getTopCard());
}
@Test public void TestHomeCellRemoveResult() {
	FTHomeCell h = new FTHomeCell().AceOfClubs(); h.addTestCard(new Card(2,"spades"));Card test = new Card(2,"spades"); h.addTestCard(test);
	FTHomeCell h2 = new FTHomeCell().AceOfDiamond(); 
	h2.addfrom(h);
	assertEquals("",test,h.getTopCard());//remain unmoved
	
}
//stock
@Test
public void testStockPileInitial() {//initial
	FortyThieves ft = new FortyThieves();
	assertEquals("57 cards",57,ft.getStockPile().size());
}

@Test
public void testStockPileaddNoCorrectly() {
	FTTableauPile t = new FTTableauPile(); t.add(new Card(14,"spades"));
	FTWastePile w = new FTWastePile();
	FTHomeCell h = new FTHomeCell();
	FTStockPile s = new FTStockPile();
	assertEquals("",false,s.addfrom(t));
}

@Test
public void testStockPileRemoveNoCorrectly() {
	FTTableauPile t = new FTTableauPile();
	FTWastePile w = new FTWastePile();
	FTHomeCell h = new FTHomeCell();
	FTStockPile s = new FTStockPile();
	assertEquals("",false,s.remove());
	try {
		assertEquals("",false,s.remove());
		assertEquals("",false,s.remove(2));
		assertEquals("",false,s.removeTopCard());
		} catch(Exception e) {
			
		}
}
@Test
public void testSTockPileRemoveResult() {
	FortyThieves ft = new FortyThieves();
	FTStockPile s = ft.getStockPile();
	FTWastePile w = new FTWastePile();
	Card originaltop = s.getTopCard();
	Card following = s.get(s.size()-2);
	int size = s.size();
	assertEquals("",false,s.addfrom(s));//false remove
	assertEquals("",originaltop,s.getTopCard());
	assertEquals("",size,s.size());
	assertEquals("",true,w.addfrom(s));//correct remove
	assertEquals("",following,s.getTopCard());
	assertEquals("",size-1,s.size());
	//Removing a card from Forty Thieves waste pile decreases its number of cards and results in the following card being the new top card [1 points]

}

@Test
public void testWastePileInitial() {
	FortyThieves ft = new FortyThieves();
	assertEquals("",0,ft.getWatePile().size()-1);
}
@Test
public void testWastePileAddCorrectly() {
	FTTableauPile t = new FTTableauPile();
	FTWastePile w = new FTWastePile();
	FTHomeCell h = new FTHomeCell();
	FTStockPile s = new FTStockPile();
	FortyThieves ft = new FortyThieves();
	assertEquals("",true,w.addfrom(ft.getStockPile()));
}
@Test public void testWastePileAddIncorrectly() {
	FTTableauPile t = new FTTableauPile();
	FTWastePile w = new FTWastePile();
	FTHomeCell h = new FTHomeCell();
	FTStockPile s = new FTStockPile();
}
@Test public void testWastePileRemoveCorrectly() {
	FTTableauPile t = new FTTableauPile();
	Card test = new Card(10,"spade");
	FTWastePile w = new FTWastePile();w.addTestCard(new Card(10,"spade"));w.addTestCard(test);
	FTHomeCell h = new FTHomeCell();
	FTStockPile s = new FTStockPile();
	assertEquals("",false,w.remove());
	assertEquals("",test,w.removeTopCard());
	assertEquals("",1,w.size());
}
@Test public void testWastePileRemoveIncorrectly() {

	FTWastePile w = new FTWastePile();
	try {
	assertEquals("",false,w.remove());
	assertEquals("",false,w.remove(2));
	assertEquals("",false,w.removeTopCard());
	} catch(Exception e) {
		
	}
}
@Test public void testWasteRemoveResult() {//Removing a card from Forty Thieves waste pile decreases its number of cards and results in the following card being the new top card [1 points]
	FTWastePile w = new FTWastePile();w.addTestCard(new Card(2,"spades")); w.addTestCard(new Card(2,"spades"));  w.addTestCard(new Card(2,"spades"));
	FTTableauPile t = new FTTableauPile(); t.addTestCard(new Card(3,"spades"));
	int size = w.size();
	
	Card follwing = w.get(w.size()-2);
	assertEquals("",true,t.addfrom(w));
	assertEquals("",size-1,w.size());
	assertEquals("",follwing,w.getTopCard());
	
}

}
