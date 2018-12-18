package com.uubee.pattern;

import sun.security.jca.GetInstance;

/**
 * @author: zhengcs
 * @Desc: 单例模式
 * @Date: 2018/12/16 23:16
 * @Modified:
 **/
public class SingletonPattern {


    /**
    *@Desc: 懒汉式
    *@Author: zhengcs
    *@Date: 2018/12/16 23:25
    *@Modified: 
    */
    static class Singleton1{
        private static Singleton1 instance;

        private Singleton1(){}

        public static Singleton1 getInstance(){
            if(null == instance){
                instance = new Singleton1();
            }

            return instance;
        }
    }


    /**
    *@Desc: synchronized实现线程安全
    *@Author: zhengcs
    *@Date: 2018/12/16 23:29
    *@Modified: 
    */
    static class Singleton2{
        private static Singleton2 instance;

        private Singleton2(){}

        public static synchronized Singleton2 getInstance(){
            if(null == instance){
                instance = new Singleton2();
            }

            return instance;
        }
    }

    /**
    *@Desc: 双重检查锁定
    *@Author: zhengcs
    *@Date: 2018/12/16 23:33
    *@Modified: 
    */
    static class Singleton3{
        private static Singleton3 instance;

        private Singleton3(){}

        public static Singleton3 getInstance(){
            if(null == instance){
                synchronized (Singleton3.class){
                    if(null == instance){
                        instance = new Singleton3();
                    }
                }
            }

            return instance;
        }
    }

    /**
    *@Desc: 饿汉式
    *@Author: zhengcs
    *@Date: 2018/12/16 23:36
    *@Modified: 
    */
    static class Singleton4{
        private static Singleton4 instance = new Singleton4();
        private Singleton4(){}

        public static Singleton4 getInstance(){
            return instance;
        }
    }

    /**
    *@Desc: 静态内部类
    *@Author: zhengcs
    *@Date: 2018/12/16 23:43
    *@Modified: 
    */
    static class Singleton5{
        static class InnerC {
            private static Singleton5 instance = new Singleton5();
        }

        private Singleton5(){}

        private static Singleton5 getInstance(){
            return InnerC.instance;
        }
    }
    

    
}
