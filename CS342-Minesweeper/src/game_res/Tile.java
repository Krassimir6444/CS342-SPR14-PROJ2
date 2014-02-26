package game_res;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Tile extends JButton {
	private boolean bomb;
	public enum OpenState { unopened, opened };
    public enum MarkState { unmarked, flagged, questioned };
	private OpenState openState;
	private MarkState markState;
	private int x,y;
	private int value;
	
	public Tile(int _x, int _y) {
		super();
		try {
		    Image icon = ImageIO.read(getClass().getResource("unmarked.gif"));
		    this.setIcon(new ImageIcon(icon));
		  } catch (IOException ex) { }
		
		bomb = false;
		openState = OpenState.unopened;
		markState = MarkState.unmarked;
		x = _x;
		y = _y;
	}
	
	public void setBomb() {
		this.bomb = true;
	}

	public MarkState getMark() {
		return markState;
	}

	public void changeMark() {
		if (this.markState == MarkState.unmarked) {
			this.markState = MarkState.flagged;
			try {
			    Image icon = ImageIO.read(getClass().getResource("flagged.gif"));
			    this.setIcon(new ImageIcon(icon));
			  } catch (IOException ex) { }
		}
		else if (this.markState == MarkState.flagged) {
			this.markState = MarkState.questioned;
			try {
			    Image icon = ImageIO.read(getClass().getResource("questioned.gif"));
			    this.setIcon(new ImageIcon(icon));
			  } catch (IOException ex) { }
		}
		else if (this.markState == MarkState.questioned) {
			this.markState = MarkState.unmarked;
			try {
			    Image icon = ImageIO.read(getClass().getResource("unmarked.gif"));
			    this.setIcon(new ImageIcon(icon));
			  } catch (IOException ex) { }
		}
	}

	public void setValue(int _value) {
		value = _value;
	}

	public boolean checkForBomb() {
		if (this.bomb == true)
			return true; // send to explode
		else
			return false;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void open() {
		this.openState = OpenState.opened;
	}

	public boolean checkOpen() {
		if (this.openState == OpenState.opened) {
			return true;
		}
		return false;
	}

	public int getVal() {
		return this.value;
	}
}
