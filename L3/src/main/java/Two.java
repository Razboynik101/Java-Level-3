import java.io.*;
public class Two {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("Doc/two/target.txt")) {
            for (int i = 1; i < 6; i++) {
                String adress = String.format("Doc/two/%s.txt", i);
                try (FileInputStream in = new FileInputStream(adress)) {
                    int x;
                    while ((x = in.read()) != -1) {
                        writer.append((char) x);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

