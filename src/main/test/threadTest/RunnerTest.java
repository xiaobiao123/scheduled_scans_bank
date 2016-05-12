package threadTest;

public class RunnerTest extends Thread {

    private int num = 0;

    private RunnerTest() {
        num++;
    }

    @Override
    public void run() {

        System.out.println("run test:" + num + "   " + Thread.currentThread().getId());
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getId());
        RunnerTest te = new RunnerTest();
        te.start();
    }
}
