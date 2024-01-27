package loginassignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import loginassignment.login.Login;
import loginassignment.sudoku.TitleController;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Login.startGUI();
    }

    public static void main(String[] args) {
        launch();
    }

	public void titleGUI(Stage primaryStage) throws Exception {

		// loads title.fxml from sudoku file and assigns it to root object
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sudoku/title.fxml"));
		Parent root = fxmlLoader.load();
		TitleController controller = fxmlLoader.getController();
		controller.setStage(primaryStage);

		// assigns root object to a new scene and sets its dimensions (same from scenebuilder)
		Scene scene = new Scene(root, 720, 480);

		// set window title
		primaryStage.setTitle("SUPER SUDOKU");

		// set scene of window to title scene
		primaryStage.setScene(scene);

		// show window
		primaryStage.show();
	}

    public void gameGUI(Stage primaryStage) throws Exception {

		// loads game.fxml from sudoku file and assigns it to root object
		Parent root = FXMLLoader.load(getClass().getResource("sudoku/game.fxml"));

		// assigns root object to a new scene and sets its dimensions (same from scenebuilder)
		Scene scene = new Scene(root, 720, 480);

		// set window title
		primaryStage.setTitle("SUPER SUDOKU");

		// set scene of window to game scene
		primaryStage.setScene(scene);

		// show window
		primaryStage.show();
	}

}