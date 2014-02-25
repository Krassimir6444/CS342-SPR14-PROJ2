package game_res;

import java.awt.*;
import javax.swing.*;

public class Tile extends JButton {

	private boolean bomb;

	public enum OpenState {
		unopened, opened
	};

	public enum MarkState {
		unmarked, flagged, questioned
	};

	private OpenState openState;
	private MarkState markState;
	private int x;
	private int y;
	private int value;

	public Tile(int _x, int _y) {
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
		if (this.markState == MarkState.unmarked)
			this.markState = MarkState.flagged;
		else if (this.markState == MarkState.flagged)
			this.markState = MarkState.questioned;
		else if (this.markState == MarkState.questioned)
			this.markState = MarkState.unmarked;
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
