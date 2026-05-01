package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Account myAccount = new Account(1000.00);
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", myAccount.getBalance());

        // 1. Input validation (not a number)
        if (!scanner.hasNextDouble()) {
            System.out.println("Error: Invalid input. Please enter a number.");
            return;
        }

        double amount = scanner.nextDouble();

        // 2. In the try block, only the method that throws the exception
        try {
            myAccount.withdraw(amount);
        } catch (FundsException ex) {
            System.out.println(ex.getMessage());
            return; // Aborting execution because the transaction failed.
        }

        // 3. Logic of successful completion
        System.out.println("Funds are OK. Purchase paid.");
        System.out.printf("Balance is USD %.2f%n", myAccount.getBalance());
    }
}