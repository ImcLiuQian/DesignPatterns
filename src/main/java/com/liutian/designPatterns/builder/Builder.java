package com.liutian.designPatterns.builder;

public abstract class Builder {
    Boolean makeTitleStatus = false;
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();
    public abstract String getRes();
}
