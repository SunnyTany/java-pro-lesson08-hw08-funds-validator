package app;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws FundsException {
        // Protection against negative numbers and zero
        if (amount <= 0) {
            throw new FundsException("Error: Amount must be positive.");
        }

        // Checking the adequacy of funds
        if (amount > balance) {
            throw new FundsException("Insufficient funds!");
        }

        balance -= amount;
    }
}