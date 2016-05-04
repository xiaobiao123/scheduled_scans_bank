package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * 说明thread1和thread2在同时进行读操作。
 * 
 * 　　这样就大大提升了读
 * 
 * <p>
 * 操作的效率。 　不过要注意的是，如果有一个线程已经占用了读锁，则此时其他线程如果要申请写锁，则申请写锁的线程会一直等待释放读锁。
 * 
 * 　　如果有一个线程已经占用了写锁，则此时其他线程如果申请写锁或者读锁，则申请的线程会一直等待释放写锁
 * 
 * @Description:
 * @author gwb
 * @date 2016年3月30日 下午1:53:45
 * 
 */
public class TestTestReentrantReadWriteLockRead {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final TestTestReentrantReadWriteLockRead test = new TestTestReentrantReadWriteLockRead();

        new Thread() {
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

        new Thread() {
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

    }

    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }
}