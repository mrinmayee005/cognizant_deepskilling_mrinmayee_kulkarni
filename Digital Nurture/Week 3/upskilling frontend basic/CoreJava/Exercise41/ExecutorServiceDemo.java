/**
 * Exercise 41: ExecutorService Demo
 * Objective: Use ExecutorService with Callable and Future for concurrent execution.
 * Compile: javac ExecutorServiceDemo.java
 * Run: java ExecutorServiceDemo
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {

    // Callable that computes the factorial of a number
    static class FactorialTask implements Callable<Long> {
        private final int number;

        public FactorialTask(int number) {
            this.number = number;
        }

        @Override
        public Long call() {
            long result = 1;
            for (int i = 1; i <= number; i++) {
                result *= i;
            }
            System.out.println("FactorialTask: " + number + "! = " + result
                    + " (thread: " + Thread.currentThread().getName() + ")");
            return result;
        }
    }

    // Callable that sums a range of numbers
    static class SumTask implements Callable<Long> {
        private final int start;
        private final int end;

        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Long call() {
            long sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            System.out.println("SumTask: sum(" + start + ".." + end + ") = " + sum
                    + " (thread: " + Thread.currentThread().getName() + ")");
            return sum;
        }
    }

    // Callable that performs a time-consuming computation
    static class PrimeCountTask implements Callable<Integer> {
        private final int limit;

        public PrimeCountTask(int limit) {
            this.limit = limit;
        }

        @Override
        public Integer call() {
            int count = 0;
            for (int i = 2; i <= limit; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            System.out.println("PrimeCountTask: primes up to " + limit + " = " + count
                    + " (thread: " + Thread.currentThread().getName() + ")");
            return count;
        }

        private boolean isPrime(int n) {
            if (n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ExecutorService Demo ===\n");

        // Example 1: Fixed Thread Pool
        System.out.println("--- Example 1: Fixed Thread Pool (3 threads) ---");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit Callable tasks
        Future<Long> factorialFuture = executor.submit(new FactorialTask(10));
        Future<Long> sumFuture = executor.submit(new SumTask(1, 1000));
        Future<Integer> primeFuture = executor.submit(new PrimeCountTask(100));

        try {
            System.out.println("\nWaiting for results...");
            System.out.println("10! = " + factorialFuture.get());
            System.out.println("Sum(1..1000) = " + sumFuture.get());
            System.out.println("Primes up to 100 = " + primeFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Example 2: Submit multiple tasks and collect results
        System.out.println("\n--- Example 2: Multiple Factorial Tasks ---");
        List<Future<Long>> factorialFutures = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            factorialFutures.add(executor.submit(new FactorialTask(i)));
        }

        System.out.println("\nFactorial Results:");
        for (int i = 0; i < factorialFutures.size(); i++) {
            try {
                System.out.println((i + 1) + "! = " + factorialFutures.get(i).get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error computing " + (i + 1) + "!: " + e.getMessage());
            }
        }

        // Example 3: Shutdown and await termination
        System.out.println("\n--- Example 3: Graceful Shutdown ---");
        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                System.out.println("Executor forced to shutdown.");
            } else {
                System.out.println("Executor shut down gracefully.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            System.out.println("Shutdown interrupted.");
        }

        // Example 4: Other executor types
        System.out.println("\n--- Executor Types Available ---");
        System.out.println("1. newFixedThreadPool(n)      - Fixed number of threads");
        System.out.println("2. newCachedThreadPool()     - Creates threads as needed, reuses idle");
        System.out.println("3. newSingleThreadExecutor()  - Single worker thread");
        System.out.println("4. newScheduledThreadPool(n)  - For scheduling delayed tasks");
        System.out.println("5. newWorkStealingPool()      - ForkJoinPool for parallel tasks");
        System.out.println("6. newVirtualThreadPerTaskExecutor() - Virtual threads (Java 21+)");

        System.out.println("\n=== Demo Complete ===");
    }
}
