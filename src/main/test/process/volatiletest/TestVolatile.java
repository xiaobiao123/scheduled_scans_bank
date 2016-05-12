package process.volatiletest;

public class TestVolatile {
    public volatile int inc = 0;

    // 在前面已经提到过，自增操作是不具备原子性的,它包括读取变量的原始值、进行加1操作、
    // 写入工作内存。那么就是说自增操作的三个子操作可能会分割开执行
    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final TestVolatile test = new TestVolatile();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                };
            }.start();
        }

        while (Thread.activeCount() > 1)
            // 保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}