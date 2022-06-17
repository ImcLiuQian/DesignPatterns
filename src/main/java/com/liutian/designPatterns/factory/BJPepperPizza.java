package com.liutian.designPatterns.factory;

public class BJPepperPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("准备北京胡椒披萨");
    }
}
