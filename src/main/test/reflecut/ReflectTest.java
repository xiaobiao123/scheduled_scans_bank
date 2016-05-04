package reflecut;

import java.lang.reflect.Field;

public class ReflectTest {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception {
        /**
         * 获得字节码对应的实例对象的 3 种方式 以 String 为例
         */
        // String testStr = "goodleiwei";
        // Class getClassWay1 = testStr.getClass();
        // Class getClassWay2 = String.class;
        // Class getClassWay3 = Class.forName("java.lang.String");
        // System.out.println(getClassWay1 == getClassWay2);
        // System.out.println(getClassWay2 == getClassWay3);
        //

        /**
         * 构造方法的反射应用：构造方法是产生对象的根本途径 获得一个类的所有构造方法 Constructor[] getConstructor =
         * Class.forName("java.lang.String").getConstructors();
         */
        // String str1 = (String)
        // Class.forName("java.lang.String").newInstance(); // 默认构造方法
        // // 得到字节码产生实例对象
        //
        // String str2 = (String) Class.forName("java.lang.String") //
        // 得到字节码即事例对象
        // .getConstructor(StringBuffer.class) // 获得该对象中的特定构造器
        // .newInstance(new StringBuffer("abc")); // 根据构造器产生对象实例
        // System.out.println(str2.charAt(2));
        /**
         * 成员变量的反射 Field
         */
        UserRe user2 = new UserRe(3, 5);
        Field fieldX = user2.getClass().getField("x");
        // fieldX 的值是多少 ? 是 3, 错 !fieldX 不是对象身上的变量，而是类上的变量。要用 fieldX 到某个对象上去取值如：
        System.out.println(fieldX.get(user2));

    }

    private static void changStringValue(Object obj) throws IllegalArgumentException, IllegalAccessException {

        // 得到 obj 类中所有的属性字段
        Field[] fields = obj.getClass().getFields();
        for (Field field : fields) {
            if (field.getType() == String.class) {
                // 得到 obj 类身上的 filed 字段的值
                String oldStrValue = (String) field.get(obj);
                // 替换 obj 类身上的 filed 字段的值
                String newStrValue = oldStrValue.replace('s', 'H');
                field.set(obj, newStrValue);
            }
        }
    }

}
