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

import java.io.*; // NEW: for CSV file writing/reading

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
        Button viewButton = new Button("View Grades");    // Displays saved grades
        Button saveButton = new Button("Save Entry");     // Saves grade entry to CSV

        // ----------------------------
        // NEW: Create TextArea for Grades Display
        // ----------------------------
        TextArea gradesDisplay = new TextArea();
        gradesDisplay.setEditable(false); // read-only
        gradesDisplay.setPrefHeight(150); // give it space

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

        // ----------------------------
        // Layout: View Button (above TextArea)
        // ----------------------------
        saveButton.setPrefWidth(120);
        HBox saveBox = new HBox(saveButton);
        saveBox.setAlignment(Pos.CENTER_RIGHT);



        // ----------------------------
        // Layout: Save and Clear Buttons (below TextArea)
        // ----------------------------
        clearButton.setPrefWidth(120);
        viewButton.setPrefWidth(120);
        VBox clearViewBox = new VBox(10, clearButton, viewButton);
        clearViewBox.setAlignment(Pos.CENTER_RIGHT);


        // ----------------------------
        // NEW: Event Handlers
        // ----------------------------

        // Clear button: reset all fields and text area
        clearButton.setOnAction(e -> {
            firstNameField.clear();
            lastNameField.clear();
            courseComboBox.getSelectionModel().clearSelection();
            gradeComboBox.getSelectionModel().clearSelection();
            gradesDisplay.clear();
        });

        // Save button: create Student object, write to CSV, show in TextArea
        saveButton.setOnAction(e -> {
            Student student = new Student(
                firstNameField.getText(),
                lastNameField.getText(),
                courseComboBox.getValue(),
                gradeComboBox.getValue()
            );

            try {
                File file = new File("grades.csv");
                boolean fileExists = file.exists();

                try (FileWriter writer = new FileWriter(file, true);
                     PrintWriter out = new PrintWriter(writer)) {

                    // If file is new/empty, write header first
                    if (!fileExists || file.length() == 0) {
                        out.println("firstName, lastName, course, and grade");
                    }

                    out.println(student.getFirstName() + ", " +
                    student.getLastName() + ", " +
                    student.getCourse() + ", " +
                    student.getGrade());

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // Show in TextArea using toString()
            gradesDisplay.appendText(student.toString() + "\n");
        });

        // View button: read CSV and display contents
        viewButton.setOnAction(e -> {
            gradesDisplay.clear();
            try (BufferedReader reader = new BufferedReader(new FileReader("grades.csv"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    gradesDisplay.appendText(line + "\n");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // ----------------------------
        // Main Layout: VBox to stack form, buttons, and TextArea
        // ----------------------------
        VBox mainLayout = new VBox(15, formGrid, saveBox, gradesDisplay, clearViewBox);
        mainLayout.setStyle("-fx-padding: 20;");



        // ----------------------------
        // Set Scene and Show Stage
        // ----------------------------
        Scene scene = new Scene(mainLayout, 400, 550); // Increased height for TextArea
        primaryStage.setScene(scene);
        primaryStage.show(); // Display the window
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
