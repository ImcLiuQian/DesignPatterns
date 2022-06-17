package com.liutian.designPatterns.factory;

public class BJCheesePizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("准备北京奶酪披萨");
    }
}
