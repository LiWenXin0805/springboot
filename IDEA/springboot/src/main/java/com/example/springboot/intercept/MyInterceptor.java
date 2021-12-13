package com.example.springboot.intercept;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author LWX
 */
public class MyInterceptor implements Interceptor{
    /**
     * 事前方法
     *
     * @return 事前方法
     */
    @Override
    public boolean before() {
        System.out.println("before......");
        return true;
    }

    /**
     * 事后方法
     */
    @Override
    public void after() {
        System.out.println("after......");
    }

    /**
     * 取代原有事件方法
     *
     * @param invocation 毁掉啊参数 通过 proceed 方法回调原有事件
     * @return 原有事件返回对象
     * @throws InvocationTargetException a
     * @throws IllegalAccessException    a
     */
    @Override
    public Object around(Invocation invocation) throws Throwable {
        System.out.println("around before......");
        Object obj = invocation.proceed();
        System.out.println("around after......");
        return obj;
    }

    /**
     * 事后返回方法，没有异常时执行
     */
    @Override
    public void afterRunning() {
        System.out.println("afterRunning......");
    }

    /**
     * 事后异常方法，当事件发生异常后执行
     */
    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing......");
    }

    /**
     * 判断是否使用 around 方法替代原有方法
     *
     * @return 是否使用 around 方法替代原有方法
     */
    @Override
    public boolean userAround() {
        return true;
    }
}
