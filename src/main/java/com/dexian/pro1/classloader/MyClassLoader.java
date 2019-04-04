package com.dexian.pro1.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义java类加载器，实现java类的热加载
 *
 * @author Brook_min
 * @date 2019/4/4 0004 - 10:45
 */
public class MyClassLoader extends ClassLoader {

    //要加载的Java类classpath路径
    private String classpath;

    public MyClassLoader(String classpath) {
        super(ClassLoader.getSystemClassLoader());
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    /**
     * 加载class文件中的内容
     *
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {

        try {
            name = name.replace(".", "//");
            FileInputStream inputStream = new FileInputStream(new File(classpath + name + ".class"));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int b=0;
            while ((b=inputStream.read())!=-1){
                outputStream.write(b);
            }
            inputStream.close();
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
