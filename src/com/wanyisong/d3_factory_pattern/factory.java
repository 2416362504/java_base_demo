package com.wanyisong.d3_factory_pattern;

/**
 * 工厂模式
 */
public class factory {
    public static void main(String[] args) {
//        Computer c=new Mac();
//        c.setPrice(99999);
//        c.setName("苹果");
//        c.start();
        Computer c1=FactoryPattern.createComputer("huawei");
        c1.start();

        Computer c2=FactoryPattern.createComputer("mac");
        c2.start();
    }
}
