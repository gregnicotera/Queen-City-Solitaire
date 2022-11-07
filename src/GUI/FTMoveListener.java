package GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import code.FortyThieves.FTPile;
import code.Golf.GLFPile;


public class FTMoveListener implements MouseListener {
	private fortyU gui;
	private JLabel label;
	private int select;
	FTPile pile;
	
	public FTMoveListener(fortyU gui, JLabel label,FTPile pile) {
		this.gui=gui;
		this.label = label;
		this.select = 2;
		this.label.setBorder(UNSELECTED_BORDER);
		this.label.repaint();
		this.pile=pile;
	}
	
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5,
                                                                                Color.BLACK);
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		select++;
		
		if(select%2 == 0) {//unselected
			label.setBorder(UNSELECTED_BORDER);
			label.repaint();	
			
			if(gui.another!=null) {
				gui.another=null;
				
			}else if(gui.original!=null) {
				gui.original=null;
			}
		
		
		
		}else if (select%2 !=0) { //selected
			if(pile.getType()!="FTHomeCell") {
			label.setBorder(SELECTED_BORDER);
			  label.repaint();
			}
			
			  if(gui.original == null) {
				  gui.original=this.pile;
			  }else if(gui.another ==null) {
				  gui.another=this.pile;
				  gui.cleanLableBorder();
			  }
			
			
		}
		
		gui.update();
		
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
