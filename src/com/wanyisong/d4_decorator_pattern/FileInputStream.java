package com.wanyisong.d4_decorator_pattern;

import java.util.Arrays;

/**
 * 原生类
 */
public class FileInputStream extends InputStream{
    @Override
    public int read() {
        System.out.println("低性能的读取了一个字节a");
        return 97;
    }

    @Override
    public int read(byte[] buffer) {
        buffer[0]=97;
        buffer[1]=98;
        buffer[2]=99;
        System.out.println("高性能读取了字节"+ Arrays.toString(buffer));
        return 3;
    }
}
