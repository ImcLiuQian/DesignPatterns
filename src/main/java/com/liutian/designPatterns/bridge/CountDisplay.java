package com.liutian.designPatterns.bridge;

public class CountDisplay extends Display{
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void multiDisplay(int times) {//循环显示
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
