package com.liutian.designPatterns.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class OrderPizza {

    Pizza pizza;
    //定义一个抽象方法，让各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);

    //构造器
    public OrderPizza(SimpleFactory simpleFactory) throws IOException {
        simpleFactoryStart();
    }

    public void simpleFactoryStart() throws IOException {
        String oredrType = "";
        do {
            oredrType = getType();
            pizza = SimpleFactory.createPizza(oredrType);
            //输出pizza
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }
        } while (true);
    }

    //从控制台读取订购披萨的种类
    private String getType() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input pizza type: ");
        String str = reader.readLine();
        return str;
    }
}
