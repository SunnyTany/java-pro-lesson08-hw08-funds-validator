package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a specific account object with an initial balance
        Account myAccount = new Account(1000.00);
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", myAccount.getBalance());

        // Input validation (not a number)
        if (!scanner.hasNextDouble()) {
            System.out.println("Error: Invalid input. Please enter a number.");
            return;
        }

        double amount = scanner.nextDouble();

        try {
            // We are trying to withdraw money
            myAccount.withdraw(amount);
            System.out.println("Funds are OK. Purchase paid.");
            System.out.printf("Balance is USD %.2f%n", myAccount.getBalance());
        } catch (FundsException ex) {
            // We are processing the lack of funds
            System.out.println(ex.getMessage());
        }
    }
}