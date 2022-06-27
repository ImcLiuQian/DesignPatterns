package com.liutian.designPatterns.FlyWeight;

/**
 * @author 29255
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 123-123-123");
            System.exit(0);
        }

        BigString bs = new BigString(args[0], true);
        bs.print();

        Runtime.getRuntime().gc();
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("used1 = " + used);

        BigString bs2 = new BigString(args[0], false);
        bs2.print();

        Runtime.getRuntime().gc();
        long used2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("used2 = " + used2);
    }
}
