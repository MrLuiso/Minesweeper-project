import java.util.Random;

public class MineSweeper {

	public int width;
	public int height;
	public int mines;

	public Random randMachine;

	public Square[][] square;
	public int squareArrayWidth;
	public int squareArrayHeight;

	/* Constructor */
	public MineSweeper() {

		// Resources for field initiation
		width = 9;
		height = 9;

		squareArrayWidth = width - 1;
		squareArrayHeight = height - 1;

		mines = 9;

		square = new Square[9][9];

		/*
		 * this loop initializes a new field as the bombs are placed and later
		 * the user plays: these values will change
		 */
		for (int i = 0; i < width; i++) {
			for (int o = 0; o < height; o++) {
				square[i][o] = new Square(i, o);
				System.out.println("initialized square in: " + i + o);
			}
		}

		// Resources for bomb placement
		randMachine = new Random();
		int x, y;
		int cont = 0;

		/*
		 * This loop populates the field with mines If the place on the field
		 * already has a mine: it generates a new position
		 * 
		 * the counter only increments when a new mine has been placed this
		 * makes sure that all the mines have been placed in different positions
		 */
		while (cont < mines) {
			x = randMachine.nextInt(width - 1);
			y = randMachine.nextInt(height - 1);

			if (!square[x][y].getBomb()) {

				square[x][y].placeBomb();
				cont++;

			}
		}

	}// Constructor

	/*
	 * This method places a flag on the position the user selected with a
	 * right-click
	 */
	public void placeFlag(int x, int y) {

		if (square[x][y].getUnclicked()) {
			square[x][y].toggleFlag();
			System.out.println("flag on " + x + " " + y);
			// TODO: add or remove the flag drawing;
		}

	}// placeFlag()

	/*
	 * This method is called whenever the user left-clicks a field position that
	 * is not flagged if the position contains a bomb then the game is over.
	 */
	public void stepInSpace(int x, int y) {

		/* if the user used a flag on that space, ignore the click */
		if (!square[x][y].getFlagged()) {

			if (square[x][y].getBomb()) {
				// User stepped in a mine
				// TODO: add code to finish the game
				System.out.println("game over");

			} else {
				checkAdjacentBombs(square[x][y]);
			}
		}
	}// stepInSpace()

	public void checkAdjacentBombs(Square sq) {
		
		

		System.out.println("woop");
		if (sq.getUnclicked()) {
			
			sq.click();
			
			int x = sq.getXPos();
			int y = sq.getYPos();
			System.out.println("coordenates in loop: " + x + " " + y);
			
			int adjacentBombs = 0;

			int descriptiveXPos = 0;
			int descriptiveYPos = 0;

			int descriptivePos = 0;

			switch (x) {

			case 0:
				// left edge
				descriptiveXPos = 1;
				break;

			case 8:
				// right edge
				descriptiveXPos = 2;
				break;

			default:
				// middle
				descriptiveXPos = 0;
				break;

			}

			switch (y) {

			case 0:
				// top edge
				descriptiveYPos = 1;
				break;

			case 8:
				// bottom edge
				descriptiveYPos = 2;
				break;

			default:
				// middle
				descriptiveYPos = 0;
				break;

			}

			if (descriptiveXPos == 0 && descriptiveYPos == 0) {
				// in middle
				System.out.println("middle");
				if (square[x - 1][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x + 1][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x + 1][y].getBomb()) {
					adjacentBombs++;
				}
				if (square[x + 1][y + 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x][y + 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x - 1][y + 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x - 1][y].getBomb()) {
					adjacentBombs++;
				}
			} else if (descriptiveXPos == 1 && descriptiveYPos == 0) {
				// on left edge
				descriptivePos = 1;
				System.out.println("left edge");
				if (square[x][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x + 1][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x + 1][y].getBomb()) {
					adjacentBombs++;
				}
				if (square[x + 1][y + 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x][y + 1].getBomb()) {
					adjacentBombs++;
				}
			} else if (descriptiveXPos == 2 && descriptiveYPos == 0) {
				// on right edge
				descriptivePos = 2;
				System.out.println("right edge");
				if (square[x - 1][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x][y + 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x - 1][y + 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x - 1][y].getBomb()) {
					adjacentBombs++;
				}
			} else if (descriptiveXPos == 0 && descriptiveYPos == 1) {
				// on top edge
				descriptivePos = 3;
				System.out.println("top edge");
				if (square[x + 1][y].getBomb()) {
					adjacentBombs++;
				}
				if (square[x + 1][y + 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x][y + 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x - 1][y + 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x - 1][y].getBomb()) {
					adjacentBombs++;
				}
			} else if (descriptiveXPos == 0 && descriptiveYPos == 2) {
				// on bottom edge
				descriptivePos = 4;
				System.out.println("bottom edge");
				if (square[x - 1][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x + 1][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x + 1][y].getBomb()) {
					adjacentBombs++;
				}
				if (square[x - 1][y].getBomb()) {
					adjacentBombs++;
				}
			} else if (descriptiveXPos == 1 && descriptiveYPos == 1) {
				// top left corner
				descriptivePos = 5;
				System.out.println("top left corner");
				if (square[x + 1][y].getBomb()) {
					adjacentBombs++;
				}
				if (square[x + 1][y + 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x][y + 1].getBomb()) {
					adjacentBombs++;
				}
			} else if (descriptiveXPos == 2 && descriptiveYPos == 1) {
				// top right corner
				descriptivePos = 6;
				System.out.println("top rigth corner");
				if (square[x][y + 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x - 1][y + 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x - 1][y].getBomb()) {
					adjacentBombs++;
				}
			} else if (descriptiveXPos == 2 && descriptiveYPos == 2) {
				// bottom right corner
				descriptivePos = 7;
				System.out.println("bottom right corner");
				if (square[x - 1][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x - 1][y].getBomb()) {
					adjacentBombs++;
				}
			} else if (descriptiveXPos == 1 && descriptiveYPos == 2) {
				// bottom left corner
				descriptivePos = 8;
				System.out.println("bottom left corner");
				if (square[x][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x + 1][y - 1].getBomb()) {
					adjacentBombs++;
				}
				if (square[x + 1][y].getBomb()) {
					adjacentBombs++;
				}
			}

			if (adjacentBombs == 0) {
				// Recursive Caution
				switch (descriptivePos) {
				case 0:
					// in middle field
					checkAdjacentBombs(square[x - 1][y - 1]);
					checkAdjacentBombs(square[x][y - 1]);
					checkAdjacentBombs(square[x + 1][y - 1]);
					checkAdjacentBombs(square[x + 1][y]);
					checkAdjacentBombs(square[x + 1][y + 1]);
					checkAdjacentBombs(square[x][y + 1]);
					checkAdjacentBombs(square[x - 1][y + 1]);
					checkAdjacentBombs(square[x - 1][y]);

				case 1:
					// on left edge
					checkAdjacentBombs(square[x][y - 1]);
					checkAdjacentBombs(square[x + 1][y - 1]);
					checkAdjacentBombs(square[x + 1][y]);
					checkAdjacentBombs(square[x + 1][y + 1]);
					checkAdjacentBombs(square[x][y + 1]);

				case 2:
					// on right edge
					checkAdjacentBombs(square[x - 1][y - 1]);
					checkAdjacentBombs(square[x][y - 1]);
					checkAdjacentBombs(square[x][y + 1]);
					checkAdjacentBombs(square[x - 1][y + 1]);
					checkAdjacentBombs(square[x - 1][y]);

				case 3:
					// on top edge
					checkAdjacentBombs(square[x - 1][y]);
					checkAdjacentBombs(square[x - 1][y + 1]);
					checkAdjacentBombs(square[x][y + 1]);
					checkAdjacentBombs(square[x + 1][y + 1]);
					checkAdjacentBombs(square[x + 1][y]);

				case 4:
					// on bottom edge
					checkAdjacentBombs(square[x - 1][y - 1]);
					checkAdjacentBombs(square[x][y - 1]);
					checkAdjacentBombs(square[x + 1][y - 1]);
					checkAdjacentBombs(square[x + 1][y]);
					checkAdjacentBombs(square[x - 1][y]);

				case 5:
					// on top left corner
					checkAdjacentBombs(square[x + 1][y]);
					checkAdjacentBombs(square[x + 1][y + 1]);
					checkAdjacentBombs(square[x][y + 1]);

				case 6:
					// on top right corner
					checkAdjacentBombs(square[x - 1][y]);
					checkAdjacentBombs(square[x - 1][y + 1]);
					checkAdjacentBombs(square[x][y + 1]);

				case 7:
					// on bottom right corner
					checkAdjacentBombs(square[x][y - 1]);
					checkAdjacentBombs(square[x - 1][y - 1]);
					checkAdjacentBombs(square[x - 1][y]);

				case 8:

					// on bottom left corner
					checkAdjacentBombs(square[x][y - 1]);
					checkAdjacentBombs(square[x + 1][y - 1]);
					checkAdjacentBombs(square[x + 1][y]);

				}

			} else {
				// Put number in cell
				square[x][y].setAdjacentBombs(adjacentBombs);
				System.out.println("AdjacentBombs = "  + adjacentBombs);
				return;
			}

		}

	}// chackAdjacentBombs

}
