package com.liutian.designPatterns.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PrintProxyHomeWork implements Printable{
    private String name;
    private String realClassName;
    private Printable real;
    public PrintProxyHomeWork() {}
    public PrintProxyHomeWork(String name, String realClassName) {
        this.name = name;
        this.realClassName = realClassName;
    }

    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized void realize() {//生成"本人"
        if (real == null) {
            try {
                //利用反射创建实例
                //根据类名获取Class对象
                Class<?> clazz = Class.forName(realClassName);
                //参数类型
                Class paraClass = String.class;
                //根据参数类型获取对应的构造函数
                Constructor<?> constructor = clazz.getConstructor(paraClass);
                //参数值
                real = (Printable) constructor.newInstance(name);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
