package com.liutian.designPatterns.factory;

public class LDCheesePizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("准备伦敦奶酪披萨");
    }
}
