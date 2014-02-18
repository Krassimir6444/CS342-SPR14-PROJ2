// Fig. 13.24: FlowLayoutDemo.java
// Demonstrating FlowLayout alignments.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlowLayoutDemo extends JFrame {
   private JButton leftButton, centerButton, rightButton;
   private Container container;
   private FlowLayout layout;
   
   // set up GUI and register button listeners
   public FlowLayoutDemo()
   {
      super( "FlowLayout Demo" );

      layout = new FlowLayout();

      // get content pane and set its layout
      container = getContentPane();
      container.setLayout( layout );

      // set up leftButton and register listener
      leftButton = new JButton( "Left" );
      container.add( leftButton );
      leftButton.addActionListener(

         new ActionListener() {  // anonymous inner class

            // process leftButton event  
            public void actionPerformed( ActionEvent event )
            {
               layout.setAlignment( FlowLayout.LEFT );

               // realign attached components
               layout.layoutContainer( container );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up centerButton and register listener
      centerButton = new JButton( "Center" );
      container.add( centerButton );
      centerButton.addActionListener(

         new ActionListener() {  // anonymous inner class

            // process centerButton event  
            public void actionPerformed( ActionEvent event )
            {
               layout.setAlignment( FlowLayout.CENTER );

               // realign attached components
               layout.layoutContainer( container );
            }
         }
      );

      // set up rightButton and register listener
      rightButton = new JButton( "Right" );
      container.add( rightButton );
      rightButton.addActionListener(

         new ActionListener() {  // anonymous inner class

            // process rightButton event  
            public void actionPerformed( ActionEvent event )
            {
               layout.setAlignment( FlowLayout.RIGHT );

               // realign attached components
               layout.layoutContainer( container );
            }
         }
      );

      setSize( 300, 75 );
      setVisible( true );

   } // end constructor FlowLayoutDemo
  
   public static void main( String args[] )
   { 
      FlowLayoutDemo application = new FlowLayoutDemo();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // end class FlowLayoutDemo