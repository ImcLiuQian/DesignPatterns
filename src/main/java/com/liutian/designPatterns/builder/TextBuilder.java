package com.liutian.designPatterns.builder;

public class TextBuilder extends Builder{

    private StringBuffer buffer = new StringBuffer();

    @Override
    public void makeTitle(String title) {
        if (!makeTitleStatus) {
            throw new RuntimeException("please make title first");
        }
        buffer.append("================================\n");
        buffer.append("[" + title + "]\n");
        buffer.append("\n");
        makeTitleStatus = true;
    }

    @Override
    public void makeString(String str) {
        if (!makeTitleStatus) {
            throw new RuntimeException("please make title first");
        }
        buffer.append('#' + str);
        buffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        if (!makeTitleStatus) {
            throw new RuntimeException("please make title first");
        }
        for (int i = 0; i < items.length; i++) {
            buffer.append("    ·" + items[i] + "\n");
        }
        buffer.append("\n");
    }

    @Override
    public void close() {
        if (!makeTitleStatus) {
            throw new RuntimeException("please make title first");
        }
        buffer.append("================================\n");
    }

    public String getRes() {
        return buffer.toString();
    }
}
