package reflecut;


class superClass {
    // super class
}

class subClass extends superClass {
    // sub class
}

public class ClassDemo {

    public static void main(String args[]) {

        superClass val1 = new superClass();
        subClass val2 = new subClass();
        Class cls;

        cls = val1.getClass();
        System.out.println("val1 is object of type = " + cls.getName());

        /*
         * returns the superclass of the class(superClass) represented by this
         * object
         */
        cls = cls.getSuperclass();
        System.out.println("super class of val1 = " + cls.getName());

        cls = val2.getClass();
        System.out.println("val2 is object of type = " + cls.getName());

        /*
         * returns the superclass of the class(subClass) represented by this
         * object
         */
        cls = cls.getSuperclass();
        System.out.println("super class of val2 = " + cls.getName());
    }
}