import java.io.*;

public class Three {
    public static void main(String[] args) {
File file = new File("Doc/third/scanned.txt");
PFG mfu = new PFG();
mfu.scan(file);
mfu.print();
    }
}

class PFG {
    static Object mon = new Object();
    int pagePrintNum = 0;
    int pageScanNum = 0;

    File toScan;
    File toPrint;


    byte[] arr = new byte[500];

    boolean isScanEmpty = true;
    boolean isPrintEmpty = true;

    PFG() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (!isScanEmpty) {
                        try {

                            FileInputStream in = new FileInputStream(toScan);
                            in.read(arr);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (!isPrintEmpty) {
                        int i = 0;
                        int x;
                        while ((x = arr[i]) != -1) {
                            System.out.println(new String(arr));
                            i++;
                            }
                        }
                    }
                }

        }).start();
    }

    public void scan(File file) {
        this.toScan = file;
        isScanEmpty = false;
    }

    public void print() {
        isPrintEmpty = false;
    }

}
