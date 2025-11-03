package src;
/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DupuisEnhancedFutureValueApp extends Application {

    // Declare UI components as required by rubric
    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();
    private TextArea txtResults = new TextArea();

    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblInterestRateFormat = new Label("Enter 11.1 for 11.1%");
    private Label lblYears = new Label("Years:");
    private Label lblResults = new Label("Future Value:");
    private Label lblFutureValueDate = new Label();


    private ComboBox<Integer> cboYears = new ComboBox<>();

    private Button btnCalculate = new Button("Calculate");
    private Button btnClear = new Button("Clear");

    @Override
    public void start(Stage primaryStage) {
        // Create and configure GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5)); // per Exhibit E
        gridPane.setHgap(5.5);
        gridPane.setVgap(5.5);

        // Populate ComboBox with loan terms
        cboYears.getItems().addAll(1, 2, 3, 4, 5, 10, 15, 20, 25, 30);
        cboYears.setValue(5); // Default selection
        cboYears.setPrefWidth(150); // Wider dropdown for visual clarity

        // Format lblInterestRateFormat
        lblInterestRateFormat.setTextFill(Color.RED); // Exhibit E: red text
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT); // Align right

        // Add prompt text to interest rate field
        txtInterestRate.setPromptText("Enter 11.1% as 11.1");

        // Add components to GridPane
        gridPane.add(lblMonthlyPayment, 0, 0);
        gridPane.add(txtMonthlyPayment, 1, 0);

        gridPane.add(lblInterestRate, 0, 1);
        gridPane.add(txtInterestRate, 1, 1);

        gridPane.add(lblInterestRateFormat, 1, 2); // Hint below interest input

        gridPane.add(lblYears, 0, 3);
        gridPane.add(cboYears, 1, 3);
        GridPane.setHalignment(cboYears, HPos.RIGHT); // Align dropdown right

        // Create HBox for buttons with spacing and padding per Exhibit F
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().addAll(btnClear, btnCalculate);
        actionBtnContainer.setAlignment(Pos.CENTER_RIGHT);
        gridPane.add(actionBtnContainer, 1, 4);
        gridPane.add(lblFutureValueDate, 0, 5, 2, 1);


        // Results area
        txtResults.setPrefRowCount(5);
        txtResults.setEditable(false);
        gridPane.add(txtResults, 0, 6, 2, 1); // Span across both columns

        // Wire up button actions
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> displayResults());


        // Set scene and stage
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Dupuis Future Value App"); // Exhibit F title
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Utility method to get today's date
    private static String getTodayDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return formatter.format(new Date());
}



private void displayResults() {
    try {
        double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText());
        double interestRate = Double.parseDouble(txtInterestRate.getText());
        int years = cboYears.getValue();

        double futureValue = FinanceCalculator.calculateFutureValue(monthlyPayment, interestRate, years);

        lblFutureValueDate.setText("Calculation as of " + getTodayDate());
        txtResults.setText(String.format("The future value is $%,.2f", futureValue));
    } catch (NumberFormatException ex) {
        txtResults.setText("Please enter valid numeric values for payment and interest rate.");
    }
}

    

    private void clearFormFields() {
        txtMonthlyPayment.clear();
        txtInterestRate.clear();
        cboYears.setValue(5);
        txtResults.clear();
        lblFutureValueDate.setText("");
    }
    
    

    public static void main(String[] args) {
        launch(args);
    }
}
