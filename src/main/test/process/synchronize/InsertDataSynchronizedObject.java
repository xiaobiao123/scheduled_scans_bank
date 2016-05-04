package process.synchronize;

import java.util.ArrayList;

/**
 * synchronized代码块使用起来比synchronized方法要灵活得多。因为也许一个方法中只有一部分代码只需要同步，
 * 如果此时对整个方法用synchronized进行同步
 * ，会影响程序执行效率。而使用synchronized代码块就可以避免这个问题，synchronized代码块可以实现只对需要同步的地方进行同步。
 * 
 * @Description:
 * @author gwb
 * @date 2016年4月5日 下午8:22:27
 * 
 */
class InsertDataSynchronizedObject {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Object object = new Object();

    public void insert(Thread thread) {
        synchronized (object) {
            for (int i = 0; i < 100; i++) {
                System.out.println(thread.getName() + "在插入数据" + i);
                arrayList.add(i);
            }
        }
    }
}