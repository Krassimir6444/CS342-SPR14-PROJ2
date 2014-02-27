package game_res;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import launcher.Minesweeper;

// implementing just in case
public class Menu extends JFrame {
	
	private Container containerM;
	private JMenuBar menuBar;
	
	public Menu() {
		
		containerM = getContentPane();
		
		JMenu gameMenu = new JMenu("Game");
		gameMenu.setMnemonic('G');
		
	    JMenuItem exitItem = new JMenuItem("eXit");
	    exitItem.setMnemonic('X');
	    gameMenu.add(exitItem);
	    
	    exitItem.addActionListener(
	       new ActionListener() {  // anonymous inner class
	          // terminate application when user clicks exitItem
	          public void actionPerformed(ActionEvent event) {
	             System.exit(2);
	          }
	       }  // end anonymous inner class
	    ); // end call to addActionListener
	    
	    JMenuItem topTenItem = new JMenuItem("Top ten");
	    topTenItem.setMnemonic('T');
	    gameMenu.add(topTenItem);
	    
	    topTenItem.addActionListener(	
	       new ActionListener() {  // anonymous inner class
	 	      // display message dialog when user selects About...
	    	  public void actionPerformed(ActionEvent event) {
	 	    		  
	 	      }
	 	   }  // end anonymous inner class
	 	); // end call to addActionListener
	    
	    JMenuItem resetItem = new JMenuItem("Reset");
	    resetItem.setMnemonic('R');
	    gameMenu.add(resetItem);
	    
	    resetItem.addActionListener(	
	       new ActionListener() {  // anonymous inner class
	 	      // display message dialog when user selects About...
	    	  public void actionPerformed(ActionEvent event) {
	    		  //Minesweeper.restart();
	 	      }
	 	   }  // end anonymous inner class
	 	); // end call to addActionListener
	    
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
	    
		JMenuItem aboutItem = new JMenuItem("About");
	    aboutItem.setMnemonic('A');
	    helpMenu.add(aboutItem);
	    
	    aboutItem.addActionListener(	
	       new ActionListener() {  // anonymous inner class
	          // display message dialog when user selects About...
	    	  public void actionPerformed(ActionEvent event) {
	    		  JOptionPane.showMessageDialog( Menu.this,
	    				  "Developers:\nIan Swift & Krassimir Manolov", 
	    				  "About", JOptionPane.PLAIN_MESSAGE );
	          }
	       }  // end anonymous inner class
	    ); // end call to addActionListener

		JMenuItem helpItem = new JMenuItem("HelP");
	    helpItem.setMnemonic('P');
	    helpMenu.add(helpItem);
	    
	    helpItem.addActionListener(	
	       new ActionListener() {  // anonymous inner class
	          // display message dialog when user selects About...
	    	  public void actionPerformed(ActionEvent event) {
	    		  JOptionPane.showMessageDialog( Menu.this,
	    				  "For information on minesweeper go to\n"
	    				  + "http://en.wikipedia.org/wiki/Minesweeper_%28video_game%29", 
	    				  "About", JOptionPane.PLAIN_MESSAGE );
	          }
	       }  // end anonymous inner class
	    ); // end call to addActionListener
	    
	    
	    // create menu bar and attach it to MenuTest window
	    menuBar = new JMenuBar();  
	    setJMenuBar(menuBar);  
	    menuBar.add(gameMenu); 
	    menuBar.add(helpMenu); 
	    
	    containerM.add(menuBar);
	    //setSize(50,50);
	    //setVisible(true);

	}
	
	public Container getContainer() {
		return containerM;
	}
	
}