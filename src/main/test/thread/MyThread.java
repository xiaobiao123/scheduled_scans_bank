package thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            new Thread().sleep(120l);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
    }

    public static void main(String[] args) {
        Thread thred = new MyThread();
        thred.start();
    }
}
