package com.liutian.designPatterns.factory;

/**
 * 简单工厂类
 * 根据不同的type创建出不通的pizza对象
 */
public class SimpleFactory {
    public static Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new BJPepperPizza();
            pizza.setName("greek");
        } else if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
            pizza.setName("cheese");
        }
        return pizza;
    }
}
