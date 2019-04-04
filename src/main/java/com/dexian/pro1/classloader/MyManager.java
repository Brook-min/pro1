package com.dexian.pro1.classloader;

/**
 * BaseManager的子类，此类需要实现Java类的热加载功能
 * @author Brook_min
 * @date 2019/4/4 0004 - 11:01
 */
public class MyManager implements BaseManager {
    @Override
    public void logic() {
        System.out.println("我在慕课网学习呢，今天我学习了如何实现一个Java类的热加载案例");
        System.out.println("慕课网学习资源很丰富，师资强大,学习的人很多");
    }
}
