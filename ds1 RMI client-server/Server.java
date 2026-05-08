import java.rmi.*;

public class Server {
    public static void main(String[] args) {
        try {
            HelloImpl obj = new HelloImpl();

            Naming.rebind("rmi://localhost/HelloService", obj);

            System.out.println("Server started...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
