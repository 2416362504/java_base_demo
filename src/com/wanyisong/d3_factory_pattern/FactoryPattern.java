package com.wanyisong.d3_factory_pattern;

public class FactoryPattern {
    /**
     * 定义一个方法 创建对象返回
     */
    public static Computer createComputer(String info){
        switch (info){
            case "huawei":
                Computer c=new HuaWei();
                c.setName("huawei12");
                c.setPrice(7999);
                return c;
            case "mac":
                Computer c2=new Mac();
                c2.setName("macBook pro");
                c2.setPrice(19999);
                return c2;
            default:
                return null;
        }
    }
}
