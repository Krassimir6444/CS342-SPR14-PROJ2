package resources;
import java.util.*;

public class Field {
	private int undiscovered[][];
	
	
	public Field(){
		undiscovered = new int[10][10];
	}
	
	private void generate_undiscovered()
	{
		int x, y;
		x = 0;
		while (x < 10){
			y = 0;
			while (y < 10) {
				undiscovered[x][y] = 0;
				y++;
			}
			x++;
		}
		
		Random rand = new Random();
		
		int bomb_count = 0;
		while (bomb_count < 10)
		{
			x = Math.abs(rand.nextInt() % 10);
			y = Math.abs(rand.nextInt() % 10);
			while (undiscovered[x][y] == 1)
			{
				x = Math.abs(rand.nextInt() % 10);
				y = Math.abs(rand.nextInt() % 10);
			}
			
			undiscovered[x][y] = 1;
			bomb_count++;
			//System.out.print(x + ", " + y + "\n");
		}
	}
}