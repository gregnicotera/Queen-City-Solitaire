package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import code.LittleSpider.LSPile;
import code.LittleSpider.LittleSpider;

public class SpiderU {
	private static JLabel label1_1;
	static JLabel label1_2;
	static JLabel label1_3;
	static JLabel label1_4;
	static JLabel label1_5;
	static JLabel label1_6;
	static JLabel label1_7;
	static JLabel label1_8;
	static JLabel Home1,Home2,Home3,Home4;
	Main main;
	LittleSpider ls;
	private LsMoveListener _1_1 ,_1_2,_1_3,_1_4,_1_5,_1_6,_1_7,_1_8;
	
	private LsMoveListener home1,home2,home3,home4;
	 JFrame frame;
	LSPile original;
	LSPile another;
	
	
	public static void run() {
		SpiderU u = new SpiderU();
		u.runLSGUI();
	}
	public SpiderU() {
		LittleSpider ls = new LittleSpider();
		this.ls=ls;
	
	}
	public SpiderU(Main main) {
		LittleSpider ls = new LittleSpider();
		this.ls=ls;
	}
	void runLSGUI() {
		JFrame f=new JFrame("LittleSpider");
		this.frame=f;
		f.setVisible(true);
		f.setSize(740,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		f.add(panel);
		panel.setBackground(new java.awt.Color(32, 90, 20));
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
		label1_1= new JLabel();
		label1_2= new JLabel();
		label1_3= new JLabel();
		label1_4= new JLabel();
		label1_5= new JLabel();
		label1_6= new JLabel();
		label1_7= new JLabel();
		label1_8= new JLabel();
		Home1 = new JLabel();Home2 = new JLabel();Home3 = new JLabel();Home4 = new JLabel();
		_1_1 = new LsMoveListener(this,label1_1,ls.getTableauList().get(0));
		_1_2 = new LsMoveListener(this,label1_2,ls.getTableauList().get(1));
		_1_3 = new LsMoveListener(this,label1_3,ls.getTableauList().get(2));
		_1_4 = new LsMoveListener(this,label1_4,ls.getTableauList().get(3));
		_1_5 = new LsMoveListener(this,label1_5,ls.getTableauList().get(4));
		_1_6 = new LsMoveListener(this,label1_6,ls.getTableauList().get(5));
		_1_7 = new LsMoveListener(this,label1_7,ls.getTableauList().get(6));
		_1_8 = new LsMoveListener(this,label1_8,ls.getTableauList().get(7));
		home1 = new LsMoveListener(this,Home1,ls.getHomeCell1());
		home2 = new LsMoveListener(this,Home2,ls.getHomeCell2());
		home3 = new LsMoveListener(this,Home3,ls.getHomeCell3());
		home4 = new LsMoveListener(this,Home4,ls.getHomeCell4());

		label1_1.setIcon(ls.getTableauList().get(0).getTopCard().getImageIcon());
		label1_2.setIcon(ls.getTableauList().get(1).getTopCard().getImageIcon());
		label1_3.setIcon(ls.getTableauList().get(2).getTopCard().getImageIcon());
		label1_4.setIcon(ls.getTableauList().get(3).getTopCard().getImageIcon());
		label1_5.setIcon(ls.getTableauList().get(4).getTopCard().getImageIcon());
		label1_6.setIcon(ls.getTableauList().get(5).getTopCard().getImageIcon());
		label1_7.setIcon(ls.getTableauList().get(6).getTopCard().getImageIcon());
		label1_8.setIcon(ls.getTableauList().get(7).getTopCard().getImageIcon());
		Home1.setIcon(ls.getHomeCell1().getTopCard().getImageIcon());
		Home2.setIcon(ls.getHomeCell2().getTopCard().getImageIcon());
		Home3.setIcon(ls.getHomeCell3().getTopCard().getImageIcon());
		Home4.setIcon(ls.getHomeCell4().getTopCard().getImageIcon());
		
		label1_1.addMouseListener(_1_1);
		label1_2.addMouseListener(_1_2);
		label1_3.addMouseListener(_1_3);
		label1_4.addMouseListener(_1_4);
		label1_5.addMouseListener(_1_5);
		label1_6.addMouseListener(_1_6);
		label1_7.addMouseListener(_1_7);
		label1_8.addMouseListener(_1_8);
		Home1.addMouseListener(home1);
		Home2.addMouseListener(home2);
		Home3.addMouseListener(home3);
		Home4.addMouseListener(home4);

		panel.add(label1_1);
		panel.add(label1_2);
		panel.add(label1_3);
		panel.add(label1_4);
		panel.add(label1_5);
		panel.add(label1_6);
		panel.add(label1_7);
		panel.add(label1_8);
		panel.add(Home1);
		panel.add(Home2);
		panel.add(Home3);
		panel.add(Home4);
		
	}
	  public void cleanMoveSys() {
		  this.original = null;
		  this.another = null;
		  _1_1.resetModCount();_1_2.resetModCount();_1_3.resetModCount();_1_4.resetModCount();
		  _1_5.resetModCount();_1_6.resetModCount();_1_7.resetModCount();_1_8.resetModCount();
		  home1.resetModCount();home2.resetModCount();home3.resetModCount();home4.resetModCount();
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
		 
		label1_1.setIcon(ls.getTableauList().get(0).getTopCard().getImageIcon());
		label1_2.setIcon(ls.getTableauList().get(1).getTopCard().getImageIcon());
		label1_3.setIcon(ls.getTableauList().get(2).getTopCard().getImageIcon());
		label1_4.setIcon(ls.getTableauList().get(3).getTopCard().getImageIcon());
		label1_5.setIcon(ls.getTableauList().get(4).getTopCard().getImageIcon());
		label1_6.setIcon(ls.getTableauList().get(5).getTopCard().getImageIcon());
		label1_7.setIcon(ls.getTableauList().get(6).getTopCard().getImageIcon());
		label1_8.setIcon(ls.getTableauList().get(7).getTopCard().getImageIcon());
		Home1.setIcon(ls.getHomeCell1().getTopCard().getImageIcon());
		Home2.setIcon(ls.getHomeCell2().getTopCard().getImageIcon());
		Home3.setIcon(ls.getHomeCell3().getTopCard().getImageIcon());
		Home4.setIcon(ls.getHomeCell4().getTopCard().getImageIcon());
	}
			 
	
	public void cleanLableBorder() {
		label1_1.setBorder(UNSELECTED_BORDER); label1_1.repaint();
		label1_2.setBorder(UNSELECTED_BORDER); label1_2.repaint();
		label1_3.setBorder(UNSELECTED_BORDER); label1_3.repaint();
		label1_4.setBorder(UNSELECTED_BORDER); label1_4.repaint();
		label1_5.setBorder(UNSELECTED_BORDER); label1_5.repaint();
		label1_6.setBorder(UNSELECTED_BORDER); label1_6.repaint();
		label1_7.setBorder(UNSELECTED_BORDER); label1_7.repaint();
		label1_8.setBorder(UNSELECTED_BORDER); label1_8.repaint();
		Home1.setBorder(UNSELECTED_BORDER); Home1.repaint();
		Home2.setBorder(UNSELECTED_BORDER); Home2.repaint();
		Home3.setBorder(UNSELECTED_BORDER); Home3.repaint();
		Home4.setBorder(UNSELECTED_BORDER); Home4.repaint();
		
		update();
	}
	
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5,Color.BLACK);
	
	public static void main(String[] args) {
		run();
	}	
}

