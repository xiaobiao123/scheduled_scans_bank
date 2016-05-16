package process.synchContainer;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 性能问题
 * 
 * @Description:
 * @author gwb
 * @date 2016年5月16日 下午4:00:41
 * 
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Vector<Integer> vector = new Vector<Integer>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++)
            list.add(i);
        long end = System.currentTimeMillis();
        System.out.println("ArrayList进行100000次插入操作耗时：" + (end - start) + "ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++)
            vector.add(i);
        end = System.currentTimeMillis();
        System.out.println("Vector进行100000次插入操作耗时：" + (end - start) + "ms");
    }
}