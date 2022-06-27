package com.liutian.designPatterns.observer;

public class EqualObserver implements Observer{
    @Override
    public void update(NumberGenerator generator) {
        System.out.print("EqualObserver:");
        int number = generator.getNumber();
        for (int i = 0; i < number; i++) {
            System.out.print("=");
        }
        System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
