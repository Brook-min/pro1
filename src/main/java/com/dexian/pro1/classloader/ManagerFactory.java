package com.dexian.pro1.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载manager的工厂
 * @author Brook_min
 * @date 2019/4/4 0004 - 11:12
 */
public class ManagerFactory {
    //记录热加载类的加载信息
    private static  final Map<String ,LoadInfo> LOAD_INFO_MAP=new HashMap<String ,LoadInfo>();

    //要加载的类的classpath
    public static  final String CLASS_PATH="E:/IDEA-Project/pro1/target/classes/";

    //实现热加载的类全名称（包名+类名）
    public static final  String MY_MANAGER="com.dexian.pro1.classloader.MyManager";

    public static BaseManager getManager(String className){
        File loadFile=new File(CLASS_PATH+className.replace("\\.","/")+".class");
        long lastModified=loadFile.lastModified();
        //loadTimeMap不包含className为key的loadInfo信息，证明这个类没有被加载，那么需要加载这个类到jvm
        if (LOAD_INFO_MAP.get(className)==null){
            load(className,lastModified);
        }//加载类的时间戳变化了，我们同样要重新加载这个类到jvm
        else if (LOAD_INFO_MAP.get(className).getLoadTime()!=lastModified){
            load(className,lastModified);
        }
        return LOAD_INFO_MAP.get(className).getBaseManager();
    }

    private static void load(String className, long lastModified) {
        MyClassLoader myClassLoader=new MyClassLoader(CLASS_PATH);
        Class<?> loadClass=null;
        try {
            loadClass=myClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BaseManager manager= newInstance(loadClass);
        LoadInfo loadInfo=new LoadInfo(myClassLoader,lastModified);
        loadInfo.setBaseManager(manager);
        LOAD_INFO_MAP.put(className,loadInfo);
    }

    //以反射的方式创建basemanager子类对象
    private static BaseManager newInstance(Class<?> loadClass) {
        try {
            return (BaseManager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
