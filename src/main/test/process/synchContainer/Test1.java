package process.synchContainer;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test1 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
        list.add(2);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2)
                list.remove(integer);
        }
    }
}