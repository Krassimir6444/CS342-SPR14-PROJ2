package resources;

public class Minesweeper {

	private Field field;
	public enum State {Playing, Loss, Won};
	private State gameState;
	
	public Minesweeper() {
		field = new Field();
		field.generateUndiscovered();
		field.generateDiscovered();
		gameState = State.Playing;
		
	}
	public void onLeftClick(Tile t)
	{
		if (gameState != State.Playing || t.getMark() == Tile.MarkState.flagged)
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
	
	public static void main()
	{
		Minesweeper game = new Minesweeper();
	}
	
	public State getState()
	{
		return this.gameState;
	}
}
