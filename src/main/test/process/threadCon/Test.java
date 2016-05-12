package process.threadCon;

import java.util.Vector;

public class Test {
    static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            for (int i = 0; i < 10; i++)
                vector.add(i);
            Thread thread1 = new Thread() {
                public void run() {
                    synchronized (Test.class) { // 进行额外的同步
                        for (int i = 0; i < vector.size(); i++)
                            vector.remove(i);
                    }
                };
            };
            Thread thread2 = new Thread() {
                public void run() {
                    synchronized (Test.class) {
                        for (int i = 0; i < vector.size(); i++)
                            vector.get(i);
                    }
                };
            };
            thread1.start();
            thread2.start();
            while (Thread.activeCount() > 10) {

            }
        }
    }
}