package launcher;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JFrame;

import game_res.*;

public class Minesweeper extends JFrame {
	private static final long serialVersionUID = -8691180141632282446L;
	
	private Field field;
	private Menu menu;
	private BorderLayout layout;
	private Container mainContainer;
	private State gameState;
	public enum State {Playing, Loss, Won};
	private int xPos, yPos;
	
	public Minesweeper() {
		field = new Field();
		menu = new Menu();
		layout = new BorderLayout(0,0);
		mainContainer = getContentPane();
	    mainContainer.setLayout(layout);
	    
	    mainContainer.add( menu.getContainer(), BorderLayout.NORTH );
	    mainContainer.add( field.getContainer(),  BorderLayout.CENTER );
	    setSize(550,550);
	    setVisible(true);
		
		field.generateUndiscovered();
		field.generateDiscovered();
		gameState = State.Playing;
	}
	
	public static void main(String[] args)
	{
		Minesweeper application = new Minesweeper();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
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

}
