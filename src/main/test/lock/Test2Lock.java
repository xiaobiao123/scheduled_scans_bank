package lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 首先lock()方法是平常使用得最多的一个方法，就是用来获取锁。如果锁已被其他线程获取，则进行等待。
 * 
 * @Description:
 * @author gwb
 * @date 2016年3月30日 下午1:47:57
 * 
 */
public class Test2Lock {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock(); // 注意这个地方

    public static void main(String[] args) {
        final Test2Lock test = new Test2Lock();

        new Thread() {
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();

        new Thread() {
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }

    public void insert(Thread thread) {
        lock.lock();
        try {
            System.out.println(thread.getName() + "得到了锁");
            for (;;) {
                arrayList.add(0);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.out.println(thread.getName() + "释放了锁");
            lock.unlock();
        }
    }
}