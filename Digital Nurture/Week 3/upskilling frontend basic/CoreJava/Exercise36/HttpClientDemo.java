/**
 * Exercise 36: HttpClient Demo
 * Objective: Use Java 11+ HttpClient to make HTTP requests.
 * Compile: javac HttpClientDemo.java
 * Run: java HttpClientDemo
 *
 * NOTE: This demo uses httpbin.org as a free test API.
 * No API key required. Internet connection needed.
 */
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientDemo {
    public static void main(String[] args) {
        System.out.println("=== Java HttpClient Demo (Java 11+) ===\n");

        // Create HttpClient
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .version(HttpClient.Version.HTTP_2)
                .build();

        // Example 1: Simple GET request
        System.out.println("--- Example 1: GET Request ---");
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/get"))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Headers:");
            response.headers().map().forEach((key, values) ->
                    System.out.println("  " + key + ": " + values));
            System.out.println("Body (first 500 chars): " + response.body().substring(0, Math.min(500, response.body().length())));

        } catch (IOException | InterruptedException e) {
            System.out.println("GET request failed: " + e.getMessage());
        }

        // Example 2: POST request with JSON body
        System.out.println("\n--- Example 2: POST Request ---");
        try {
            String jsonBody = "{\"name\": \"Java Student\", \"age\": 25, \"course\": \"Core Java\"}";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/post"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body (first 500 chars): " + response.body().substring(0, Math.min(500, response.body().length())));

        } catch (IOException | InterruptedException e) {
            System.out.println("POST request failed: " + e.getMessage());
        }

        // Example 3: GET request with custom headers
        System.out.println("\n--- Example 3: GET with Custom Headers ---");
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/headers"))
                    .header("X-Custom-Header", "JavaExercise")
                    .header("Authorization", "Bearer test-token-12345")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response: " + response.body().substring(0, Math.min(500, response.body().length())));

        } catch (IOException | InterruptedException e) {
            System.out.println("Request failed: " + e.getMessage());
        }

        // Example 4: Async GET request
        System.out.println("\n--- Example 4: Async GET Request ---");
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/delay/1"))
                    .GET()
                    .build();

            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::statusCode)
                    .thenAccept(statusCode -> System.out.println("Async Status Code: " + statusCode))
                    .join();

            System.out.println("Async request completed.");

        } catch (Exception e) {
            System.out.println("Async request failed: " + e.getMessage());
        }
    }
}
