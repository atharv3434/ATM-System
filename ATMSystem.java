import java.util.Scanner;

// Class to represent an ATM account
class ATM {
    private double balance;
    private int pin;

    // Constructor
    public ATM(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    // PIN verification
    public boolean verifyPIN(int enteredPIN) {
        return this.pin == enteredPIN;
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New Balance: $" + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Change PIN
    public void changePIN(int oldPIN, int newPIN) {
        if (verifyPIN(oldPIN)) {
            this.pin = newPIN;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect old PIN.");
        }
    }
}

// Main class to interact with the ATM
public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an ATM account with an initial balance of $1000 and PIN 1234
        ATM userAccount = new ATM(1000.0, 1234);

        System.out.print("Enter your ATM PIN: ");
        int enteredPIN = scanner.nextInt();

        if (!userAccount.verifyPIN(enteredPIN)) {
            System.out.println("Incorrect PIN! Exiting...");
            return;
        }

        // Menu-driven approach
        while (true) {
            System.out.println("\n----- ATM System -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    userAccount.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter old PIN: ");
                    int oldPIN = scanner.nextInt();
                    System.out.print("Enter new PIN: ");
                    int newPIN = scanner.nextInt();
                    userAccount.changePIN(oldPIN, newPIN);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
