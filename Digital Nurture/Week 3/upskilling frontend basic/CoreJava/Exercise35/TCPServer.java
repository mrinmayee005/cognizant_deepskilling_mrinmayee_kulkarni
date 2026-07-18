/**
 * Exercise 35a: TCP Server
 * Objective: Create a simple TCP server that accepts client connections.
 * Compile: javac TCPServer.java
 * Run: java TCPServer
 * Then run TCPClient in a separate terminal.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        System.out.println("=== TCP Server ===");
        System.out.println("Starting server on port " + PORT + "...\n");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            System.out.println("Waiting for client connection...\n");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from: " + clientSocket.getInetAddress());

            // Set up I/O streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Communication loop
            String clientMessage;
            int messageCount = 0;

            while ((clientMessage = in.readLine()) != null) {
                messageCount++;
                System.out.println("Client [#" + messageCount + "]: " + clientMessage);

                // Echo back with server response
                String response = "Server echo [" + messageCount + "]: " + clientMessage.toUpperCase();
                out.println(response);

                if (clientMessage.equalsIgnoreCase("quit")) {
                    out.println("Server: Goodbye!");
                    System.out.println("Client requested to quit.");
                    break;
                }
            }

            // Clean up
            in.close();
            out.close();
            clientSocket.close();
            System.out.println("\nServer shutting down. Processed " + messageCount + " messages.");

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
