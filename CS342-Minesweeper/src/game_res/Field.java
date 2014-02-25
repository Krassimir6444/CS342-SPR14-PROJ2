package game_res;

import java.util.*;

public class Field {
	private Tile field[][];
	private int discovered_bombs;

	public Field() {
		field = new Tile[10][10];

		int x, y;
		x = 0;
		while (x < 10) {
			y = 0;
			while (y < 10) {
				field[x][y] = new Tile(x, y);
				y++;
			}
			x++;
		}
	}

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