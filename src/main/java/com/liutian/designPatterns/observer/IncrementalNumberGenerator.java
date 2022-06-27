package com.liutian.designPatterns.observer;

public class IncrementalNumberGenerator extends NumberGenerator{

    private int firstNum;
    private int lastNum;
    private int step;
    private int number;

    public IncrementalNumberGenerator(int firstNum, int lastNum, int step) {
        this.firstNum = firstNum;
        this.lastNum = lastNum;
        this.step = step;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        number = firstNum;
        while (number <= lastNum) {
            notifyObservers();
            number += step;
        }
    }
}
