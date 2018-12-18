package com.uubee.pattern;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

/**
 * @author: zhengcs
 * @Desc: 构建模式
 * @Date: 2018/12/17 14:39
 * @Modified:
 **/
public class BuilderPattern {

    static class Person {
        private String hair="黑色头发";

        private String eye="黑色眼睛";

        private String skin="黄色皮肤";

        private String height="身高170";

        private String sex="男";

        private Person(){}

        private Person(Person p){

        }

        static class Builder {
            Person person ;

            public Builder(){
                person = new Person();
            }

            public Person build(){
                return person;
            }

            public Builder addHair(String hair){
                person.hair = hair;
                return this;
            }

            public Builder addEye(String eye){
                person.eye = eye;
                return this;
            }

            public Builder addSkin(String skin) {
                person.skin = skin;
                return this;
            }

            public Builder addHeight(String height) {
                person.height = height;
                return this;
            }

            public Builder addSex(String sex) {
                person.sex = sex;
                return this;
            }
        }

        public String getHair() {
            return hair;
        }


        public String getEye() {
            return eye;
        }

        public String getSkin() {
            return skin;
        }


        public String getHeight() {
            return height;
        }

        public String getSex(){
            return sex;
        }

        @Override
        public String toString(){
            return "一个"+getHair()+","+getEye()+","+getSkin()+","+getHeight()+"的"+getSex()+"人";
        }
    }

    public static void main(String[] args) {

        Person person = new Person.Builder().addHair("黄色头发").build();

        System.out.println(person.toString());
        person = new Person.Builder().addEye("蓝色眼睛").build();
        System.out.println(person.toString());

    }
}
