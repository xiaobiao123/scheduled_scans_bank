package threadTest;

public class TheadTest implements Runnable {

    @Override
    public void run() {
        System.out.println("run test");
    }

    public static void main(String[] args) {
        new Thread(new TheadTest()).start();
    }
}
