package loginassignment.sudoku;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.canvas.GraphicsContext;

public class GameController implements Initializable {

	//fx:id's for buttons
	@FXML Button button_one;
	@FXML Button button_two;
	@FXML Button button_three;
	@FXML Button button_four;
	@FXML Button button_five;
	@FXML Button button_six;
	@FXML Button button_seven;
	@FXML Button button_eight;
	@FXML Button button_nine;
	@FXML Canvas canvas;
	
	// creates instance of the GameBoard class
    GameBoard gameboard;

	// stores value of player's selected column and row
	int player_selected_col;
	int player_selected_row;

	// dimensions of square
	int height = 50;
	int offset = 2;

	// "initialize" method executes immidiately after game.fxml loaded
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// creates instance of the gameboard
		gameboard = new GameBoard();
		
        // gets graphics context from canvas
		GraphicsContext context = canvas.getGraphicsContext2D();
		
        // drawOnCanvas method call
		drawOnCanvas(context);
		
	}

    public void drawOnCanvas(GraphicsContext context) {
        // clears canvas
		context.clearRect(0, 0, 450, 450);

		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				// finds y position of the square
				int posY = row * height + offset;
				
				// finds x position of the square
				int posX = col * height + offset;
				
				// width of the square
				int width = height - (offset * 2);
				
				// set fill color to white
				context.setFill(Color.WHITE);
				
				// draws a rounded rectangle with the calculated position and width
				context.fillRoundRect(posX, posY, width, width, 10, 10);
			}
		}

		// selected square in grid outlined in orange
		context.setStroke(Color.ORANGE);
		
		// stroke width is 4 pixels wide
		context.setLineWidth(4);
		
		context.strokeRoundRect(player_selected_col * height + offset, player_selected_row * height + offset, height - (offset * 2), height - (offset * 2), 10, 10);

		// draws starting puzzle numbers from GameBoard instance
		int[][] puzzle = gameboard.getPuzzle();
		
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
	
				// finds the y position of square
				int posY = row * height + 30;
				
				// finds the x position of square
				int posX = col * height + 20;
				
				// set fill color to black
				context.setFill(Color.BLACK);
				
				// set font
				context.setFont(new Font(20));
				
				// check if value of puzzle array position is not 0 (is not empty)
				if (puzzle[row][col]!= 0) {
					// draw number
					context.fillText(puzzle[row][col] + "", posX, posY);
				}
			}
		}

		// draws players numbers from GameBoard instance
		int[][] player = gameboard.getPlayer();

		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				
				// finds the y position of square
				int posY = row * 50 + 30;

				// finds the x position of square
				int posX = col * 50 + 20;

				// set fill color to sea green
				context.setFill(Color.SEAGREEN);
				
				// set font
				context.setFont(new Font(21));
				
				// check if value of player array position is not 0 (is not empty)
				if(player[row][col]!= 0) {
					// draw number
					context.fillText(player[row][col] + "", posX, posY);
				}
			}
		}

		// if gameboard matches solution
		if(gameboard.checkSolution() == true) {
					
			// clear canvas
			context.clearRect(0, 0, 450, 450);
			// set fill color to green
			context.setFill(Color.LIMEGREEN);
			// set font
			context.setFont(new Font(36));
			// display text for winning
			context.fillText("You Won Super Sudoku!", 25, 250);
		}
	}

	public void canvasMouseClicked() {

		// set EventHandler for mouse clicked event to canvas object
		canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				
				// get mouse position relative to canvas
				int mouseX = (int) event.getX();
				int mouseY = (int) event.getY();

				// convert mouseX and mouseY into rows and cols
				player_selected_row = (int) (mouseY / 50);
				player_selected_col = (int) (mouseX / 50);

				//update graphics context
				drawOnCanvas(canvas.getGraphicsContext2D());
			}
		});
	}

	public void buttonOnePressed() {
		// value corresponding to the button inserted in the player array
		gameboard.modifyPlayer(1, player_selected_row, player_selected_col);
		// update canvas
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonTwoPressed() {
		gameboard.modifyPlayer(2, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());		
	}

	public void buttonThreePressed() {
		gameboard.modifyPlayer(3, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonFourPressed() {
		gameboard.modifyPlayer(4, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonFivePressed() {
		gameboard.modifyPlayer(5, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonSixPressed() {
		gameboard.modifyPlayer(6, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonSevenPressed() {
		gameboard.modifyPlayer(7, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonEightPressed() {
		gameboard.modifyPlayer(8, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonNinePressed() {
		gameboard.modifyPlayer(9, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

}