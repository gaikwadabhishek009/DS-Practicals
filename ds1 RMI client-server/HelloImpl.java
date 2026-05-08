import java.rmi.*;
import java.rmi.server.*;

public class HelloImpl extends UnicastRemoteObject implements Hello {

    protected HelloImpl() throws RemoteException {
        super();
    }

    public String sayHello(String name) throws RemoteException {

        // Print thread info on server
        String threadName = Thread.currentThread().getName();
        System.out.println("Request from: " + name + " handled by " + threadName);

        try {
            Thread.sleep(2000); // simulate processing
        } catch (InterruptedException e) {}

        return "Hello " + name + " from Server (Thread: " + threadName + ")";
    }
}
