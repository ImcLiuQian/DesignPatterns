package com.liutian.designPatterns.observer;

public class Main {
    public static void main(String[] args) {
        IncrementalNumberGenerator generator = new IncrementalNumberGenerator(10, 50, 5);
//        RandomNumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        Observer observer3 = new EqualObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.addObserver(observer3);
        generator.execute();
    }
}
