/**
 * Exercise 26: Thread Creation
 * Objective: Create two threads using both Thread subclass and Runnable interface.
 * Compile: javac ThreadCreation.java
 * Run: java ThreadCreation
 */
class CounterThread extends Thread {
    private String threadName;

    public CounterThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": Count " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
        System.out.println(threadName + " has finished.");
    }
}

class MessagePrinter implements Runnable {
    private String message;
    private int times;

    public MessagePrinter(String message, int times) {
        this.message = message;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + message + " (" + (i + 1) + "/" + times + ")");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
        }
        System.out.println(Thread.currentThread().getName() + " has finished.");
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        System.out.println("=== Thread Creation Demo ===\n");

        // Method 1: Extending Thread class
        System.out.println("--- Method 1: Extending Thread ---");
        CounterThread thread1 = new CounterThread("Thread-A");
        CounterThread thread2 = new CounterThread("Thread-B");

        thread1.start();
        thread2.start();

        // Method 2: Implementing Runnable
        System.out.println("\n--- Method 2: Implementing Runnable ---");
        Thread thread3 = new Thread(new MessagePrinter("Hello from Runnable", 4), "RunnableThread-1");
        Thread thread4 = new Thread(new MessagePrinter("Java is fun", 4), "RunnableThread-2");

        thread3.start();
        thread4.start();

        // Wait for all threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nAll threads have completed. Main thread exiting.");
    }
}
