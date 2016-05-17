package process.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * public CountDownLatch(int count);
 * <p>
 * public void countDown();
 * <p>
 * public void await() throws InterruptedException
 * 
 * 构造方法参数指定了计数的次数 countDown方法，
 * <p>
 * 当前线程调用此方法，则计数减一 awaint方法，
 * <p>
 * 调用此方法会一直阻塞当前线程，直到计时器的值为0
 * 
 * @Description:
 * @author gwb
 * @date 2016年5月17日 上午10:09:22
 * 
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread() {
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread() {
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}