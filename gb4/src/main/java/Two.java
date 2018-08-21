import java.io.FileOutputStream;
import java.io.IOException;
public class Two {
    public static void main(String[] args) throws IOException {
        final FileOutputStream out = new FileOutputStream("Doc/one.txt");
        final String str1 = "string 1\n";
        final String str2 = "string 2\n";
        final String str3 = "string 3\n";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        out.write(str1.getBytes());
                        Thread.sleep(20);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        out.write(str2.getBytes());
                        Thread.sleep(20);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        out.write(str3.getBytes());
                        Thread.sleep(20);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
