package com.uubee.pattern;

/**
 * @author: zhengcs
 * @Desc: 装饰模式
 * @Date: 2018/12/18 13:49
 * @Modified:
 **/
public class DecoratePattern {

    interface Hamburger{
        void buy();
    }

    class BuyHamburger implements Hamburger{

        @Override
        public void buy() {
            System.out.println("买一个汉堡");
        }
    }

    class Decorator implements Hamburger{

        private Hamburger hamburger;

        public Decorator(Hamburger hamburger){
            this.hamburger = hamburger;
        }

        public void prepare(){
            System.out.println("我要买一个牛肉汉堡");
        }

        public void after(){
            System.out.println("牛肉汉堡真好吃");
        }


        @Override
        public void buy() {
            prepare();
            hamburger.buy();
            after();
        }
    }

    public static void main(String[] args) {
        DecoratePattern decoratePattern = new DecoratePattern();
        BuyHamburger buyHamburger = decoratePattern.new BuyHamburger();
        Decorator decorator = decoratePattern.new Decorator(buyHamburger);
        decorator.buy();

    }
}
