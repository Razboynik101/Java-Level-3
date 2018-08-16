import java.io.FileInputStream;
import java.io.IOException;
public class One {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("Doc/1.txt")) {
            byte[] arr = new byte[50];
            int x;
            while ((x = in.read(arr)) != -1) {
                System.out.println(new String(arr, 0, x));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
