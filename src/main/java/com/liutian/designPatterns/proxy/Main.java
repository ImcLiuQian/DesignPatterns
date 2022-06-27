package com.liutian.designPatterns.proxy;

public class Main {
    public static void main(String[] args) {
//        PrinterProxy p = new PrinterProxy("Alice");
//        Printer p = new Printer("Alice");
        PrintProxyHomeWork p = new PrintProxyHomeWork("Alice", "com.liutian.designPatterns.proxy.Printer");
        System.out.println("现在的名字是" + p.getPrinterName() + "。");
        p.setPrinterName("Bob");
        System.out.println("现在的名字是" + p.getPrinterName() + "。");
        p.print("Hello, world.");
    }
}