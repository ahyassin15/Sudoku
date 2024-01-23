module loginassignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens loginassignment to javafx.fxml;
    exports loginassignment;

    opens loginassignment.sudoku;
    exports loginassignment.sudoku;
}
