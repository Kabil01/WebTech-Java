class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    private double withdrawalLimit;

    public SavingsAccount(double initialBalance, double withdrawalLimit) {
        super(initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= withdrawalLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal limit exceeded");
        }
    }
}

class CheckingAccount extends BankAccount {
    private double withdrawalFee;

    public CheckingAccount(double initialBalance, double withdrawalFee) {
        super(initialBalance);
        this.withdrawalFee = withdrawalFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount + withdrawalFee <= getBalance()) {
            super.withdraw(amount + withdrawalFee);
        } else {
            System.out.println("Insufficient funds or withdrawal fee exceeds balance");
        }
    }
}

public class Account4 {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(1000.0, 500.0);
        CheckingAccount checkingAccount = new CheckingAccount(1500.0, 10.0);

        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
        savingsAccount.withdraw(400.0);
        System.out.println("Savings Account Balance after withdrawal: " + savingsAccount.getBalance());

        System.out.println("Checking Account Balance: " + checkingAccount.getBalance());
        checkingAccount.withdraw(100.0);
        System.out.println("Checking Account Balance after withdrawal: " + checkingAccount.getBalance());
    }
}

