package edu.miracosta.cs112.finalproject;

import edu.miracosta.cs112.finalproject.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

/**
 * Controller for the main dashboard.
 */
public class MainController {

    // TOP
    @FXML private Label userNameLabel;
    @FXML private Button logoutBtn;

    // LEFT
    @FXML private VBox accountList;

    // CENTER: Dashboard tab
    @FXML private Label totalValueLabel;
    @FXML private Label checkingBalanceLabel;
    @FXML private Label savingsBalanceLabel;
    @FXML private Label creditBalanceLabel;
    @FXML private LineChart<Number, Number> lineChart;
    @FXML private TableView<Transaction> transactionTable;
    @FXML private TableColumn<Transaction, String> dateColumn;
    @FXML private TableColumn<Transaction, String> typeColumn;
    @FXML private TableColumn<Transaction, Double> amountColumn;
    @FXML private TableColumn<Transaction, String> accountColumn;

    // BOTTOM
    @FXML private TextField amountField;
    @FXML private Button depositBtn;
    @FXML private Button withdrawBtn;
    @FXML private Button transferBtn;
    @FXML private Button settingsBtn;

    @FXML
    public void initialize() {
        // 1) Header
        userNameLabel.setText("Welcome back, Joshua");

        // 2) Summary cards
        totalValueLabel.setText("$2,221.52");
        checkingBalanceLabel.setText("$2,221.52");
        savingsBalanceLabel.setText("$12,345.00");
        creditBalanceLabel.setText("$1,200.00");

        // 3) Dummy chart data
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(1, 2000));
        series.getData().add(new XYChart.Data<>(2, 2100));
        series.getData().add(new XYChart.Data<>(3, 2200));
        series.getData().add(new XYChart.Data<>(4, 2221.52));
        lineChart.getData().add(series);

        // 4) Dummy transactions
        ObservableList<Transaction> txs = FXCollections.observableArrayList(
                new Transaction("04/28/25", "Dividend", 7.95,  "Checking"),
                new Transaction("04/15/25", "Deposit",  500.00,"Checking"),
                new Transaction("04/01/25", "Withdraw", 100.00,"Savings")
        );

        dateColumn.setCellValueFactory(cell -> cell.getValue().dateProperty());
        typeColumn.setCellValueFactory(cell -> cell.getValue().typeProperty());
        amountColumn.setCellValueFactory(cell -> cell.getValue().amountProperty().asObject());
        accountColumn.setCellValueFactory(cell -> cell.getValue().accountProperty());

        transactionTable.setItems(txs);

        // 5) Account list (left nav)
        accountList.getChildren().addAll(
                makeAccountButton("Checking ••223", "$2,221.52"),
                makeAccountButton("Savings  ••778", "$12,345.00"),
                makeAccountButton("Credit   ••112", "$1,200.00")
        );
    }

    private Button makeAccountButton(String title, String balance) {
        Button b = new Button(title + "   " + balance);
        b.setMaxWidth(Double.MAX_VALUE);
        return b;
    }

    // Top-bar actions (no-op for UD1)
    @FXML private void onLogout()     { /* stub */ }

    // Bottom-bar actions (no-op for UD1)
    @FXML private void onDeposit()    { /* stub */ }
    @FXML private void onWithdraw()   { /* stub */ }
    @FXML private void onTransfer()   { /* stub */ }
    @FXML private void onSettings()   { /* stub */ }
}
