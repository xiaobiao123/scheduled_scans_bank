package process.synchronize;

/**
 * 每个类也会有一个锁，它可以用来控制对static数据成员的并发访问。
 * <p>
 * 并且如果一个线程执行一个对象的非static synchronized方法，另外一个线程需要执行这个对象所属类的static
 * synchronized方法，此时不会发生互斥现象，因为访问static synchronized方法占用的是类锁，而访问非static
 * synchronized方法占用的是对象锁，所以不存在互斥现象。>
 * 
 * @Description:
 * @author gwb
 * @date 2016年4月5日 下午8:23:21
 * 
 *       <p>
 *       synchronized代码块实际上多了monitorenter和monitorexit两条指令。
 *       monitorenter指令执行时会让对象的锁计数加1，而monitorexit指令执行时会让对象的锁计数减1
 */
public class Test {

    public static void main(String[] args) {
        final InsertData insertData = new InsertData();
        new Thread() {
            @Override
            public void run() {
                insertData.insert();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                insertData.insert1();
            }
        }.start();
    }
}

class InsertData {
    public synchronized void insert() {
        System.out.println("执行insert");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行insert完毕");
    }

    public synchronized static void insert1() {
        System.out.println("执行insert1");
        System.out.println("执行insert1完毕");
    }
}