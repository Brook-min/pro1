package com.dexian.pro1.classloader;

/**
 * 测试java类的热加载
 * @author Brook_min
 * @date 2019/4/4 0004 - 12:16
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        new Thread(new MsgHandler()).start();
    }
}
