package com.liutian.designPatterns.proxy;

public class PrinterProxy implements Printable{
    private String name;
    private Printer real;
    public PrinterProxy() {}
    public PrinterProxy(String name) {
        this.name = name;
    }

    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized void realize() {//生成"本人"
        if (real == null) {
            real = new Printer(name);
        }
    }
}
