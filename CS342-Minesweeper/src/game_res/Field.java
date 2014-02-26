package game_res;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// implementing just in case
public class Field extends JFrame {
	private Tile field[][];
	private int discovered_bombs;
	private Container container;
	private GridLayout gridField;
	public int x, y;

	public Field() {
		super("Minesweeper");
		
		// setup layout
		gridField = new GridLayout(10,10);
		
		// get content pane and set its layout
	    container = getContentPane();
	    container.setLayout(gridField);
	    
	    TileHandler handler = new TileHandler();
		
	    
		field = new Tile[10][10];
		for(x=0; x<10; x++) {
		   	for(y=0; y<10; y++) {
			   	field[x][y] = new Tile(x,y);
				field[x][y].addMouseListener(handler);
		        container.add(field[x][y]);
		        //container.show(false);
			}
		}
		setSize(500,500);
	    setVisible(true);
	}
	
	// inner class for tile event handling
	private class TileHandler implements MouseListener {

        // handle tile click event
        public void mouseClicked(MouseEvent event) {
        	
        	Tile tempField = (Tile) event.getSource();
        	//int xPos = tempField.getX();
        	//int yPos = tempField.getY();
        	
        	// left button
        	if(event.getButton() == MouseEvent.BUTTON1) {
        		// if tile was not previously opened...
        		if(!tempField.checkOpen()) {
        			// and the tile is not flagged or questioned...
        			if( tempField.getMark() == "unmarked") {
        				// the tile contained a hidden bomb
        				if( tempField.checkForBomb() == true) {
        					// TODO: eventually change the icon of all tiles with bombs to exploded bombs
        					// and end game.
        					container.validate();
        					System.out.println("Bomb...end game");
        				}
        				// the tile was clear, expand neighboring tiles
        				else {
        					// TODO: implement the recursive open method, and (maybe included in method?)
        					// display the neighboring bombs
        				}
        			}
        		}
        	}
        	
        	// middle button click
        	if(event.getButton() == MouseEvent.BUTTON2) {
        		// not used in minesweeper?
        	}
        	
        	// right button click
        	if(event.getButton() == MouseEvent.BUTTON3) {	
        		// if tile was not previously opened
        		if(!tempField.checkOpen()) {
        		   // toggle the tiles mark	
        		   tempField.changeMark();
        		   container.validate();
        	    }
        	}
        }

		public void mouseEntered(MouseEvent arg0) {
			// TODO highlight the tile
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO un-highlight the tile
		}

		public void mousePressed(MouseEvent arg0) {
			// not used in minesweeper	
		}

		public void mouseReleased(MouseEvent arg0) {
			// not used in minesweeper	
		}
		
	} // end private inner class TileHandler
	
	public void generateUndiscovered() {

		Random rand = new Random();

		int x, y;
		int bomb_count = 0;
		while (bomb_count < 10) {
			x = Math.abs(rand.nextInt() % 10);
			y = Math.abs(rand.nextInt() % 10);
			while (field[x][y].checkForBomb() == true) {
				x = Math.abs(rand.nextInt() % 10);
				y = Math.abs(rand.nextInt() % 10);
			}

			field[x][y].setBomb();
			bomb_count++;
			// System.out.print(x + ", " + y + "\n");
		}
	}

	private int neighborHasBomb(int neighbor_x, int neighbor_y) {
		// checks a neighboring square for a bomb. If it doesn't have a bomb or
		// doesn't exist
		// it returns 0. Otherwise it returns 1
		if (neighbor_x < 0 || neighbor_x > 9 || neighbor_y < 0
				|| neighbor_y > 9)
			return 0;
		if (field[neighbor_x][neighbor_y].checkForBomb())
			return 1;
		return 0;
	}

	public void generateDiscovered() {
		int x, y;
		x = 0;
		while (x < 10) {
			y = 0;
			while (y < 10) {
				if (!field[x][y].checkForBomb()) {
					field[x][y].setValue(0 + neighborHasBomb(x - 1, y - 1)
							+ neighborHasBomb(x - 1, y)
							+ neighborHasBomb(x - 1, y + 1)
							+ neighborHasBomb(x, y - 1)
							+ neighborHasBomb(x, y + 1)
							+ neighborHasBomb(x + 1, y - 1)
							+ neighborHasBomb(x + 1, y)
							+ neighborHasBomb(x + 1, y + 1));
				}
				y++;
			}
			x++;
		}
	}

	public void recursiveOpen(int x, int y) {
		if (x < 0 || x > 9 || y < 0 || y > 9 || field[x][y].checkOpen())
			return;
		field[x][y].open();
		if (field[x][y].getVal() == 0) {
			recursiveOpen(x - 1, y - 1);
			recursiveOpen(x - 1, y);
			recursiveOpen(x - 1, y + 1);
			recursiveOpen(x, y - 1);
			recursiveOpen(x, y + 1);
			recursiveOpen(x + 1, y - 1);
			recursiveOpen(x + 1, y);
			recursiveOpen(x + 1, y + 1);
		}
		return;
	}

	public boolean checkWin() {
		int x, y;
		x = 0;
		while (x < 10) {
			y = 0;
			while (y < 10) {
				if (!field[x][y].checkForBomb() && !field[x][y].checkOpen())
					return false;
				y++;
			}
			x++;
		}
		return true;
	}
	
}
