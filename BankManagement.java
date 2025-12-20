import java.util.Scanner;

class Banksystem {

    private String name;
    private int accountNumber;
    private double balance;

    // Constructor
    Banksystem(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit
    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        balance += amount;
        System.out.println("Amount deposited successfully");
    }

    // Withdraw
    void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid withdraw amount");
        }
        if (amount > balance) {
            throw new ArithmeticException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Amount withdrawn successfully");
    }

    // Balance display
    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    // Account details
    void displayDetails() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
 class BankManagement {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        Banksystem account = new Banksystem(name, accountNumber, balance);

        int choice;

        do {
            System.out.println("\nBANK MENU");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double wd = sc.nextDouble();
                        account.withdraw(wd);
                        break;

                    case 3:
                        account.displayBalance();
                        break;

                    case 4:
                        account.displayDetails();
                        break;

                    case 5:
                        System.out.println("Thank you for using Bank System");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}
