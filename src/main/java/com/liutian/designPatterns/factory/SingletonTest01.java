package com.liutian.designPatterns.factory;

public class SingletonTest01 {
    public static void main(String[] args) {

    }
}


class Singleton {
    private Singleton() {}

    //写一个静态内部类，该类中有一个静态属性Singleton
    private static class SingletonInstance {
        private static final Singleton instance = new Singleton();
    }

    //提供静态公有方法，返回SingletonInstance.instance;
    public static Singleton getInstance() {
        return SingletonInstance.instance;
    }
}
