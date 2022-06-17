package com.liutian.designPatterns.AbstractFactory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Page {
    protected String title;
    protected String author;
    protected ArrayList content = new ArrayList<>();
    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public void add(Item item) {
        content.add(item);
    }
    public void output() {
        try {
            String fileName = title + ".html";
            FileWriter writer = new FileWriter(fileName);
            writer.write(this.makeHTML());
            writer.close();
            System.out.println(fileName + " 编写完成。");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public abstract String makeHTML();
}
