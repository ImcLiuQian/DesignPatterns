package com.liutian.designPatterns.bridge;

public class RandomDisplay extends Display {
    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int times) {
        int randomNumber = (int) Math.round(Math.random() * (times - 1) + 1);
        open();
        for (int i = 0; i < randomNumber; i++) {
            print();
        }
        close();
    }
}
