package com.wanyisong.d3_factory_pattern;

public class Mac extends Computer{
    @Override
    public void start() {
        System.out.println(getName()+"苹果电脑启动了");
    }
}
