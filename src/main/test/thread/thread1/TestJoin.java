package thread.thread1;

import java.io.IOException;

/**
 * 调用thread.join方法，则main方法会等待thread线程执行完毕或者等待一定的时间。如果调用的是无参join方法，则等待thread执行完毕，
 * 如果调用的是指定了时间参数的join方法，则等待一定的事件。
 * <p>
 * 实际上调用join方法是调用了Object的wait方法，这个可以通过查看源码得知：
 * 
 * @Description:
 * @author gwb
 * @date 2016年5月5日 下午7:49:07
 * 
 */
public class TestJoin {

    public static void main(String[] args) throws IOException {
        System.out.println("进入线程" + Thread.currentThread().getName());
        TestJoin test = new TestJoin();
        MyThread thread1 = test.new MyThread();
        thread1.start();
        try {
            System.out.println("线程" + Thread.currentThread().getName() + "等待");
            thread1.join();
            System.out.println("线程" + Thread.currentThread().getName() + "继续执行");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("进入线程" + Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
            System.out.println("线程" + Thread.currentThread().getName() + "执行完毕");
        }
    }
}