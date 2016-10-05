import java.util.Random;

public class MineSweeper {
	
	public int width;
	public int height;
	public int mines;
	
	public Random randMachine;
	
	public boolean[][] field;
	
	public MineSweeper(){
		width = 9;
		height = 9;
		
		mines = 9;
		
		for(int i = 0; i < width; i++){
			for(int o = 0; o < height; o++){
				field[i][o] = false;
			}
		}
		
		randMachine = new Random();
		int x, y;
		int cont = 0;
		
		/*This loop populates the field with mines
		 * If the place on the field already has a mine:
		 * 	it generates a new position
		 * 
		 * the counter only increments when a new mine has been placed
		 * this makes sure that all the mines have been placed in different positions*/
		while(cont < mines){
			x = randMachine.nextInt(width);
			y = randMachine.nextInt(height);
			
			if(!field[x][y]){
				
				field[x][y] = true;
				cont++;
				
			}
		}
		
	}//Constructor

}
