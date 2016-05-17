package process.copyOnWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList类最大的特点就是，在对其实例进行修改操作（add/remove等）会新建一个数据并修改，修改完毕之后，
 * 再将原来的引用指向新的数组。这样，修改过程没有修改原来的数组。也就没有了ConcurrentModificationException错误。
 * 
 * @Description:
 * @author gwb
 * @date 2016年5月17日 上午9:58:51
 * 
 */
public class ResourceCopyOnWriteArrayList {

    public static void main(String[] args) throws InterruptedException {
        List<String> a = new ArrayList<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>(a);
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
            System.out.println(list.hashCode());
            System.out.println(s);
        }
    }
}