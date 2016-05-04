package reflecut;

/**
 * @ClassName: Test
 * @Description: 测试类
 * @author JoseanLuo
 * @date 2014-3-16 下午8:47:46
 * @version V1.0
 */
public class Test {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String doRun(String pk, String testrun) {
        return pk + testrun;
    }
}

class Person {
    private String perName;
    private String perAge;

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public String getPerAge() {
        return perAge;
    }

    public void setPerAge(String perAge) {
        this.perAge = perAge;
    }

}