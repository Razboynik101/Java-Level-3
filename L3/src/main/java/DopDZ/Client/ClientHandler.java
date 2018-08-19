package DopDZ.Client;
import DopDZ.Student;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class ClientHandler {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private Socket sock;
    private Scanner in;
    private PrintWriter out;
    public ClientHandler() {
        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream());
            while (true) {
                Scanner sc = new Scanner(System.in);
                String command = sc.next();
                if (command.startsWith("/check")) {
                    ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
                    Student s2 = (Student) ois.readObject();
                    ois.close();
                    s2.info();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
