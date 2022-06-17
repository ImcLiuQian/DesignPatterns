package com.liutian.designPatterns.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonBuilder extends Builder{
    private String fileName;//文件名
    private PrintWriter writer;//用于编写文件的PrintWriter
    @Override
    public void makeTitle(String title) {
        fileName = title + ".json";
        try {
            writer = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writer.println("{\n\t\"title\": " + title + ",\n");
        //输出标题
        makeTitleStatus = true;
    }

    @Override
    public void makeString(String str) {
        if (!makeTitleStatus) {
            throw new RuntimeException("please make title first");
        }
        writer.println("\t\"str\": " + str + ",\n");
    }

    @Override
    public void makeItems(String[] items) {
        if (!makeTitleStatus) {
            throw new RuntimeException("please make title first");
        }
        for (int i = 0; i < items.length; i++) {
            writer.println("\t\"item" + i + "\": " + items[i] + ",\n");
        }
    }

    @Override
    public void close() {
        if (!makeTitleStatus) {
            throw new RuntimeException("please make title first");
        }
        writer.println("}");
        writer.close();
    }

    @Override
    public String getRes() {
        return fileName;
    }
}
