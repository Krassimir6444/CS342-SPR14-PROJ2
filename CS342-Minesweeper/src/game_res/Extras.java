package game_res;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import launcher.Minesweeper;
import example_res.ButtonTest;

// implementing just in case
public class Extras extends JFrame {
	
	private Container containerE;
	private BorderLayout extrasLayout;
	private JLabel bombs;
	private int bombCount = 10;
	private JLabel timer;
	private int time = 0;
	private JButton reset;
	
	public Extras() {
		extrasLayout = new BorderLayout(15,0);
		
		containerE = getContentPane();
	    containerE.setLayout(extrasLayout);
	    
	    bombs = new JLabel("   Bombs left: " + bombCount);
	    
	    reset = new JButton("RESET");
	    ButtonHandler resetHandler = new ButtonHandler();
	    reset.addActionListener(resetHandler);
	    
	    timer = new JLabel("Timer: " + time + "   ");
	    // need to implement timer, prof posted some source code
	    
	    containerE.add(bombs,BorderLayout.WEST);
	    containerE.add(reset,BorderLayout.CENTER);
	    containerE.add(timer,BorderLayout.EAST);
	    
	}

	public void decrementBombs() {
		bombCount--;
		bombs.setText("   Bombs left: " + bombCount);
	}
	
	public void incrementBombs() {
		bombCount++;
		bombs.setText("   Bombs left: " + bombCount);
	}
	
	// inner class for button event handling
	private class ButtonHandler implements ActionListener {
		// handle button event
	    public void actionPerformed(ActionEvent event) {
	    	JOptionPane.showMessageDialog(Extras.this,
	            "You pressed: " + event.getActionCommand() );
	    	// need to reset the game
	    }
	}
	
	public Container getContainer() {
		return containerE;
	}
}