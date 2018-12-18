package com.uubee.pattern;

/**
 * @author: zhengcs
 * @Desc: 抽象工厂模式
 * @Date: 2018/12/16 22:32
 * @Modified:
 **/
public class AbstractFactoryPattern {

    interface PayChnl{
        void pay();
    }

    class AliPay implements PayChnl {

        @Override
        public void pay(){
            System.out.println("支付宝支付");
        }
    }

    class WechatPay implements PayChnl {

        @Override
        public void pay(){
            System.out.println("微信支付");
        }
    }

    interface RunEnv{
        void run();
    }

    class H5RunEnv implements RunEnv{
        @Override
        public void run(){
            System.out.println("H5运行环境");
        }
    }

    class WXRunEnv implements RunEnv{
        @Override
        public void run(){
            System.out.println("微信运行环境");
        }
    }

    interface AbstractFactory{
        public PayChnl getChnl();

        public RunEnv getEnv();
    }

    class H5WechatFactory implements AbstractFactory{

        @Override
        public PayChnl getChnl() {
            return new WechatPay();
        }

        @Override
        public RunEnv getEnv() {
            return new H5RunEnv();
        }
    }

    class WXAliFactory implements AbstractFactory{

        @Override
        public PayChnl getChnl() {
            return new AliPay();
        }

        @Override
        public RunEnv getEnv() {
            return new WXRunEnv();
        }
    }

    public static void main(String[] args) {

        AbstractFactoryPattern abstractFactoryPattern = new AbstractFactoryPattern();

        H5WechatFactory h5WechatFactory = abstractFactoryPattern.new H5WechatFactory();
        PayChnl payChnl = h5WechatFactory.getChnl();
        RunEnv runEnv = h5WechatFactory.getEnv();
        runEnv.run();
        payChnl.pay();
    }
}
