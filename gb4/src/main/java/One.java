class One {
    static Object mon = new Object();
    static volatile char currnetL = 'A';
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (mon) {
                            while (currnetL != 'A') {
                                mon.wait();
                            }
                            System.out.print("A");
                            currnetL = 'B';
                            mon.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (mon) {
                            while (currnetL != 'B') {
                                mon.wait();
                            }
                            System.out.print("B");
                            currnetL = 'C';
                            mon.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (mon) {
                            while (currnetL != 'C') {
                                mon.wait();
                            }
                            System.out.print("C");
                            currnetL = 'A';
                            mon.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}

