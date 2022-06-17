package com.liutian.designPatterns.bridge;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TxtDisplayImpl extends DisplayImpl{
    private String title;
    private String author;
    private String content;

    private FileWriter writer;

    public TxtDisplayImpl(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    @Override
    public void rawOpen() {
        String fileName = title + ".txt";
        try {
            this.writer = new FileWriter(fileName);
            writer.write("/**\n * title " + title + "\n * author " + author + "\n" + " * date " + new Date() + "\n */\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void rawPrint() {
        try {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void rawClose() {
        try {
            writer.close();
            System.out.println(title + ".txt writing down");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
