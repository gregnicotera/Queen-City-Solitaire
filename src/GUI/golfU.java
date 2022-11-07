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
import code.Golf.GLFPile;
import code.Golf.Golf;

public class golfU {
	private static JLabel label1_1;
	static JLabel label1_2;
	static JLabel label1_3;
	static JLabel label1_4;
	static JLabel label1_5;
	static JLabel label1_6;
	static JLabel label1_7;
	static JLabel Home;
	static JLabel Stock;
	Golf golf;
	private MoveCardListener _1_1,_1_2,_1_3,_1_4,_1_5,_1_6,_1_7;
	private StockListener stock;
	private HomeListener home;
	JFrame frame;
	GLFPile original;
	GLFPile another;
	Main main;
	
public static void run() {
	golfU u = new golfU();
	u.runGGUI();
}
public golfU() {
	Golf golf = new Golf();
	this.golf = golf;
	
}
public  golfU(Main main) {
	Golf golf = new Golf();
	this.golf = golf;
	this.main=main;
}
	  void runGGUI() {
		JFrame f=new JFrame("Golf Game");
		this.frame=f;
		f.setVisible(true);
		f.setSize(680,400);;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		f.add(panel);
		panel.setBackground(new java.awt.Color(32, 90, 20)); 
		
		label1_1= new JLabel();
		label1_2= new JLabel();
		label1_3= new JLabel();
		label1_4= new JLabel();
		label1_5= new JLabel();
		label1_6= new JLabel();
		label1_7= new JLabel();
		Home= new JLabel();
		Stock= new JLabel();
		//Exit
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
	
		
		label1_1.setIcon(golf.getTableauList().get(0).getTopCard().getImageIcon());
		label1_2.setIcon(golf.getTableauList().get(1).getTopCard().getImageIcon());
		label1_3.setIcon(golf.getTableauList().get(2).getTopCard().getImageIcon());
		label1_4.setIcon(golf.getTableauList().get(3).getTopCard().getImageIcon());
		label1_5.setIcon(golf.getTableauList().get(4).getTopCard().getImageIcon());
		label1_6.setIcon(golf.getTableauList().get(5).getTopCard().getImageIcon());
		label1_7.setIcon(golf.getTableauList().get(6).getTopCard().getImageIcon());
		Stock.setIcon(golf.getStockPile().getTopCard().getImageIcon());
		Home.setIcon(new Card(100,"hi").getImageIcon());
		_1_1 = new MoveCardListener(this,label1_1,golf.getTableauList().get(0));
		_1_2 = new MoveCardListener(this,label1_2,golf.getTableauList().get(1));
		_1_3 = new MoveCardListener(this,label1_3,golf.getTableauList().get(2));
		_1_4 = new MoveCardListener(this,label1_4,golf.getTableauList().get(3));
		_1_5 = new MoveCardListener(this,label1_5,golf.getTableauList().get(4));
		_1_6 = new MoveCardListener(this,label1_6,golf.getTableauList().get(5));
		_1_7 = new MoveCardListener(this,label1_7,golf.getTableauList().get(6));
		home= new HomeListener(this,Home,golf.getHomeCell());
		stock = new StockListener(this,Stock,golf.getStockPile());
		label1_1.addMouseListener(_1_1);
		label1_2.addMouseListener(_1_2);
		label1_3.addMouseListener(_1_3);
		label1_4.addMouseListener(_1_4);
		label1_5.addMouseListener(_1_5);
		label1_6.addMouseListener(_1_6);
		label1_7.addMouseListener(_1_7);
		Home.addMouseListener(home);
		Stock.addMouseListener(stock);

		panel.add(label1_1);
		panel.add(label1_2);
		panel.add(label1_3);
		panel.add(label1_4);
		panel.add(label1_5);
		panel.add(label1_6);
		panel.add(label1_7);
		panel.add(Home);
		panel.add(Stock);
		
		
}
	  public void cleanMoveSys() {
		  this.original = null;
		  this.another = null;
		  	_1_1.resetModCount();_1_2.resetModCount();_1_3.resetModCount();_1_4.resetModCount();_1_5.resetModCount();_1_6.resetModCount();
		  	_1_7.resetModCount();home.resetModCount();stock.resetModCount();
	  }
	  
	public void update() {
		 if(original!=null&&another !=null) {
				if(another.addfrom(this.original)==true) {

				}else if(another.addfrom(this.original) == false) {
					
					JOptionPane.showMessageDialog(frame,
						    "ILLEGAL CARD MOVE",
						    "Card Move Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				cleanMoveSys();	
			}
		 
		label1_1.setIcon(golf.getTableauList().get(0).getTopCard().getImageIcon());
		label1_2.setIcon(golf.getTableauList().get(1).getTopCard().getImageIcon());
		label1_3.setIcon(golf.getTableauList().get(2).getTopCard().getImageIcon());
		label1_4.setIcon(golf.getTableauList().get(3).getTopCard().getImageIcon());
		label1_5.setIcon(golf.getTableauList().get(4).getTopCard().getImageIcon());
		label1_6.setIcon(golf.getTableauList().get(5).getTopCard().getImageIcon());
		label1_7.setIcon(golf.getTableauList().get(6).getTopCard().getImageIcon());
		
		
		 Stock.setIcon(golf.getStockPile().getTopCard().getImageIcon());
		 
		  if(golf.getHomeCell().size()!=0) {
			  Home.setIcon(golf.getHomeCell().getTopCard().getImageIcon());
			  Home.setText("");
		  }else if(golf.getHomeCell().size()==0) {
			  Home.setIcon(null);
			  Home.setText("Home");
		  }
		
	}
	
	public void cleanLableBorder() {
		label1_1.setBorder(UNSELECTED_BORDER); label1_1.repaint();
		label1_2.setBorder(UNSELECTED_BORDER); label1_2.repaint();
		label1_3.setBorder(UNSELECTED_BORDER); label1_3.repaint();
		label1_4.setBorder(UNSELECTED_BORDER); label1_4.repaint();
		label1_5.setBorder(UNSELECTED_BORDER); label1_5.repaint();
		label1_6.setBorder(UNSELECTED_BORDER); label1_6.repaint();
		label1_7.setBorder(UNSELECTED_BORDER); label1_7.repaint();
		Home.setBorder(UNSELECTED_BORDER); Home.repaint();
		Stock.setBorder(UNSELECTED_BORDER); Stock.repaint();
		update();
	}
	
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5,
                                                                                Color.BLACK);
	
	public static void main(String[] args) {
		run();
	}	
}

