package launcher;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import game_res.*;

public class Minesweeper extends JFrame {
	private static final long serialVersionUID = -8691180141632282446L;
	
	private Field field;
	private Menu menu;
	private Extras extras;
	
	private BorderLayout layout;
	private Container mainContainer;
	private State gameState;
	public enum State {Playing, Loss, Won};
	
	public Minesweeper() {
		field = new Field();
		menu = new Menu();
		extras = new Extras();
		
		layout = new BorderLayout(0,0);
		mainContainer = getContentPane();
	    mainContainer.setLayout(layout);
	    
	    mainContainer.add( menu.getContainer(), BorderLayout.NORTH );
	    mainContainer.add( field.getContainer(),  BorderLayout.CENTER );
	    mainContainer.add( extras.getContainer(), BorderLayout.SOUTH);
	    setSize(550,550);
	    setVisible(true);
		
		field.generateUndiscovered();
		field.generateDiscovered();
		
		// reinitialize twice, before and after, to help load the tiles
		field.reinitializeTiles();
		gameState = State.Playing;
		field.reinitializeTiles();
		
		// prevents JFrame from tearing if click on a bomb, moves windows over a bit
		this.setLocation(410,100);
	}
	
	public static void main(String[] args)
	{
		Minesweeper application = new Minesweeper();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	// can't get other classes to call this
	public void restart() {
		this.dispose();
		new Minesweeper();
	}
	
}

	/*
	public void onLeftClick(Tile t)
	{
		if (gameState != State.Playing || t.getMark() == "flagged")
			return;
	
		if (t.checkForBomb() == true) {
			t.open();
			this.gameState = State.Loss;
			return;
		}
		
		field.recursiveOpen(t.getX(), t.getY());
		
		if (field.checkWin())
		{
			this.gameState = State.Won;
		}
	}
	
	public void onRightClick(Tile t)
	{
		if (gameState != State.Playing)
			return;
		if (t.checkOpen() == true)
			return;
		t.changeMark();
	}
	
	public State getState()
	{
		return this.gameState;
	}
	*/

