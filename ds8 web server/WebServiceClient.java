import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WebServiceClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        // Send request
        out.println(a + " " + b);

        // Receive response
        String response = in.readLine();

        System.out.println("Response from server: " + response);

        socket.close();
        sc.close();
    }
}