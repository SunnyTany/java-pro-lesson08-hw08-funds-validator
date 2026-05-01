package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Account myAccount = new Account(1000.00);
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Welcome to ATM System ---");
        System.out.println("Type 'exit' to finish operations.");

        while (true) {
            System.out.printf("%nBalance is USD %.2f.%n" +
                    "Enter purchase amount, USD: ", myAccount.getBalance());

            String input = scanner.next();

            // Проверка на выход
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using our service. Goodbye!");
                break;
            }

            try {
                // Пытаемся преобразовать строку в число
                double amount = Double.parseDouble(input.replace(",", "."));

                // Выполняем транзакцию (внутри только опасный метод)
                try {
                    myAccount.withdraw(amount);
                } catch (FundsException ex) {
                    System.out.println(ex.getMessage());
                    continue; // Возвращаемся к началу цикла
                }

                // Успешный результат
                System.out.println("Funds are OK. Purchase paid.");

            } catch (NumberFormatException e) {
                // Если введено не число и не "exit"
                System.out.println("Error: Please enter a valid number or 'exit'.");
            }
        }

        scanner.close();
    }
}