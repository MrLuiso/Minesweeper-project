
public class Square {

	private boolean flagged;
	private boolean mined;
	private boolean unclicked;
	
	private int xPos;
	private int yPos;
	
	private int adjacentBombs;
	
	private int color;
	
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
			color = 3; //color to white
		} else{
			flagged = true;
			color = 1; //color to red
		}
	}//toggleFlag()
	
	public void placeBomb(){
		mined = true;
		color = 0; //color to black
	}//placeBomb()
	
	public void click(){
		unclicked = false;
		if(!this.getBomb()){
			color = 2; //color to grey
		}
		
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
	
	public int getColor(){
		return color;
	}
	
	
}
