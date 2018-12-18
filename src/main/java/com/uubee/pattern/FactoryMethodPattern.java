package com.uubee.pattern;

import sun.applet.Main;

/**
 * @author: zhengcs
 * @Desc: 工厂方法
 * @Date: 2018/12/4 20:00
 * @Modified:
 **/
public class FactoryMethodPattern {

    interface PayChnl{
        void pay();
    }

    class AliPay implements PayChnl{

        @Override
        public void pay(){
            System.out.println("支付宝支付");
        }
    }

    class WechatPay implements PayChnl{

        @Override
        public void pay(){
            System.out.println("微信支付");
        }
    }

    interface PayChnlFactory{
        PayChnl getPayChnl();
    }

    class AliPayFactory implements PayChnlFactory{

        @Override
        public PayChnl getPayChnl() {
            return new AliPay();
        }
    }

    class WechatPayFactory implements PayChnlFactory{

        @Override
        public PayChnl getPayChnl() {
            return new WechatPay();
        }
    }



    public static void main(String[] args) {

        FactoryMethodPattern factoryMethodPattern = new FactoryMethodPattern();

        WechatPayFactory wechatPayFactory = factoryMethodPattern.new WechatPayFactory();
        PayChnl wechatPay = wechatPayFactory.getPayChnl();
        wechatPay.pay();

    }



}
