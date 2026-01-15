import java.io.*;
import java.util.Scanner;

abstract class BankAccount implements Serializable {

    private int accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited: ₹" + amount);
    }

    public void deposit(double amount, String chequeNo) {
        balance += amount;
        System.out.println("Cheque deposited: ₹" + amount);
    }

    public abstract void withdraw(double amount);

    public void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.println("Balance        : ₹" + balance);
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class CurrentAccount extends BankAccount {

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount);
    }
}

public class BankManagementSystem {

    static final String FILE_NAME = "account.dat";

    static void saveAccount(BankAccount acc) {
        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            out.writeObject(acc);
            out.close();
        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }

    static BankAccount loadAccount() {
        try {
            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream(FILE_NAME));
            BankAccount acc = (BankAccount) in.readObject();
            in.close();
            return acc;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account;

        while (true) {
            System.out.println("\n1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Balance");
            System.out.println("5.Account Details");
            System.out.println("6.Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Initial Balance: ");
                    double bal = sc.nextDouble();

                    System.out.print("1.Savings  2.Current: ");
                    int type = sc.nextInt();

                    if (type == 1)
                        account = new SavingsAccount(accNo, name, bal);
                    else
                        account = new CurrentAccount(accNo, name, bal);

                    saveAccount(account);
                    System.out.println("Account created");
                    break;

                case 2:
                    account = loadAccount();
                    if (account != null) {
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        account.deposit(amt);
                        saveAccount(account);
                    } else {
                        System.out.println("No account found");
                    }
                    break;

                case 3:
                    account = loadAccount();
                    if (account != null) {
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        account.withdraw(amt);
                        saveAccount(account);
                    } else {
                        System.out.println("No account found");
                    }
                    break;

                case 4:
                    account = loadAccount();
                    if (account != null)
                        account.showBalance();
                    else
                        System.out.println("No account found");
                    break;

                case 5:
                    account = loadAccount();
                    if (account != null)
                        account.showDetails();
                    else
                        System.out.println("No account found");
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
