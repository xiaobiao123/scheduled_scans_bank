package dynamic.proxy1;

public class TestProxy {

    public static void main(String[] args) {
        TestInval proxy = new TestInval();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookProxy.addBook("my", "33333333333");
    }

}