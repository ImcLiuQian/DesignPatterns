package com.liutian.designPatterns.PrototypePatterns.framework;

public interface Product extends Cloneable{
    void use(String s);
    Product createClone();
}
