package DopDZ.Server;
import DopDZ.Student;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {
    public static void main(String[] args) {
        ServerSocket serv = null;
        final Scanner self = new Scanner(System.in);
        try {
            serv = new ServerSocket(8189);
            System.out.println("Server started...");
            final Socket sock = serv.accept();
            System.out.println("Client connected");
            final Scanner sc = new Scanner(sock.getInputStream());
            final PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String wrd = self.nextLine();
                        if (wrd.equals("/end")) {
                            System.out.println("Admin stopped server ");
                            break;
                        }
                        if (wrd.equals("/create")) {
                            Student s = new Student(19);
                            ObjectOutputStream oos = null;
                            try {
                                oos = new ObjectOutputStream(sock.getOutputStream());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                oos.writeObject(s);
                                oos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        pw.println("Server: " + wrd);
                        System.out.println("Server: " + wrd);
                    }
                }
            }).start();
        } catch (IOException e) {
            System.out.println("Server inicialisation error");
        } finally {
            try {
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop(ServerSocket serv) {
        try {
            serv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

