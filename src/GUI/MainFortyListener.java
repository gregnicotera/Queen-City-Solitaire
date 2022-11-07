package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFortyListener implements ActionListener {
	Main main;
	public MainFortyListener(Main main) {
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
