
public class Square {

	private boolean flagged;
	private boolean mined;
	private boolean unclicked;
	
	private int xPos;
	private int yPos;
	
	private int adjacentBombs;
	
	public Square(int x, int y){
		//default constructor;
		flagged = false;
		mined = false;
		unclicked = true;
		
		xPos = x;
		yPos = y;
	}//constructor
	
	////////////////////*Setters*/////////////////////
	public void toggleFlag(){
		if(flagged){
			flagged = false;
		} else{
			flagged = true;
		}
	}//toggleFlag()
	
	public void placeBomb(){
		mined = true;
	}//placeBomb()
	
	public void click(){
		unclicked = false;
	}//click()
	
	public void setAdjacentBombs(int bombs){
		adjacentBombs = bombs;
	}
	
	//////////////////*Getters*////////////////////////
	
	public boolean getBomb(){
		return mined;
	}//getBomb()
	
	public boolean getFlagged(){
		return flagged;
	}//getFlagged()
	
	public int getXPos(){
		return xPos;
	}//getXPos()
	
	public int getYPos(){
		return yPos;
	}//getYPos()
	
	public boolean getUnclicked(){
		return unclicked;
	}//getEmpty
	
	public int getAdjacentBombs(){
		return adjacentBombs;
	}
	
	
}
