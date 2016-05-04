package threadparam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过变量和方法传递数据
 * 
 * @Description:
 * @author gwb
 * @date 2016年1月27日 上午10:43:58
 * 
 */
public class ThreadParam02 implements Runnable {

    @Override
    public void run() {
        System.out.println("hello " + name);

    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ThreadParam02 myThread = new ThreadParam02();
        myThread.setName("world");
        Thread thread = new Thread(myThread);
        // thread.start();

        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(thread);
        pool.shutdown();
    }
}
