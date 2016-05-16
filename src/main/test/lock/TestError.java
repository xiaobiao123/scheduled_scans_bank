package lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestError {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        final TestError test = new TestError();
        Thread ss = new Thread() {
            public void run() {
                test.insert(Thread.currentThread());
            };
        };
        ss.start();

        Thread ss2 = new Thread() {

            public void run() {
                test.insert(Thread.currentThread());
            };
        };

        ss2.start();
        Thread.sleep(1000);
        ss2.interrupt();

    }

    public void insert(Thread thread) {
        System.out.println(thread.getName() + "得到了锁");
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        long startTime = System.currentTimeMillis();
        try {
            for (int i = 0; i <= 5; i++) {
                if (System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(thread.getName() + "释放了锁");
            lock.unlock();
        }
    }
}
