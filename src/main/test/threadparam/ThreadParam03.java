package threadparam;

/**
 * 通过回调函数传递数据
 * 
 * @Description:
 * @author gwb
 * @date 2016年1月27日 上午10:44:11
 * 
 */
public class ThreadParam03 extends Thread {
    private Work work;

    public ThreadParam03(Work work) {
        this.work = work;
    }

    public void run() {
        java.util.Random random = new java.util.Random();
        Data data = new Data();
        int n1 = random.nextInt(1000);
        int n2 = random.nextInt(2000);
        int n3 = random.nextInt(3000);
        work.process(data, n1, n2, n3); // 使用回调函数
        System.out.println(String.valueOf(n1) + "+" + String.valueOf(n2) + "+" + String.valueOf(n3) + "=" + data.value);
    }

    public static void main(String[] args) {
        Thread thread = new ThreadParam03(new Work());
        thread.start();
    }

}
