package process.lock.readWrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 不过要注意的是，如果有一个线程已经占用了读锁，则此时其他线程如果要申请写锁，则申请写锁的线程会一直等待释放读锁。
 * 
 * <p>
 * 1）Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现；
 * 
 * 　　2）synchronized在发生异常时，会自动释放线程占有的锁，因此不会导致死锁现象发生；而Lock在发生异常时，如果没有主动通过unLock()
 * 去释放锁，则很可能造成死锁现象，因此使用Lock时需要在finally块中释放锁；
 * 
 * 　　3）Lock可以让等待锁的线程响应中断，而synchronized却不行，使用synchronized时，等待的线程会一直等待下去，不能够响应中断；
 * 
 * 　　4）通过Lock可以知道有没有成功获取锁，而synchronized却无法办到。
 * 
 * 　　5）Lock可以提高多个线程进行读操作的效率。
 * 
 * @Description:
 * @author gwb
 * @date 2016年4月5日 下午9:34:36
 * 
 */
public class TestReadWirte {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final TestReadWirte test = new TestReadWirte();

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