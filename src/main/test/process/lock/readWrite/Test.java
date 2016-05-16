package process.lock.readWrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public volatile int inc = 0;
    private Object obect = new Object();

    private Lock lock = new ReentrantLock();

    // public void increase() {
    // synchronized (obect) {
    // inc++;
    // }
    //
    // }

    public void increase() {
        lock.lock();
        try {
            inc++;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        final Test test = new Test();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                };
            }.start();
        }

        while (Thread.activeCount() > 1)
            // 保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}