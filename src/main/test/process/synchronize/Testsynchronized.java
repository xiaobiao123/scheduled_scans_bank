package process.synchronize;

public class Testsynchronized {

    public static void main(String[] args) {
        final InsertDataSynchronized insertData = new InsertDataSynchronized();

        new Thread() {
            public void run() {
                insertData.insert(Thread.currentThread());
            };
        }.start();

        new Thread() {
            public void run() {
                insertData.insert(Thread.currentThread());
            };
        }.start();
    }
}
