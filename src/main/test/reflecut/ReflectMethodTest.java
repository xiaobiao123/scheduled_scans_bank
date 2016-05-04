package reflecut;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName: ReflectMethodTest
 * @Description: 反射方法测试
 * @author JoseanLuo
 * @date 2014-3-18 下午8:53:51
 * @version V1.0
 */
public class ReflectMethodTest {
    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("reflecut.Test");
        System.out.println(clz);
        Test test = (Test) clz.newInstance();
        test.setAge("age");
        test.setName("name");

        Method mt = clz.getMethod("doRun", new Class[] { String.class, String.class });
        Method[] mts = clz.getDeclaredMethods();

        for (Method method : mts) {
            System.out.println(method.getName());
        }

        Field[] fields = clz.getDeclaredFields();

        for (Field fi : fields) {
            fi.setAccessible(true);
            System.out.println(fi.getType());
            System.out.println(fi.get(test));
            fi.set(test, "xxxxxxxxxx");
        }
        System.out.println(test.getAge());
        System.out.println(mt);
        System.out.println(mt.invoke(test, new Object[] { "i love you ", "i fuck you", }));
    }

}