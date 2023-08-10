import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {

        // STEP1: Get parameters from command line arguments
        int portNumber = Integer.parseInt("9000");

        // STEP2: Bind to local port and block while waiting for client connections
        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket clientSocket = serverSocket.accept();

        // STEP3: Setup input and output streams
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        //Loop to continuously receive and print messages from the client
        while(true) {
            //String string = scanner.nextLine();
            //out.println(string);

            // Read a line from the client and print it
            System.out.println("Received from server: " + in.readLine());
        }

        //in.close();
        //clientSocket.close();
        //serverSocket.close();
    }
}
