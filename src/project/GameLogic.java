package project;

import javax.swing.JButton;

/*TO DO: HORIZANTAL AND VERTICAL CHECK.WHEN EVERYTHING IS FINISHED REFACTOR THE CODE TO MAKE IT MORE DYNAMIC*/
public class GameLogic {
	private final int ROW=6;
	private final int COL=7;
	private int connectX;

	public GameLogic(int x) {
		this.connectX = x;
	}

	public void connectX(int x) throws Exception {
		if(x<2 || x>7){
			throw new Exception("Invalid Number");
			
		}else{
		this.connectX = x;
		}

	}

	public boolean diagonalUp(String currentPlayer, JButton[][] arr) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 4; col++) {
				if (arr[row][col].getText().equalsIgnoreCase(currentPlayer)
						
						&& arr[row + 1][col + 1].getText().equalsIgnoreCase(currentPlayer)
						&& arr[row + 2][col + 2].getText().equalsIgnoreCase(currentPlayer)
						&& arr[row + 3][col + 3].getText().equalsIgnoreCase(currentPlayer)) {
					return true;
				}

			}
			}
			return false;
	}

	public boolean diagonalDown(String currentPlayer, JButton[][] arr) {
		for (int row = 0; row < 3; row++) {
			for (int col = arr[row].length - 1; col >= 3; col--) {
				if (arr[row][col].getText().equalsIgnoreCase(currentPlayer)
						&& arr[row + 1][col - 1].getText().equalsIgnoreCase(currentPlayer)
						&& arr[row + 2][col - 2].getText().equalsIgnoreCase(currentPlayer)
						&& arr[row + 3][col - 3].getText().equalsIgnoreCase(currentPlayer)) {
					return true;
				}

			}
		}
		return false;

	}

	public boolean vertical(String currentPlayer, JButton[][] arr) {
		// for each col loop throw rowS
		for (int col = 0; col < COL; col++) {
			// loop all the rows on the each col
			int count = 0;
			for (int row = 0; row < ROW; row++) {
				if (arr[row][col].getText().equalsIgnoreCase(currentPlayer)) {
					count++;
				} else {
					count = 0;
				}
				if (count == connectX) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean horizontal(String currentPlayer, JButton[][] arr) {
		for (int row = 0; row < 6; row++) {
			int count = 0;
			for (int col = 0; col < COL; col++) {
				if (arr[row][col].getText().equalsIgnoreCase(currentPlayer)) {
					count++;
				} else {
					count = 0;
				}
				if (count == connectX) {
					return true;
				}
			}

		}
		return false;

	}

	@Override
	public String toString() {
		return "GameLogic [connectX=" + connectX + "]";
	}
	

}
