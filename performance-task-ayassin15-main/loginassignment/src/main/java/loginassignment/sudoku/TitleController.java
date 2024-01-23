package loginassignment.sudoku;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import loginassignment.App;

public class TitleController {
    
    //fx:id's for buttons
    @FXML Button button_start;
    @FXML Canvas canvas;

    private Stage stage;

    @FXML
    public void buttonStartPressed() throws Exception {
        App app = new App();
        app.gameGUI(stage);
	}

    public void setStage(Stage stage) {
        this.stage = stage;
    }
   
}