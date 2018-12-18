package com.uubee.pattern;

/**
 * @author: zhengcs
 * @Desc: 适配器模式
 * @Date: 2018/12/18 12:48
 * @Modified:
 **/
public class AdapterPattern {

    interface Target{
        void standard();
    }

    interface Adaptee{
        void nonStandard();
    }

    class AdapteeImpl implements Adaptee{

        @Override
        public void nonStandard() {
            System.out.println("这个接口不标准");
        }
    }

    class Adaptor implements Target{
        private Adaptee adaptee;

        public Adaptor(Adaptee adaptee){
            this.adaptee = adaptee;
        }

        @Override
        public void standard() {
            adaptee.nonStandard();
            System.out.println("现在是标准输出了");
        }
    }

    public static void main(String[] args) {

        AdapterPattern adapterPattern = new AdapterPattern();
        Adaptor adaptor = adapterPattern.new Adaptor(adapterPattern.new AdapteeImpl());
        adaptor.standard();
    }
}
