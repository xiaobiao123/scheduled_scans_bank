package process.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。示例代码如下：
 * 
 * @Description:
 * @author gwb
 * @date 2016年5月16日 上午11:13:43
 * 
 *       <P>
 *       因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。 定长线程池的大小最好根据系统资源进行设置
 */
public class NewFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        fixedThreadPool.shutdown();
    }
}
