package reflecut;

public class UserRe {
    public String name1 = "zhangsan";
    public String name2 = "lisi";
    public String name3 = "wangwu";

    public int x;
    private int y;

    public UserRe() {
    }

    public UserRe(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return name1 + ":" + name2 + ":" + name3;
    }

    public static void main(String[] args) {
        for (String string : args) {
            System.out.println(string);
        }
    }

}