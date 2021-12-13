package com.example.springboot.intercept;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author LWX
 */
public interface Interceptor {

    /**
     * 事前方法
     * @return 事前方法
     */
    boolean before();

    /**
     * 事后方法
     */
    void after();

    /**
     * 取代原有事件方法
     * @param invocation 毁掉啊参数 通过 proceed 方法回调原有事件
     * @return 原有事件返回对象
     * @throws Throwable a
     */
    Object around(Invocation invocation) throws Throwable;

    /**
     * 事后返回方法，没有异常时执行
     */
    void afterRunning();

    /**
     * 事后异常方法，当事件发生异常后执行
     */
    void afterThrowing();

    /**
     * 判断是否使用 around 方法替代原有方法
     * @return 是否使用 around 方法替代原有方法
     */
    boolean userAround();

}
