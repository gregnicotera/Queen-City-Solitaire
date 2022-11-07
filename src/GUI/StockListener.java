package GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import code.Golf.GLFPile;


public class StockListener implements MouseListener {
	private golfU gui;
	private JLabel label;
	private int select;
	GLFPile pile;
	public StockListener(golfU gui, JLabel label,GLFPile pile) {
		this.gui=gui;
		this.label = label;
		this.select = 2;
		this.pile=pile;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		select++;
		
		
		
	 if (select%2 !=0) { //selected
		 
		 if(gui.original!=null) {
			 JOptionPane.showMessageDialog(gui.frame,
					    "ILLEGAL CARD MOVE",
					    "Card Move Error",
					    JOptionPane.ERROR_MESSAGE);
			 gui.update();
		 }
		 
		if(gui.original==null&& gui.another==null) {	
		 gui.original =this.pile;
			gui.another = gui.golf.getHomeCell();
			gui.update();
		}
	 }
	 
	}
	public void resetModCount() {
		this.select=0;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
