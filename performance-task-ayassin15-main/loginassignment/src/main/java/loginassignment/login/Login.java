package loginassignment.login;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import loginassignment.App;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class Login {
    private static Scene scene;
    private static GridPane layout;

    public static void startGUI() {
        
        Stage stage = new Stage();
        layout = new GridPane();
        scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
    
        Scene scene = new Scene(grid, 400, 375);
    
        Label title = new Label("Player Log In");
        title.setFont(Font.font("Tahoma", 20));
        grid.add(title, 0, 0, 2, 1);
    
        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 1);
    
        TextField usernameField = new TextField();
        grid.add(usernameField, 1, 1);
    
        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);
    
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);

        Button signUpButton = new Button("Sign Up");
        grid.add(signUpButton, 1, 3);
        signUpButton.setOnAction(e -> {
            Signup.startSignUp();
        });

        Button logInButton = new Button("Log In");
        grid.add(logInButton, 0, 3);
        logInButton.setOnAction(e -> {
            
            if (usernameField.getLength() > 0) {
                if (ReadFile.isUsername(usernameField.getText())) {
                    if (ReadFile.passwordMatch(usernameField.getText(), passwordField.getText())) {
                        AlertBox.display("Logged In", "Successfully Logged In", "Close");
                        stage.close();
                        
                        App app = new App();
                        try {
                            app.titleGUI(stage);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                    } else {
                        AlertBox.display("Password Error", "Incorrect Password", "Close");
                    }
                } else {
                    AlertBox.display("Username Error", "Username Not Found", "Close");
                }
            } else {
                AlertBox.display("Missing Information", "Ensure all fields are filled in", "Close");
            }

        });
    
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> stage.close());
    
        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        // buttons.getChildren().addAll(signUpButton, cancelButton);
        grid.add(buttons, 0, 5, 2, 1);
    
        stage.setScene(scene);
        stage.setTitle("Super Sudoku - Log In");
        stage.show();

    }

}
