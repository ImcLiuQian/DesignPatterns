package com.liutian.designPatterns.state;

/**
 * @author 29255
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SafeFrame frame = new SafeFrame("State Sample");
        while (true) {
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);
                //设置时间
                Thread.sleep(1000);
            }
        }
    }
}
