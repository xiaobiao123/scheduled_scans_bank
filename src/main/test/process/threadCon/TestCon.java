package process.threadCon;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 在Java的集合容器框架中，主要有四大类别：List、Set、Queue、Map。
 * 
 * 　　List、Set、Queue接口分别继承了Collection接口，Map本身是一个接口。
 * 
 * 　　注意Collection和Map是一个顶层接口，而List、Set、Queue则继承了Collection接口，分别代表数组、集合和队列这三大类容器。
 * 
 * 　　像ArrayList、LinkedList都是实现了List接口，HashSet实现了Set接口，而Deque（双向队列，允许在队首、
 * 队尾进行入队和出队操作
 * ）继承了Queue接口，PriorityQueue实现了Queue接口。另外LinkedList（实际上是双向链表）实现了了Deque接口。
 * 
 * @Description:
 * @author gwb
 * @date 2016年5月10日 下午4:46:34
 * 
 */

/**
 * 在Java中，同步容器主要包括2类： Vector、Stack、HashTable
 * <p>
 * 2）Collections类中提供的静态工厂方法创建的类
 * 
 * @Description:
 * @author gwb
 * @date 2016年5月10日 下午4:46:53
 * 
 */

public class TestCon {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Vector<Integer> vector = new Vector<Integer>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
            list.add(i);
        long end = System.currentTimeMillis();
        System.out.println("ArrayList进行100000次插入操作耗时：" + (end - start) + "ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
            vector.add(i);
        end = System.currentTimeMillis();
        System.out.println("Vector进行100000次插入操作耗时：" + (end - start) + "ms");
    }
}