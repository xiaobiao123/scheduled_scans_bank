package dynamic.proxy1;

public class BookFacadeImpl implements BookFacade {

    @Override
    public void addBook(String... names) {
        for (String name : names) {
            System.out.println("增加图书方法。。。" + name);
        }

    }
}