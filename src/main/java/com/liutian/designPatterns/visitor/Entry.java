package com.liutian.designPatterns.visitor;

import com.liutian.designPatterns.composite.FileTreatMentException;

public abstract class Entry implements Element{
    public abstract String getName();//获取名字

    public abstract int getSize();

    protected String fullPath = "";

    public Entry add(Entry entry) {//如果子类不实现add方法，而是直接用父类的，那么直接抛出异常
        throw new FileTreatMentException();
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);//为一览加上前缀并显示目录条目一览

    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

    public abstract String getFullPath();
}
