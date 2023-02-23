package com.wanyisong.d4_decorator_pattern;

/**
 * 装饰模式
 * 定义一个父类  InputStream
 * 定义实现类    FileInputStream 继承父类 定义功能 包装原始类 增强功能
 *
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        InputStream is=new BufferInputStream(new FileInputStream());
        System.out.println(is.read());
        System.out.println(is.read(new byte[3]));
    }
}
