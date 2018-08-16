import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
public class Three {
    public static void main(String[] args) {
        int pageLength = 1800;
        int offset = 0;
        try (FileInputStream in = new FileInputStream("Doc/3.txt")) {
            byte[] arr = new byte[1200000];
            int x;
            Scanner sc = new Scanner(System.in);
            int page = sc.nextInt() - 1;
            offset = page * pageLength;
            while ((x = in.read(arr)) != -1) {
                System.out.println(new String(arr, offset, pageLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
