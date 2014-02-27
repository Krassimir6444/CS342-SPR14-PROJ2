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
	private Timer timeClock;
	private int timeAccumulator;
	
	public Extras() {
		extrasLayout = new BorderLayout(15,0);
		
		containerE = getContentPane();
	    containerE.setLayout(extrasLayout);
	    
	    bombs = new JLabel("   Bombs left: " + bombCount);
	    
	    reset = new JButton("RESET");
	    ButtonHandler resetHandler = new ButtonHandler();
	    reset.addActionListener(resetHandler);
	    
	    timer = new JLabel("    Timer: " + timeAccumulator + "            ");
	    
	    containerE.add(bombs,BorderLayout.WEST);
	    containerE.add(reset,BorderLayout.CENTER);
	    containerE.add(timer,BorderLayout.EAST);
	    

	    int delay = 1000;
	    timeClock = new Timer(delay,new TimerHandler() );
	    timeClock.start();
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
	    	
	    }
	}
	
    // inner class for timer event handling
    private class TimerHandler implements ActionListener {
       // handle adding time each second
       public void actionPerformed( ActionEvent event ) {
    	   // very weird but works, change if see fit
    	   timeAccumulator += timeClock.getDelay() / 1000;
    	   timer.setText("    Timer: " + timeAccumulator + "            ");
       }
   } // end private inner class TimerHandler

	
	public Container getContainer() {
		return containerE;
	}
}