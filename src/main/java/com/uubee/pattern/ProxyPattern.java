package com.uubee.pattern;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: zhengcs
 * @Desc: 代理模式
 * @Date: 2018/12/18 10:28
 * @Modified:
 **/
public class ProxyPattern {

    interface BuyCar{
        void buy();
    }

    class Buyer implements BuyCar{

        public Buyer(){}

        @Override
        public void buy() {
            System.out.println("买车");
        }

    }

    class Proxy4S implements BuyCar{

        private BuyCar buyCar;

        public Proxy4S(BuyCar buyCar){
            this.buyCar = buyCar;
        }

        @Override
        public void buy() {
            System.out.println("介绍车辆");
            buyCar.buy();
            System.out.println("售后");
        }
    }

    class DynamicProxyHandler implements InvocationHandler{

        private Object object;

        public DynamicProxyHandler(final Object object){
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("执行前");
            Object result = method.invoke(object,args);
            System.out.println("执行后");

            return result;
        }
    }

    class CglibProxy implements MethodInterceptor{

        private  Object target;

        public Object getInstance(final Object target){
            this.target = target;
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(this.target.getClass());
            enhancer.setCallback(this);
            return enhancer.create();
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("执行前");
            Object result = methodProxy.invoke(target,objects);
            System.out.println("执行后");

            return result;
        }
    }

    public static void main(String[] args) {
        ProxyPattern proxyPattern = new ProxyPattern();
        ProxyPattern.Buyer buyer =  proxyPattern.new Buyer();
        /*ProxyPattern.Proxy4S proxy4S = proxyPattern.new Proxy4S(buyer);
        proxy4S.buy();

        ProxyPattern.DynamicProxyHandler dynamicProxyHandler = proxyPattern.new DynamicProxyHandler(buyer);

        BuyCar proxy = (BuyCar) Proxy.newProxyInstance(BuyCar.class.getClassLoader(),new Class[]{BuyCar.class},dynamicProxyHandler);
        proxy.buy();*/

        CglibProxy cglibProxy = proxyPattern.new CglibProxy();
        Buyer buyer2 = (Buyer) cglibProxy.getInstance(buyer);
        buyer2.buy();



    }
}
