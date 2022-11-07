package code.FortyThieves;

import code.Card;
import code.Golf.GLFPile;

public class FTWastePile extends FTPile {
	private String type;
	
	public FTWastePile () {
		type ="WastePile";
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.PileList.size();
	}

	@Override
	public Card getTopCard() {
		System.out.println(this.PileList.size()-1);
		return this.PileList.get(PileList.size()-1);
	}

	@Override
	public boolean remove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addfrom(FTPile pile) {
		// TODO Auto-generated method stub
		if(pile.getType()=="StockPile") {
			PileList.add(pile.removeTopCard());
			return true;
		}
		return false;
	}

	@Override
	public Card get(int i) {
		// TODO Auto-generated method stub
		return this.PileList.get(i);
	}
	public void addTestCard(Card card) {
		this.PileList.add(card);
	}
	@Override
	public Card removeTopCard() {
Card ret = this.PileList.remove(PileList.size()-1);
		
		return ret;
	}

}
