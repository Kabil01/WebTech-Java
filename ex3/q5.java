//5
import java.util.ArrayList;
import java.util.List;


interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double calculateInterest();
    double getBalance();
}


class SavingsAccount implements Account {
    private double balance;
    private double interestRate;

    public SavingsAccount(double initialBalance, double interestRate) {
        this.balance = initialBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    
    public void applyCompoundInterest() {
        double interest = calculateInterest();
        balance += interest;
        System.out.println("Interest Applied: " + interest);
    }
}


class CurrentAccount implements Account {
    private double balance;
    private double overdraftLimit;

    public CurrentAccount(double initialBalance, double overdraftLimit) {
        this.balance = initialBalance;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }

    @Override
    public double calculateInterest() {
        
        return 0;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    
    public void applyOverdraftFee() {
        balance -= 20; 
        System.out.println("Overdraft Fee Applied");
    }
}

class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added to the bank.");
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}

public class q5{
    public static void main(String[] args) {
        Bank bank = new Bank();

        SavingsAccount savingsAccount = new SavingsAccount(1000, 0.05);
        CurrentAccount currentAccount = new CurrentAccount(2000, 1000);

        bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);

        savingsAccount.deposit(200);
        savingsAccount.applyCompoundInterest();
        savingsAccount.withdraw(500);

        currentAccount.deposit(300);
        currentAccount.applyOverdraftFee();
        currentAccount.withdraw(2200);

        System.out.println("\nAccount Balances:");
        for (Account account : bank.getAccounts()) {
            System.out.println("Balance: " + account.getBalance());
        }
    }
}

