
public class Square {

	private boolean flagged;
	private boolean mined;
	private boolean unclicked;
	private boolean checked;
	
	private int xPos;
	private int yPos;
	
	private int adjacentBombs;
	
	private int color;
	
	public Square(int x, int y){
		//default constructor;
		flagged = false;
		mined = false;
		unclicked = true;
		checked = true;
		adjacentBombs = 0;
		
		color = 3;
		
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
		
	}//placeBomb()
	
	public void click(){
		unclicked = false;
		if(!this.getBomb()){
			color = 2; //color to grey
		} else{
			color = 0;
		}
		
	}//click()
	
	public void check(){
		checked = false;
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
	
	public boolean getUnchecked(){
		return checked;
	}
	
	public int getAdjacentBombs(){
		return adjacentBombs;
	}
	
	public int getColor(){
		return color;
	}
	
	
}
