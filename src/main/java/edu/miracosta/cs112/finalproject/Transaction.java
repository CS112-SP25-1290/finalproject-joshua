package edu.miracosta.cs112.finalproject;
import javafx.beans.property.*;

public class Transaction {
    private final StringProperty date = new SimpleStringProperty();
    private final StringProperty type = new SimpleStringProperty();
    private final DoubleProperty amount = new SimpleDoubleProperty();
    private final StringProperty account = new SimpleStringProperty();

    public Transaction(String date, String type, double amount, String account) {
        this.date.set(date);
        this.type.set(type);
        this.amount.set(amount);
        this.account.set(account);
    }

    public StringProperty dateProperty() { return date; }
    public StringProperty typeProperty() { return type; }
    public DoubleProperty amountProperty() { return amount; }
    public StringProperty accountProperty() { return account; }

    // Optional getters if needed
    public String getDate() { return date.get(); }
    public String getType() { return type.get(); }
    public double getAmount() { return amount.get(); }
    public String getAccount() { return account.get(); }
}
