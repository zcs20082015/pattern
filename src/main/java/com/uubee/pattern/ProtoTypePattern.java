package com.uubee.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhengcs
 * @Desc: 原型模式
 * @Date: 2018/12/17 14:05
 * @Modified:
 **/
public class ProtoTypePattern {

    class ProtoType implements Cloneable{
        private ArrayList list = new ArrayList();

        @Override
        public ProtoType clone(){
            ProtoType protoType = null;
            try {
                protoType = (ProtoType) super.clone();
                protoType.list = (ArrayList)this.list.clone();
            } catch (Exception e) {
            	// TODO: handle exception
                e.printStackTrace();
            }

            return protoType;
        }
    }

    class ProtoTypeImpl extends ProtoType{

        public void show(){
            System.out.println("原型模式实现类");
        }
    }
}
