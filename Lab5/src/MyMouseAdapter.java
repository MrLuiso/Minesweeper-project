import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {

	public MineSweeper myGame = new MineSweeper();

	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1: // Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3: // Right mouse button
			c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			myFrame = (JFrame) c;
			myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			myInsets = myFrame.getInsets();
			x1 = myInsets.left;
			y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			x = e.getX();
			y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		default: // Some other button (2 = Middle mouse button, etc.)
			// Do nothing
			break;
		}
	}

	public void mouseReleased(MouseEvent e) {
		
		Component c = e.getComponent();
		while (!(c instanceof JFrame)) {
			c = c.getParent();
			if (c == null) {
				return;
			}
		}
		JFrame myFrame = (JFrame) c;
		MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0); 
		Insets myInsets = myFrame.getInsets();
		int x1 = myInsets.left;
		int y1 = myInsets.top;
		e.translatePoint(-x1, -y1);
		int x = e.getX();
		int y = e.getY();
		myPanel.x = x;
		myPanel.y = y;
		int gridX = myPanel.getGridX(x, y);
		int gridY = myPanel.getGridY(x, y);
		switch (e.getButton()) {
		case 1: // Left mouse button

			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				// Had pressed outside
				// Do nothing
				// d
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					// Is releasing outside
					// Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						// Released the mouse button on a different cell where
						// it was pressed
						// Do nothing
					} else {
						// Released the mouse button on the same cell where it
						// was pressed
						myGame.stepInSpace(gridX, gridY);
						stateSquare(gridX, gridY, myGame.square[gridX][gridY].getColor(), e);
						stateNumber(gridX, gridY, myGame.square[gridX][gridY].getAdjacentBombs(), e);
						
						if(myGame.checkLose()){
							for(int i = 0; i < 9; i++){
								for(int o = 0; o < 9; o++){
									if(myGame.square[i][o].getBomb()){
										stateSquare(i, o, myGame.square[i][o].getColor(), e);
									}
								}
							}
						}

					}
				}
			}
			myPanel.repaint();
			break;
		case 3: // Right mouse button

			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				// Had pressed outside
				// Do nothing
				// d
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					// Is releasing outside
					// Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						// Released the mouse button on a different cell where
						// it was pressed
						// Do nothing
					} else {
						if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						}
						// Released the mouse button on a different cell where
						// it was pressed
						// Do nothing
						else {

							// Released the mouse button on the same cell where
							// it was pressed

							myGame.placeFlag(gridX, gridY);

							stateSquare(gridX, gridY, myGame.square[gridX][gridY].getColor(), e);

						}
					}
				}
			}
			myPanel.repaint();
			break;

		default: // Some other button (2 = Middle mouse button, etc.)
			// Do nothing
			break;
		}
	}

	public void stateSquare(int x, int y, int color, MouseEvent e) {

		// int Bomb = 0;
		// int Flag = 1;
		// int blank = 2;

		Color newColor = null;

		switch (color) {
		case 0:
			newColor = Color.BLACK;
			break;
		case 1:
			newColor = Color.RED;
			break;
		case 2:
			newColor = Color.lightGray;
			break;

		case 3:
			newColor = Color.WHITE;
			break;
		}

		Component c = e.getComponent();
		while (!(c instanceof JFrame)) {
			c = c.getParent();
			if (c == null) {
				return;
			}
		}
		JFrame myFrame = (JFrame) c;
		MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0); 
		
		for (int i = 0; i < 9; i++) {
			for (int o = 0; o < 9; o++) {

				switch (myGame.square[i][o].getColor()) {
				case 0:
					myPanel.colorArray[i][o] = Color.BLACK;
					break;
				case 1:
					myPanel.colorArray[i][o] = Color.RED;
					break;
				case 2:
					myPanel.colorArray[i][o] = Color.lightGray;
					break;

				case 3:
					myPanel.colorArray[i][o] = Color.WHITE;
					break;
				}

			}
		}

		myPanel.colorArray[x][y] = newColor;
		myPanel.repaint();
	}

	public void stateNumber(int x, int y, int number, MouseEvent e) {


		Component c = e.getComponent();
		while (!(c instanceof JFrame)) {
			c = c.getParent();
			if (c == null) {
				return;
			}
		}
		JFrame myFrame = (JFrame) c;
		MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);

		for(int i = 0; i < 9; i++){
			for(int o = 0; o < 9; o++){
				myPanel.numberArray[i][o] = myGame.square[i][o].getAdjacentBombs();
			}
		}
		myPanel.numberArray[x][y] = number;
		myPanel.repaint();
	}
	

}