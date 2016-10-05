import java.util.Random;

public class MineSweeper {
	
	public int width;
	public int height;
	public int mines;
	
	public Random randMachine;
	
	public Square[][] square;
	
	
	public MineSweeper(){
		
		//Resources for field initiation
		width = 9;
		height = 9;
		
		mines = 9;
		
		/*this loop initializes a new field
		 * as the bombs are placed and later the user plays:
		 * these values will change*/
		for(int i = 0; i < width; i++){
			for(int o = 0; o < height; o++){
				square[i][o] = new Square(i, o);
			}
		}
		
		
		//Resources for bomb placement
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
			
			if(!square[x][y].getBomb()){
				
				square[x][y].placeBomb();
				cont++;
				
			}
		}
		
	}//Constructor
	
	
	/*This method places a flag
	 *  on the position the user selected
	 *   with a right-click */
	public void placeFlag(int x, int y){
		
		//TODO: add the or remove the flag drawing;
		
		if(square[x][y].getUnclicked()){
			square[x][y].toggleFlag();
		}
		
	}//placeFlag()
	
	
	/*This method is called whenever
	 * the user left-clicks a field position that is not flagged
	 * if the position contains a bomb then the game is over.*/
	public void stepInSpace(int x, int y){
		
		square[x][y].click();
		
		if(!square[x][y].getFlagged() && square[x][y].getBomb()){
			//User stepped in a mine
			//TODO: add code to finish the game
		} else{
			checkAdjacentBombs(square[x][y]);
		}
	}//stepInSpace()
	
	public void checkAdjacentBombs(Square sq){
		
	}//chackAdjacentBombs

}
