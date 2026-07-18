/**
 * Exercise 35b: TCP Client
 * Objective: Create a TCP client that connects to the server and sends messages.
 * Compile: javac TCPClient.java
 * Run: java TCPClient (ensure TCPServer is running first)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 9999;

    public static void main(String[] args) {
        System.out.println("=== TCP Client ===");
        System.out.println("Connecting to server at " + SERVER_HOST + ":" + SERVER_PORT + "...\n");

        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to server!");
            System.out.println("Type messages to send (type 'quit' to exit):\n");

            String userInput;
            while (true) {
                System.out.print("You: ");
                userInput = scanner.nextLine();

                // Send message to server
                out.println(userInput);

                // Receive response from server
                String serverResponse = in.readLine();
                if (serverResponse != null) {
                    System.out.println("Server: " + serverResponse);
                }

                if (userInput.equalsIgnoreCase("quit")) {
                    System.out.println("Disconnected from server.");
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
            System.out.println("Make sure the server is running first!");
        }
    }
}
