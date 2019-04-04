package com.dexian.pro1.classloader;

/**
 * //后台启动一条线程不断刷新重新加载实现了热加载的类
 * @author Brook_min
 * @date 2019/4/4 0004 - 12:13
 */
public class MsgHandler implements Runnable {
    @Override
    public void run() {
        while(true) {
            BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            manager.logic();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
