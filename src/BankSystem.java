/*Name: Serge MUNEZA
Reg. No.: 20248/2022
Class name: BankSystem
Description: It is the main Class
 */
import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a BankAccount
        System.out.println("Create a Bank Account:");
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account holder's name: ");
        String accountHolderName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        BankAccount account = new BankAccount(accountNumber, accountHolderName, balance);

        SavingsAccount savingsAccount = null;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Create Savings Account");
            System.out.println("5. Apply Interest (Savings Account)");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Display account details
                    if (savingsAccount != null) {
                        savingsAccount.displayAccountInfo();
                    } else {
                        account.displayAccountInfo();
                    }
                    break;

                case 2:
                    // Deposit money
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    // Withdraw money
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    // Create Savings Account
                    if (savingsAccount == null) {
                        System.out.print("Enter interest rate for Savings Account: ");
                        double interestRate = scanner.nextDouble();
                        savingsAccount = new SavingsAccount(account, interestRate);
                        System.out.println("Savings Account created successfully.");
                    } else {
                        System.out.println("Savings Account already exists.");
                    }
                    break;

                case 5:
                    // Apply interest
                    if (savingsAccount != null) {
                        savingsAccount.applyInterest();
                    } else {
                        System.out.println("Savings Account not created yet.");
                    }
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}