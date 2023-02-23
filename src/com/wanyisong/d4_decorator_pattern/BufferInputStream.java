package com.wanyisong.d4_decorator_pattern;

/**
 * 装饰类：继承InputStream 拓展原始类的功能
 */
public class BufferInputStream extends InputStream{
    private InputStream is;
    public BufferInputStream(InputStream is){
        this.is=is;
    }
    @Override
    public int read() {
        System.out.println("提供8KB的缓冲区 提高读数据的性能");
        return is.read();
    }

    @Override
    public int read(byte[] buffer) {
        System.out.println("提供8KB的缓冲区 提高读数据的性能");
        return is.read(buffer);
    }
}
