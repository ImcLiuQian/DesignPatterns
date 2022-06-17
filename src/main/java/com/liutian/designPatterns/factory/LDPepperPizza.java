package com.liutian.designPatterns.factory;

public class LDPepperPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("准备伦敦胡椒披萨");
    }
}
