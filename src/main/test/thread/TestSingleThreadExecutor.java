package thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestSingleThreadExecutor {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();

        Future<Integer> ss = pool.submit(getTask());
        System.out.println(ss.get());

        Future<Integer> sss = pool.submit(getTask01());
        pool.shutdown();

        // ExecutorService pol = Executors.newSingleThreadExecutor();
        //
        // Thread ts = new MyThread();
        // pol.equals(ts);

        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        // Thread t1 = new MyThread();
        // Thread t2 = new MyThread();
        // Thread t3 = new MyThread();
        // Thread t4 = new MyThread();
        // Thread t5 = new MyThread();
        // // // 将线程放入池中进行执行
        // pool.execute(t1);
        // pool.execute(t2);
        // pool.execute(t3);
        // pool.execute(t4);
        // pool.execute(t5);
        // // 关闭线程池
        // pool.shutdown();
    }

    // 得到一个任务
    public static Callable<Integer> getTask() {
        final Random rand = new Random();
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int i = rand.nextInt(10);
                int j = rand.nextInt(10);
                int sum = i * j;
                System.out.print(sum + "\t");
                return sum;
            }
        };
        return task;
    }

    public static Callable<Integer> getTask01() {
        Callable<Integer> task = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                testCall();
                System.out.println("测试");
                return 123;
            }

        };

        return task;
    }

    @SuppressWarnings("static-access")
    public static void testCall() throws InterruptedException {
        new Thread().sleep(200);
        System.out.println("xxxxxxxxxxxx");
    }

}
