package com.liutian.designPatterns.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HTMLBuilder extends Builder{
    private String fileName;//文件名
    private PrintWriter writer;//用于编写文件的PrintWriter
    @Override
    public void makeTitle(String title) {//标题
        fileName = title + ".html";
        try {
            writer = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writer.println("<html><head><title>" + title + "</title></head><body>");
        //输出标题
        writer.println("<h1>" + title + "</h1>");
        makeTitleStatus = true;
    }

    @Override
    public void makeString(String str) {
        if (!makeTitleStatus) {
            throw new RuntimeException("please make title first");
        }
        writer.println("<p>" + str + "</p>");
    }

    @Override
    public void makeItems(String[] items) {
        if (!makeTitleStatus) {
            throw new RuntimeException("please make title first");
        }
        writer.println("<ul>");
        for (int i = 0; i < items.length; i++) {
            writer.println("<li>" + items[i] + "</li>");
        }
        writer.println("</ul>");
    }

    @Override
    public void close() {//完成文档
        if (!makeTitleStatus) {
            throw new RuntimeException("please make title first");
        }
        writer.println("</body></html>");
        writer.close();
    }

    public String getRes() {
        return fileName;
    }
}
