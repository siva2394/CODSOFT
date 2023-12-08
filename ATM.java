package package1;

import java.util.Scanner;

class BankAccount {
    private double balance;
    private int pin;

    public BankAccount(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public String deposit(int enteredPin, double amount) {
        if (enteredPin == this.pin) {
            if (amount > 0) {
                this.balance += amount;
                return "Deposited $" + amount + ". New balance is $" + this.balance;
            } else {
                return "Invalid deposit amount";
            }
        } else {
            return "Incorrect PIN. Deposit not allowed.";
        }
    }

    public String withdraw(int enteredPin, double amount) {
        if (enteredPin == this.pin) {
            if (amount > 0 && this.balance >= amount) {
                this.balance -= amount;
                return "Withdrew $" + amount + ". New balance is $" + this.balance;
            } else if (this.balance < amount) {
                return "Insufficient funds";
            } else {
                return "Invalid withdrawal amount";
            }
        } else {
            return "Incorrect PIN. Withdrawal not allowed.";
        }
    }

    public String checkBalance(int enteredPin) {
        if (enteredPin == this.pin) {
            return "Your balance is $" + this.balance;
        } else {
            return "Incorrect PIN. Cannot check balance.";
        }
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public int enterPin() {
        System.out.print("Enter PIN: ");
        return scanner.nextInt();
    }

    public void run() {
        int enteredPin = enterPin();

        if (enteredPin != bankAccount.getPin()) {
            System.out.println("Incorrect PIN. Exiting...");
            return;
        }

        while (true) {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Quit");
            System.out.print("Please select an option (1-3): ");
            String choice = scanner.next();
            scanner.nextLine(); // Consume the newline character

            if (choice.equals("1")) {
                System.out.print("Enter withdrawal amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                String message = bankAccount.withdraw(enteredPin, amount);
                System.out.println(message);
            } else if (choice.equals("2")) {
                System.out.print("Enter deposit amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                String message = bankAccount.deposit(enteredPin, amount);
                System.out.println(message);
            } else if (choice.equals("3")) {
                String message = bankAccount.checkBalance(enteredPin);
                System.out.println(message);
            }else if(choice.equals("4")) {
            	System.out.println("Thanks for using our service");
            	System.out.println("Quitting the service \n Make sure you  have collected your ATM card ");
            	break;
            }else {
                System.out.println("Invalid option. Please select again.");
            }
        }
    }
    public static void main(String[] args) {
        int pin = 1234; 
        BankAccount account = new BankAccount(1500, pin);
        ATM atm = new ATM(account);
        atm.run();
    }
}

