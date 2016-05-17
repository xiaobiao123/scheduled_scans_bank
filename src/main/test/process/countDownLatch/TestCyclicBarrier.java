package process.countDownLatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>
 * CyclicBarrier类位于java.util.concurrent包下，CyclicBarrier提供2个构造器：
 * 
 * <p>
 * public CyclicBarrier(int parties, Runnable barrierAction) { }
 * 
 * <p>
 * public CyclicBarrier(int parties) { } 　　
 * <p>
 * 参数parties指让多少个线程或者任务等待至barrier状态；参数barrierAction为当这些线程都达到barrier状态时会执行的内容。
 * 
 * <p>
 * 然后CyclicBarrier中最重要的方法就是await方法，它有2个重载版本：
 * 
 * <p>
 * public int await() throws InterruptedException, BrokenBarrierException { };
 * <p>
 * public int await(long timeout, TimeUnit unit)throws
 * <p>
 * InterruptedException,BrokenBarrierException,TimeoutException { }; 　　
 * <p>
 * 第一个版本比较常用，用来挂起当前线程，直至所有线程都到达barrier状态再同时执行后续任务；
 * 
 * <p>
 * 　第二个版本是让这些线程等待至一定的时间，如果还有线程没有到达barrier状态就直接让到达barrier的线程执行后续任务。
 * 
 * @Description:
 * @author gwb
 * @date 2016年5月17日 上午10:20:41
 * 
 */
public class TestCyclicBarrier {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++)
            new Writer(barrier).start();
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(5000); // 以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}