package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
	public static void runG() {
		Main m = new Main();
		m.runGUI();
	}
	
	public  void runGUI(){
        JFrame frame = new JFrame("Menu");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      
        JLabel lbl = new JLabel("Choose the game you would like to play");
        lbl.setBackground(new java.awt.Color(32, 90, 20));
        lbl.setOpaque(true);
        lbl.setFont(new java.awt.Font("American TypeWriter", Font.PLAIN, 29));
        lbl.setForeground(Color.white);
        frame.add(lbl, BorderLayout.NORTH);
        frame.setBackground(new java.awt.Color(32, 90, 20));
        
        JButton golfgame=new JButton("Golf");
        JButton lsgame=new JButton("Little Spider");
        JButton ftgame=new JButton("Forty Thieves");
        JButton exit =new JButton("Exit");
        
        JPanel startpanel=new JPanel();
        frame.add(startpanel);
        startpanel.setBackground(new java.awt.Color(32, 90, 20));
        
        lsgame.setBackground(new java.awt.Color(188, 187, 206));
        lsgame.setOpaque(true);
        lsgame.setBorderPainted(false);
        lsgame.setFont(new java.awt.Font("American TypeWriter", Font.PLAIN, 30));
        
        ftgame.setBackground(new java.awt.Color(188, 187, 206));
        ftgame.setOpaque(true);
        ftgame.setBorderPainted(false);
        ftgame.setFont(new java.awt.Font("American TypeWriter", Font.PLAIN, 30));
       
        golfgame.setBackground(new java.awt.Color(188, 187, 206));
        golfgame.setOpaque(true);
        golfgame.setBorderPainted(false);
        golfgame.setFont(new java.awt.Font("American TypeWriter", Font.PLAIN, 30));
        
        exit.setBackground(new java.awt.Color(188, 187, 206));
        exit.setOpaque(true);
        exit.setBorderPainted(false);
        exit.setSize(8,8);
        exit.setFont(new java.awt.Font("American TypeWriter", Font.PLAIN, 30));
       
        startpanel.add(golfgame);
        startpanel.add(lsgame);
        startpanel.add(ftgame);
        startpanel.add(exit);
        
        exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Exit")) { 
					frame.dispose();
				}
			}  	
        });
        class MainGolfListener implements ActionListener {
        	Main main;
        	public MainGolfListener(Main main) {
        		this.main=main;
        	}
        	
        	
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub
        		if(e.getActionCommand().equals("Forty Thieves")) {
        			fortyU ft = new fortyU(main);
        			ft.runFTGUI();
        	}

        }
        }
        class MainLLSListener implements ActionListener {
        	Main main;
        	public MainLLSListener(Main main) {
        		this.main=main;
        	}
        	
        	
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub
        		if(e.getActionCommand().equals("Forty Thieves")) {
        			fortyU ft = new fortyU(main);
        			ft.runFTGUI();
        	}

        }
        }
        class MainFortyListener implements ActionListener{
    		Main main;
        	public MainFortyListener(Main main) {
        		this.main=main;
        	}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fortyU ft =new fortyU(this.main);
				frame.dispose();
				ft.runFTGUI();
			}
    	}
    	
        golfgame.addActionListener(new MainGolfListener(this) {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Golf")) {
					golfU g= new golfU(this.main);
					frame.dispose();
					g.runGGUI();
				}
			}	
        	
        });
        lsgame.addActionListener(new MainLLSListener(this) {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Little Spider")) {
					SpiderU ls =new SpiderU(this.main);
					frame.dispose();
					ls.runLSGUI();
				}
			}	
        	
        });
		ftgame.addActionListener(new MainFortyListener(this));
		
		}
		
	
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                runG();
            }
        });
    }
}
