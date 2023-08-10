import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        // STEP1: Get the host and the port from the command-line
        String hostName = "192.168.1.7";
        int portNumber = Integer.parseInt("8000");

        // STEP2: Open a client socket, blocking while connecting to the server
        Socket clientSocket = new Socket(hostName, portNumber);

        // STEP3: Setup input and output streams
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //Set up a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        //Continuously read user input and send it to the server
        while (true) {
            String string = scanner.nextLine(); //Read user's input
            out.println(string);
            //System.out.println("Received from server: " + in.readLine());
        }
        //out.close();
        //clientSocket.close();
    }
}
