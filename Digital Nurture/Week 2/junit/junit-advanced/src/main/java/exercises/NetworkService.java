package exercises;

public class NetworkService {
    public String fetchData(String url) {
        // Simulate network delay
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Data from " + url;
    }

    public boolean checkConnection(String host) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return host != null && !host.isEmpty();
    }

    public int computeHeavyTask(int iterations) {
        int sum = 0;
        for (int i = 0; i < iterations; i++) {
            sum += i;
        }
        return sum;
    }
}
