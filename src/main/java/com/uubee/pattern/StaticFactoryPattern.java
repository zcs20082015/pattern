package com.uubee.pattern;

/**
*@Desc: 静态工厂
*@Author: zhengcs
*@Date: 2018/12/16 22:02
*@Modified: 
*/
public class StaticFactoryPattern {

    public interface PayChnl{
        public void pay();
    }

    public class AliPay implements PayChnl{

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

    public class StaticPayFactory{
        public PayChnl getPayChnl(String chnl){

            if("ali".equals(chnl)){
                return new AliPay();
            }else if("wechat".equals(chnl)){
                return new WechatPay();
            }else{
                return null;
            }
        }
    }

    public static void main(String[] args) {

        StaticFactoryPattern staticFactoryPattern = new StaticFactoryPattern();

        StaticPayFactory staticPayFactory = staticFactoryPattern.new StaticPayFactory();
        PayChnl aliPay = staticPayFactory.getPayChnl("ali");
        aliPay.pay();

    }
}
