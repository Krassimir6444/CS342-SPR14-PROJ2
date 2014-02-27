package game_res;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import example_res.MenuTest;

// implementing just in case
public class Menu extends JFrame {
	private JLabel displayLabel;
	
	public Menu(Container container) {
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		
		JMenuItem aboutItem = new JMenuItem("About");
	    aboutItem.setMnemonic('A');
	    fileMenu.add(aboutItem);
	    
	    aboutItem.addActionListener(	
	       new ActionListener() {  // anonymous inner class
	          // display message dialog when user selects About...
	    	  public void actionPerformed(ActionEvent event) {
	    		  JOptionPane.showMessageDialog( Menu.this,
	    				  "Goto: http://en.wikipedia.org/wiki/Minesweeper_%28video_game%29", 
	    				  "About", JOptionPane.PLAIN_MESSAGE );
	          }
	       }  // end anonymous inner class
	    ); // end call to addActionListener
	    
	    JMenuItem exitItem = new JMenuItem("Exit");
	    exitItem.setMnemonic('X');
	    fileMenu.add(exitItem);
	    
	    exitItem.addActionListener(
	       new ActionListener() {  // anonymous inner class
	          // terminate application when user clicks exitItem
	          public void actionPerformed(ActionEvent event) {
	             System.exit(2);
	          }
	       }  // end anonymous inner class
	    ); // end call to addActionListener
	    
	    // create menu bar and attach it to MenuTest window
	    JMenuBar menuBar = new JMenuBar();  
	    setJMenuBar(menuBar);  
	    menuBar.add(fileMenu); 
	    
	    /*
	    // set up label to display text
	    displayLabel = new JLabel("Menu",SwingConstants.CENTER );
	    displayLabel.setForeground(Color.black);
	    displayLabel.setFont(new Font("Serif",Font.PLAIN, 72) );

	    getContentPane().setBackground(Color.CYAN);
	    getContentPane().add(displayLabel,BorderLayout.CENTER);

	    setSize(500,200);
	    setVisible(true);
	    */

	    setSize(500,100);
	    setVisible(false);

	}
	
}