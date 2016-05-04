package dynamic.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestInval implements InvocationHandler {
    // method.invoke(target, args); target 被代理的对象 ，
    private Object target;

    public Object bind(Object object) {
        this.target = object;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method.invoke(target, args); target 被代理的对象 ，
        before();
        Object object = method.invoke(target, args);
        after();
        return object;
    }

    // private Object target;
    //
    // public Object bind(Object obj) {
    // this.target = obj;
    // return Proxy.newProxyInstance(target.getClass().getClassLoader(),
    // target.getClass().getInterfaces(), this);
    // }
    //
    // @SuppressWarnings("unused")
    // @Override
    // public Object invoke(Object proxy, Method method, Object[] args) throws
    // Throwable {
    // before();
    // Object obj = method.invoke(target, args);
    // System.out.println("method_name=" + method.getName());
    // for (Object ob : args) {
    // if (ob instanceof String[]) {
    // String[] ss = (String[]) ob;
    // for (String str : ss) {
    // System.out.println("method_name=" + str.toString());
    // }
    // }
    //
    // }
    // after();
    // return null;
    // }

    public void before() {
        System.out.println("----------------before-------------------");
    }

    public void after() {
        System.out.println("----------------after-------------------");
    }

}
