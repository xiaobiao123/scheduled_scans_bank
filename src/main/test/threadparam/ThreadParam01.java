package threadparam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过构造方法传递数据
 * 
 * @Description:
 * @author gwb
 * @date 2016年1月27日 上午10:43:46
 * 
 */
public class ThreadParam01 extends Thread {
    private String name;

    public ThreadParam01(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("hello " + name);
    }

    public static void main(String[] args) {
        ExecutorService pol = Executors.newSingleThreadExecutor();
        Thread thread = new ThreadParam01("world");
        pol.execute(thread);
        pol.shutdown();
    }
}
