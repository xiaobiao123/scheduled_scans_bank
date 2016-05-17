package process.copyOnWrite;

import java.util.ArrayList;
import java.util.List;

/**
 * 这段代码运行的时候就会抛出java.util.ConcurrentModificationException错误。这是因为主线程在遍历list的时候，
 * 子线程在向list中添加元素。
 * 
 * @Description:
 * @author gwb
 * @date 2016年5月17日 上午9:58:20
 * 
 */
public class ResourceList {

    public static void main(String[] args) throws InterruptedException {
        List<String> a = new ArrayList<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        final ArrayList<String> list = new ArrayList<String>(a);
        Thread t = new Thread(new Runnable() {
            int count = -1;

            @Override
            public void run() {
                while (true) {
                    list.add(count++ + "");
                }
            }
        });
        t.setDaemon(true);
        t.start();
        Thread.currentThread().sleep(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}