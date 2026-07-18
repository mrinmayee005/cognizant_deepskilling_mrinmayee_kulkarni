/**
 * Exercise 40: Virtual Threads Demo
 * Objective: Demonstrate Java 21 Virtual Threads for lightweight concurrency.
 * Requires Java 21+
 *
 * Virtual Threads are:
 * - Managed by the JVM, not the OS
 * - Extremely lightweight (can create millions)
 * - Ideal for I/O-bound tasks
 * - Use the same java.lang.Thread API
 *
 * Compile: javac VirtualThreads.java
 * Run: java VirtualThreads
 */
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreads {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Virtual Threads Demo (Java 21+) ===\n");

        // Example 1: Basic virtual thread creation
        System.out.println("--- Example 1: Basic Virtual Thread ---");
        Thread vt = Thread.ofVirtual().name("my-virtual-thread").start(() -> {
            System.out.println("Running in virtual thread: " + Thread.currentThread());
            System.out.println("Is virtual: " + Thread.currentThread().isVirtual());
            System.out.println("Thread name: " + Thread.currentThread().getName());
        });
        vt.join();

        // Example 2: Create many virtual threads
        System.out.println("\n--- Example 2: Creating 100,000 Virtual Threads ---");
        Instant start = Instant.now();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            final int id = i;
            Thread thread = Thread.ofVirtual().name("vt-" + id).start(() -> {
                try {
                    Thread.sleep(Duration.ofMillis(10));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            threads.add(thread);
        }

        // Wait for all threads
        for (Thread t : threads) {
            t.join();
        }

        Instant end = Instant.now();
        System.out.println("Created and completed 100,000 virtual threads in: "
                + Duration.between(start, end).toMillis() + " ms");

        // Example 3: Virtual threads with ExecutorService
        System.out.println("\n--- Example 3: ExecutorService with Virtual Threads ---");
        start = Instant.now();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Callable<String>> tasks = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                final int taskId = i;
                tasks.add(() -> {
                    Thread.sleep(Duration.ofMillis(5));
                    return "Task " + taskId + " completed by " + Thread.currentThread().getName();
                });
            }

            List<Future<String>> futures = executor.invokeAll(tasks);
            int completedCount = 0;
            for (Future<String> future : futures) {
                future.get();
                completedCount++;
            }
            System.out.println("Completed " + completedCount + " tasks via ExecutorService");
        }

        end = Instant.now();
        System.out.println("Time taken: " + Duration.between(start, end).toMillis() + " ms");

        // Example 4: Platform vs Virtual thread comparison
        System.out.println("\n--- Example 4: Platform Threads (for comparison) ---");
        start = Instant.now();

        try (ExecutorService executor = Executors.newFixedThreadPool(100)) {
            List<Callable<String>> tasks = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                final int taskId = i;
                tasks.add(() -> {
                    Thread.sleep(Duration.ofMillis(5));
                    return "Task " + taskId;
                });
            }

            List<Future<String>> futures = executor.invokeAll(tasks);
            for (Future<String> future : futures) {
                future.get();
            }
            System.out.println("Completed 1000 tasks with platform thread pool (100 threads)");
        }

        end = Instant.now();
        System.out.println("Time taken: " + Duration.between(start, end).toMillis() + " ms");

        System.out.println("\n=== Summary ===");
        System.out.println("Virtual threads: Lightweight, created by JVM, no OS thread limit.");
        System.out.println("Platform threads: Heavy, mapped 1:1 to OS threads.");
        System.out.println("Use virtual threads for I/O-bound workloads.");
    }
}
