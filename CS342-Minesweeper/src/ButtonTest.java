// Fig. 13.10: ButtonTest.java
// Creating JButtons.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonTest extends JFrame {
   private JButton plainButton, fancyButton;
   
   public static void main( String args[] )
   { 
      ButtonTest application = new ButtonTest();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

   // set up GUI
   public ButtonTest()
   {
      super( "Testing Buttons" );

      // get content pane and set its layout
      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      // create buttons
      plainButton = new JButton( "Plain Button" );
      container.add( plainButton );

      Icon bug1 = new ImageIcon( "bug1.gif" );
      Icon bug2 = new ImageIcon( "bug2.gif" );
      fancyButton = new JButton( "Fancy Button", bug1 );
      fancyButton.setRolloverIcon( bug2 );
      container.add( fancyButton );

      // create an instance of inner class ButtonHandler
      // to use for button event handling 
      ButtonHandler handler = new ButtonHandler();
      fancyButton.addMouseListener( handler );
      plainButton.addMouseListener( handler );

      setSize( 275, 100 );
      setVisible( true );

   } // end ButtonTest constructor



   // inner class for button event handling
   private class ButtonHandler implements MouseListener {

      // handle button event
      public void mouseClicked (MouseEvent event )
      {
    	 if (SwingUtilities.isRightMouseButton(event)) {
    		 JOptionPane.showMessageDialog( ButtonTest.this,
    		            "You pressed right mouse" );
	 
    	 }
      }
      public void mouseEntered(MouseEvent event)
      {
      }
      public void mouseExited(MouseEvent event)
      {
      }
      public void mouseReleased(MouseEvent event)
      {
      }
      public void mousePressed(MouseEvent event)
      {
      }
  }

} // end private inner class ButtonHandler
 // end class ButtonTest