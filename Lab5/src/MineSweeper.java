import java.util.Random;

public class MineSweeper {
	
	public int width;
	public int height;
	public int mines;
	
	public Random randMachine;
	
	public Square[][] square;
	
	/*Constructor*/ 
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
		
		if(square[x][y].getUnclicked()){
			square[x][y].toggleFlag();
			//TODO: add or remove the flag drawing;
		}
		
	}//placeFlag()
	
	
	/*This method is called whenever
	 * the user left-clicks a field position that is not flagged
	 * if the position contains a bomb then the game is over.*/
	public void stepInSpace(int x, int y){
		
		square[x][y].click();
		
		/*if the user used a flag on that space, ignore the click*/
		if(!square[x][y].getFlagged()){
			
			if(square[x][y].getBomb()){
				//User stepped in a mine
				//TODO: add code to finish the game
				
			} else{
				checkAdjacentBombs(square[x][y]);
			}	
		} 
	}//stepInSpace()
	
	public void checkAdjacentBombs(Square sq){
		
		int x = sq.getXPos();
		int y = sq.getYPos();
		
		int descriptivePos = 0;
		
		int adjacentBombs = 0;
		
		if(x > 0 && x < this.width && y > 0 && y < this.height){
			if(square[x - 1][y - 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x][y -1].getBomb()){
				adjacentBombs++;
			}
			if(square[x + 1][y - 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x + 1][y].getBomb()){
				adjacentBombs++;
			}
			if(square[x + 1][y + 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x][y + 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x - 1][y + 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x - 1][y].getBomb()){
				adjacentBombs++;
			}
		} else if(x == 0 && y > 0 && y < this.height){
			//on left edge = 1
			descriptivePos = 1;
			
			if(square[x][y -1].getBomb()){
				adjacentBombs++;
			}
			if(square[x + 1][y - 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x + 1][y].getBomb()){
				adjacentBombs++;
			}
			if(square[x + 1][y + 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x][y + 1].getBomb()){
				adjacentBombs++;
			}
		} else if(x == 9 && y > 0 && y < 9){
			//on right edge = 2
			descriptivePos = 2;
			
			if(square[x - 1][y - 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x][y -1].getBomb()){
				adjacentBombs++;
			}
			if(square[x][y + 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x - 1][y + 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x - 1][y].getBomb()){
				adjacentBombs++;
			}
		} else if(x > 0 && x < 9 && y == 0){
			//on top edge = 3
			descriptivePos = 3;
			
			if(square[x + 1][y].getBomb()){
				adjacentBombs++;
			}
			if(square[x + 1][y + 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x][y + 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x - 1][y + 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x - 1][y].getBomb()){
				adjacentBombs++;
			}
		} else if(x > 0 && x < 9 && y == 9){
			//on bottom edge = 4
			descriptivePos = 4;
			
			if(square[x - 1][y - 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x][y -1].getBomb()){
				adjacentBombs++;
			}
			if(square[x + 1][y - 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x + 1][y].getBomb()){
				adjacentBombs++;
			}
			if(square[x - 1][y].getBomb()){
				adjacentBombs++;
			}
		} else if(x == 0 && y == 0){
			//on left top corner = 5
			descriptivePos = 5;
			
			if(square[x + 1][y].getBomb()){
				adjacentBombs++;
			}
			if(square[x + 1][y + 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x][y + 1].getBomb()){
				adjacentBombs++;
			}
		} else if(x == 9 && y == 9){
			//on bottom right corner = 6
			descriptivePos = 6;
			
			if(square[x - 1][y - 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x][y -1].getBomb()){
				adjacentBombs++;
			}
			if(square[x - 1][y].getBomb()){
				adjacentBombs++;
			}
		} else if(x == 0 && y == 9){
			//on bottom left corner = 7
			descriptivePos = 7;
			
			if(square[x][y -1].getBomb()){
				adjacentBombs++;
			}
			if(square[x + 1][y - 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x + 1][y].getBomb()){
				adjacentBombs++;
			}
		} else if(x == 9 && y == 0){
			//on top right corner = 8
			descriptivePos = 8;
			
			if(square[x][y + 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x - 1][y + 1].getBomb()){
				adjacentBombs++;
			}
			if(square[x - 1][y].getBomb()){
				adjacentBombs++;
			}
		}
		
		
		
		
		if(adjacentBombs == 0){
			//emptySquare
			switch(descriptivePos){
			case 0:
				//in middle field
				checkAdjacentBombs(square[x - 1][y - 1]);
				checkAdjacentBombs(square[x][y - 1]);
				checkAdjacentBombs(square[x + 1][y - 1]);
				checkAdjacentBombs(square[x + 1][y]);
				checkAdjacentBombs(square[x + 1][y + 1]);
				checkAdjacentBombs(square[x][y + 1]);
				checkAdjacentBombs(square[x - 1][y + 1]);
				checkAdjacentBombs(square[x - 1][y]);
				
			case 1:
				//on left edge
				checkAdjacentBombs(square[x][y - 1]);
				checkAdjacentBombs(square[x + 1][y - 1]);
				checkAdjacentBombs(square[x + 1][y]);
				checkAdjacentBombs(square[x + 1][y + 1]);
				checkAdjacentBombs(square[x][y + 1]);
				
			case 2:
				//on right edge
				checkAdjacentBombs(square[x - 1][y - 1]);
				checkAdjacentBombs(square[x][y - 1]);
				checkAdjacentBombs(square[x][y + 1]);
				checkAdjacentBombs(square[x - 1][y + 1]);
				checkAdjacentBombs(square[x - 1][y]);
				
			case 3:
				//on top edge
				checkAdjacentBombs(square[x - 1][y]);
				checkAdjacentBombs(square[x - 1][y + 1]);
				checkAdjacentBombs(square[x][y + 1]);
				checkAdjacentBombs(square[x + 1][y + 1]);
				checkAdjacentBombs(square[x + 1][y]);
				
			case 4:
				//on bottom edge
				checkAdjacentBombs(square[x - 1][y - 1]);
				checkAdjacentBombs(square[x][y - 1]);
				checkAdjacentBombs(square[x + 1][y - 1]);
				checkAdjacentBombs(square[x + 1][y]);
				checkAdjacentBombs(square[x - 1][y]);
			
			case 5:
				//on left top corner
				checkAdjacentBombs(square[x + 1][y]);
				checkAdjacentBombs(square[x + 1][y + 1]);
				checkAdjacentBombs(square[x][y + 1]);
				
			case 6:
				//on bottom right corner
				checkAdjacentBombs(square[x][y - 1]);
				checkAdjacentBombs(square[x - 1][y - 1]);
				checkAdjacentBombs(square[x - 1][y]);
			
			case 7:
				//on bottom left corner
				checkAdjacentBombs(square[x][y - 1]);
				checkAdjacentBombs(square[x + 1][y - 1]);
				checkAdjacentBombs(square[x + 1][y]);
				
			case 8:
				//on top right corner
				checkAdjacentBombs(square[x - 1][y]);
				checkAdjacentBombs(square[x - 1][y + 1]);
				checkAdjacentBombs(square[x][y + 1]);
				
				
			}
			
		} else{
			//TODO: add the number to the square
			return;
		}
		
	}//chackAdjacentBombs

}
