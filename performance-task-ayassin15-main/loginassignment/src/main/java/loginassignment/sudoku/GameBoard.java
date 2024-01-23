package loginassignment.sudoku;

public class GameBoard {

	// solution 2d array containing the solution to the sudoku puzzle
	private int[][] solution;

	// puzzle 2d array containing the sudoku puzzle
	private int[][] puzzle;

	// player 2d array containing player's numbers 
	private int[][] player;

	public GameBoard() {
		
		// solution to 9x9 sudoku puzzle
        solution = new int[][]
		{
			{9,5,7,6,1,3,2,8,4},
			{4,8,3,2,5,7,1,9,6},
			{6,1,2,8,4,9,5,3,7},
			{1,7,8,3,6,4,9,5,2},
			{5,2,4,9,7,1,3,6,8},
			{3,6,9,5,2,8,7,4,1},
			{8,4,5,7,9,2,6,1,3},
			{2,9,1,4,3,6,8,7,5},
			{7,3,6,1,8,5,4,2,9}
		};

		// zeroes rendered as empty spaces and can be edited by the player
		puzzle = new int[][]
		{
			{0,0,0,0,0,0,2,0,0},
			{0,8,0,0,0,7,0,9,0},
			{6,0,2,0,0,0,5,0,0},
			{0,7,0,0,6,0,0,0,0},
			{0,0,0,9,0,1,0,0,0},
			{0,0,0,0,2,0,0,4,0},
			{0,0,5,0,0,0,6,0,3},
			{0,9,0,4,0,0,0,7,0},
			{0,0,6,0,0,0,0,0,0}
		};

		// player's array initialized as 9x9 full of zeroes
		player = new int[9][9];
	}

	// returns solution 2d array
	public int[][] getSolution() {
		return solution;
	}

	// returns puzzle 2d array
	public int[][] getPuzzle() {
		return puzzle;
	}

	// returns player 2d array
	public int[][] getPlayer() {
		return player;
	}

	// changes a value in the player array
	public void modifyPlayer(int val, int row, int col) {
        // if square in puzzle 2d array contains a zero (empty square)
		if (puzzle[row][col] == 0) {

			// only values from 0 to 9 (inclusive) are valid
			if (val >= 0 && val <= 9) {
				// assign value to position in player 2d array
				player[row][col] = val;
			} else {
				System.out.println("Value passed to player out of range");
			}
		}
	}

	//checks if player 2d array matches solution 2d array
	public boolean checkSolution() {
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) { 
				
				// if value in puzzle 2d array is zero, player still needs to input a value in square
				if(puzzle[row][col] == 0) {
					
					// check if player value matches solution value
					if(player[row][col] != solution[row][col]) {
						
						// return false if it doesn't
						return false;
					}
				}
			}
		}
		// return true if it does
		return true;
	}

}