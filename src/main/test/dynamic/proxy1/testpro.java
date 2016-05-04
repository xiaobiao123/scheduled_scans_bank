package dynamic.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class testpro implements InvocationHandler {

    private Object object;

    public Object bind(Object target) {
        this.object = target;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("开始处理");
        result = method.invoke(object, args);
        System.out.println("结束处理");
        return result;
    }
}
