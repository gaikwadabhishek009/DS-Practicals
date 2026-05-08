import java.io.*;
import java.net.*;

public class WebServiceServer {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);
        System.out.println("Web Service started on port 5000...");

        while (true) {

            Socket socket = server.accept();
            System.out.println("Client connected...");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read request
            String request = in.readLine();
            System.out.println("Request: " + request);

            // Split numbers
            String[] nums = request.split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);

            int sum = a + b;

            // Send response
            out.println("Sum = " + sum);

            socket.close();
        }
    }
}