package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import code.Card;
import code.FortyThieves.FTPile;
import code.FortyThieves.FortyThieves;
import code.Golf.GLFPile;
import code.Golf.Golf;

public class fortyU {
	FortyThieves forty;
	private FTMoveListener[] FTmoveListener;
	private FTMoveListener[] FThomeListener;
	private FTStockListener FTstockListener;
	private FTMoveListener wasteListener;
	Main main;
	static JLabel[] tableau;
	static JLabel[] home;
	static JLabel stock;
	static JLabel waste;
	
	JFrame frame;
	FTPile original;
	FTPile another;
	
	public static void run() {
		fortyU u = new fortyU();
		u.runFTGUI();
	}
	public fortyU() {
		forty = new FortyThieves();
		
		this.FTmoveListener= new FTMoveListener[13];
		this.FThomeListener= new FTMoveListener[8];
		
	}
	public fortyU(Main main) {
		forty = new FortyThieves();
		this.main=main;
		this.FTmoveListener= new FTMoveListener[13];
		this.FThomeListener= new FTMoveListener[8];
		
	}
	void runFTGUI() {
		JFrame f=new JFrame("Forty Thieves Game");
		this.frame=f;
		f.setVisible(true);
		f.setSize(680,520);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		f.add(panel);
		panel.setBackground(new java.awt.Color(32, 90, 20)); 
		//Create Exit button
		JPanel exitPanel = new JPanel();
		exitPanel.setSize(10,5);;
		JButton exit= new JButton("Exit to Menu");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.runG();
				f.dispose();
			}
			
		});
		exitPanel.add(exit);
		f.add(exitPanel,BorderLayout.NORTH);
		//Create JLabel for each pile
		tableau = new JLabel[13];
		for(int i=0;i<13;i++) {
			tableau[i]= new JLabel();
		}
		
		home = new JLabel[8];
		for(int i=0;i<8;i++) {
			home[i]=new JLabel();
		}
		stock= new JLabel();
		waste = new JLabel();
		
		//set icon for each homecell
		for(int i=0;i<8;i++) {
			home[i].setIcon(forty.getHomeCellList().get(i).getTopCard().getImageIcon());
		}
		
		//create new listener for each move listener, 1 for each tableau pile
		
		for(int i=0;i<13;i++) {
			
			FTmoveListener[i] = new FTMoveListener(this,tableau[i],forty.getTableauPileList().get(i));
		}
		
		//set icon for each tableau, then add mouse listener for each pile
		for(int i=0;i<13;i++) {
			tableau[i].setIcon(forty.getTableauPileList().get(i).getTopCard().getImageIcon());
			tableau[i].addMouseListener(FTmoveListener[i]);
		}
		stock.setIcon(forty.getStockPile().getTopCard().getImageIcon());
		
		/**
		 * Code needed to set icon for waste pile
		 * waste.setIcon();
		 */
		
		waste.setIcon(forty.getWatePile().getTopCard().getImageIcon());
	
		for(int i=0;i<8;i++) {
			FThomeListener[i] = new FTMoveListener(this,home[i],forty.getHomeCellList().get(i));
			home[i].addMouseListener(FThomeListener[i]);
		}
		
		FTstockListener = new FTStockListener(this,stock,forty.getStockPile());
		stock.addMouseListener(FTstockListener);
		
		/**
		 * Add code for creating wasteListener, and add waste label
		 */
		this.wasteListener= new FTMoveListener(this,this.waste,forty.getWatePile());
		waste.addMouseListener(this.wasteListener);
		
		
		for(int i=0;i<13;i++) {
			panel.add(tableau[i]);
		}
		for(int i=0;i<8;i++) {
			panel.add(home[i]);
		}
		panel.add(stock);
		panel.add(waste);
	  }
	
	
	
	  public void cleanMoveSys() {
		  this.original = null;
		  this.another = null;
		  for(int i=0;i<13;i++) {
			  FTmoveListener[i].resetModCount();;
		  }
		  for(int i=0;i<8;i++) {
			 FThomeListener[i].resetModCount();
		  }
		 this.FTstockListener.resetModCount();
		 this.wasteListener.resetModCount();
	  }
	  
	public void update() {
		//check move
		if(original!=null&&another !=null) {
			if(another.addfrom(this.original)==true) {
				cleanMoveSys();	
			}else if(another.addfrom(this.original) == false) {
				JOptionPane.showMessageDialog(frame,
				    "ILLEGAL CARD MOVE",
				    "Card Move ErrorXXX",
				    JOptionPane.ERROR_MESSAGE);
			}
			cleanMoveSys();	
		}
		
		//reset tab icon
		for(int i=0;i<13;i++) {
			tableau[i].setIcon(forty.getTableauPileList().get(i).getTopCard().getImageIcon());
		}
		//reset stock icon
		stock.setIcon(forty.getStockPile().getTopCard().getImageIcon());
		//rest wast icon
		waste.setIcon(forty.getWatePile().getTopCard().getImageIcon());
		//reset homeIcon
		for(int i=0;i<8;i++) {
		  if(forty.getHomeCellList().get(i).size()!=0) {
			  home[i].setIcon(forty.getHomeCellList().get(i).getTopCard().getImageIcon());
			  home[i].setText("");
		  }else {
			  home[i].setIcon(null);
			  home[i].setText("Home");
		  }
		}
	}
	
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5,
                                                                                Color.BLACK);
	public void cleanLableBorder() {
		for(int i=0;i<13;i++) {
			tableau[i].setBorder(UNSELECTED_BORDER);
			tableau[i].repaint();
		}
		for(int i=0;i<8;i++) {
			home[i].setBorder(UNSELECTED_BORDER);
			home[i].repaint();
		}
		waste.setBorder(UNSELECTED_BORDER); 
		waste.repaint();
		stock.setBorder(UNSELECTED_BORDER); 
		stock.repaint();
		update();
	}	
	public static void main(String[] args) {
		run();
	}	
}

