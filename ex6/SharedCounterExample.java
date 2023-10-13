public class SharedCounterExample {
    public static void main(String[] args) {
        int numThreads = 5; // Number of threads
        int targetValue = 10000; // Desired final value of the shared counter

        SharedCounter sharedCounter = new SharedCounter(targetValue);

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new Incrementer(sharedCounter));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final Counter Value: " + sharedCounter.getCounter());
    }
}

class SharedCounter {
    private int counter;
    private int targetValue;

    public SharedCounter(int targetValue) {
        this.counter = 0;
        this.targetValue = targetValue;
    }

    public synchronized void increment() {
        if (counter < targetValue) {
            counter++;
        }
    }

    public int getCounter() {
        return counter;
    }

    public int getTargetValue() {
        return targetValue;
    }
}

class Incrementer implements Runnable {
    private SharedCounter sharedCounter;

    public Incrementer(SharedCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        while (sharedCounter.getCounter() < sharedCounter.getTargetValue()) {
            sharedCounter.increment();
        }
    }
}

