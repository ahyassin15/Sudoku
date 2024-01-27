package loginassignment.login;


import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class Signup {
    
    private static Scene scene;
    private static GridPane layout;

    public static void startSignUp() {

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
    
        Label title = new Label("Player Sign Up");
        title.setFont(Font.font("Tahoma", 20));
        grid.add(title, 0, 0, 2, 1);
    
        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 1);
    
        TextField usernameField = new TextField();
        grid.add(usernameField, 1, 1);
    
        Label emailLabel = new Label("Email:");
        grid.add(emailLabel, 0, 2);
    
        TextField emailField = new TextField();
        grid.add(emailField, 1, 2);
    
        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 3);
    
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 3);
    
        Label confirmPasswordLabel = new Label("Confirm Password:");
        grid.add(confirmPasswordLabel, 0, 4);
    
        PasswordField confirmPasswordField = new PasswordField();
        grid.add(confirmPasswordField, 1, 4);
    
        Button signUpButton = new Button("Sign Up");
        signUpButton.setOnAction(e -> {
            if (isUsernameValid(usernameField.getText())) {
                if (isEmailValid(emailField.getText())) {
                    if (isPasswordValid(passwordField.getText())) {
                        if (passwordField.getText().equals(confirmPasswordField.getText())) {
                            
                            AlertBox.display("Success","New user has been created!", "Close");
            
                            String[] info = {emailField.getText(), usernameField.getText(), passwordField.getText()};
                            WriteFile.write(info);
            
                        } else {
            
                            AlertBox.display("Error","Passwords don't match. Please try again.","Close");
                
                        }
                    }
                }
            }

        });
    
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> stage.close());
    
        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(signUpButton, cancelButton);
        grid.add(buttons, 0, 5, 2, 1);
    
        stage.setScene(scene);
        stage.setTitle("Super Sudoku - Sign Up");
        stage.show();

    }

    public static boolean isPasswordValid(String password) {
        
        boolean hasDigit = false;
        boolean hasUppercase = false;
        boolean hasSpecial = false;
        
        if (password.length() < 6) {
            AlertBox.display("Password Error", "Password is too short (should be 6-10 charracters long).", "Close");
            return false;
        }
        if (password.length() > 10) {
            AlertBox.display("Password Error", "Password is too long (should be 6-10 charracters long).", "Close");
            return false;
        }
        if (password.contains(" ") || password.contains(",")) {
            AlertBox.display("Password Error", "Password cannot contain a space or comma.", "Close");
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            
            Character c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }
            if (!Character.isDigit(c) && !Character.isLetter(c) && !Character.isWhitespace(c)) {
                hasSpecial = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        if (!hasUppercase) {
            AlertBox.display("Password Error", "Password requires at least one uppercase letter", "Close");
            return false;
        }
        if (!hasSpecial) {
            AlertBox.display("Password Error", "Password requires at least one special character", "Close");
            return false;
        }
        if (!hasDigit) {
            AlertBox.display("Password Error", "Password requires at least one number", "Close");
            return false;
        }
        return true;
    }

    public static boolean isUsernameValid(String username) {
        
        if (username.length() < 6) {
            AlertBox.display("Username Error","Username too short (should be 6-10 charracters long).","Close");
            return false;
        }
        if (username.length() > 10) {
            AlertBox.display("Username Error","Username too long (should be 6-10 charracters long).","Close");
            return false;
        }
        if (ReadFile.isUsername(username)) {
            AlertBox.display("Username Taken","Username already taken","Close");
            return false;
        }
        if (username.contains(" ") || username.contains(",")) {
            AlertBox.display("Username Error","Username cannot contain a space or comma","Close");
            return false;
        }
        
        return true;

    }

    public static boolean isEmailValid(String email) {
        if (!(email.contains("@"))) {
            AlertBox.display("Invalid Email","Invalid Email","Close");
            return false;
        }
        if (ReadFile.isUsername(email)) {
            AlertBox.display("Invalid Email","Email already in use","Close");
            return false;
        }
        if (email.contains(" ") || email.contains(",")) {
            AlertBox.display("Invalid Email","Email cannot contain a space or comma","Close");
            return false;
        }
        return true;
    }

}