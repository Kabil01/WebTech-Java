import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    private Lock lock = new ReentrantLock();

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount, String threadName) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(threadName + " deposited: " + amount + ", New Balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount, String threadName) {
        lock.lock();
        try {
            if (amount <= balance) {
                balance -= amount;
                System.out.println(threadName + " withdrawn: " + amount + ", New Balance: " + balance);
            } else {
                System.out.println(threadName + " - Insufficient funds for withdrawal: " + amount);
            }
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountConcurrency {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);

        Runnable depositRunnable = () -> {
            Thread.currentThread().setName("Depositor");
            for (int i = 0; i < 10; i++) {
                account.deposit(100.0, Thread.currentThread().getName());
            }
        };

        Runnable withdrawRunnable = () -> {
            Thread.currentThread().setName("Withdrawer");
            for (int i = 0; i < 5; i++) {
                account.withdraw(150.0, Thread.currentThread().getName());
            }
        };

        Thread depositThread1 = new Thread(depositRunnable);
        Thread depositThread2 = new Thread(depositRunnable);
        Thread withdrawThread1 = new Thread(withdrawRunnable);
        Thread withdrawThread2 = new Thread(withdrawRunnable);

        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        withdrawThread2.start();

        try {
            depositThread1.join();
            depositThread2.join();
            withdrawThread1.join();
            withdrawThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}

/*
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method to deposit money
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", Current Balance: " + balance);
    }

    // Synchronized method to withdraw money
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Current Balance: " + balance);
        } else {
            System.out.println("Insufficient balance for withdrawal: " + amount);
        }
    }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);

        // Create two threads for concurrent deposits and withdrawals
        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(100.0);
                try {
                    Thread.sleep(100); // Simulate some processing time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(200.0);
                try {
                    Thread.sleep(100); // Simulate some processing time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
*/
