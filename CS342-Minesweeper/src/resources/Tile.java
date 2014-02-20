package resources;
import java.awt.*;
import javax.swing.*;

public class Tile extends JButton{

	boolean bomb; 
	char currentState; // ? U X
	
	public static void main(String args[]) {
		Tile thisTile = new Tile();
	}
	
	public Tile() {
		bomb = false;
		currentState = 'U';
		
	}
	
	public void setBomb() {
		this.bomb = true;
	}
	
	public boolean checkForBomb() {
		if(this.bomb == true)
			return true; //send to explode
		else 
			return false;
	}
	
	
}
