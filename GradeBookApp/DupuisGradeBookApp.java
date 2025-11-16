/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class DupuisGradeBookApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Set the title of the application window
        primaryStage.setTitle("GradeBookApp");

        // ----------------------------
        // Create Labels for Form Fields
        // ----------------------------
        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel = new Label("Last Name:");
        Label courseLabel = new Label("Course:");
        Label gradeLabel = new Label("Grade:");

        // ----------------------------
        // Create Input Fields
        // ----------------------------
        TextField firstNameField = new TextField(); // For entering student's first name
        TextField lastNameField = new TextField();  // For entering student's last name

        // ComboBox for selecting course from predefined list
        ComboBox<String> courseComboBox = new ComboBox<>();
        courseComboBox.getItems().addAll("Math", "Science", "History", "English");

        // ComboBox for selecting grade (A–F)
        ComboBox<String> gradeComboBox = new ComboBox<>();
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F");

        // ----------------------------
        // Create Buttons
        // ----------------------------
        Button clearButton = new Button("Clear");         // Clears the form fields
        Button viewButton = new Button("View Grades");    // Will display saved grades (next week)
        Button saveButton = new Button("Save Entry");     // Will save grade entry to CSV (next week)

        // ----------------------------
        // Layout: GridPane for Form Fields
        // ----------------------------
        GridPane formGrid = new GridPane();
        // Define column constraints to align input fields to the right
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.NEVER); // Label column stays tight

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS); // Input column expands
        col2.setHalignment(HPos.RIGHT); // Align inputs to the right

        formGrid.getColumnConstraints().addAll(col1, col2);

        formGrid.setVgap(10); // Vertical spacing between rows
        formGrid.setHgap(10); // Horizontal spacing between columns

        // Add labels and input fields to the grid
        formGrid.add(firstNameLabel, 0, 0);
        formGrid.add(firstNameField, 1, 0);
        GridPane.setHalignment(firstNameField, HPos.RIGHT);
        formGrid.add(lastNameLabel, 0, 1);
        formGrid.add(lastNameField, 1, 1);
        GridPane.setHalignment(lastNameField, HPos.RIGHT);
        formGrid.add(courseLabel, 0, 2);
        formGrid.add(courseComboBox, 1, 2);
        GridPane.setHalignment(courseComboBox, HPos.RIGHT);
        formGrid.add(gradeLabel, 0, 3);
        formGrid.add(gradeComboBox, 1, 3);
        GridPane.setHalignment(gradeComboBox, HPos.RIGHT);

        // -----------------------------
// Layout: HBox for Buttons
// -----------------------------
clearButton.setPrefWidth(100);
viewButton.setPrefWidth(100);
saveButton.setPrefWidth(100);

HBox buttonBox = new HBox(20); // 20px spacing between buttons
buttonBox.getChildren().addAll(clearButton, viewButton, saveButton);
buttonBox.setAlignment(Pos.CENTER_RIGHT); // Align buttons to the right



        // ----------------------------
        // Main Layout: VBox to stack form and buttons
        // ----------------------------
        VBox mainLayout = new VBox(15, formGrid, buttonBox); // Vertical layout with spacing
        mainLayout.setStyle("-fx-padding: 20;"); // Add padding around the layout

        // ----------------------------
        // Set Scene and Show Stage
        // ----------------------------
        Scene scene = new Scene(mainLayout, 400, 300); // Set window size
        primaryStage.setScene(scene);
        primaryStage.show(); // Display the window
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
