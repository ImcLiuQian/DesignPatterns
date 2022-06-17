package com.liutian.designPatterns.composite;

public abstract class Entry {
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

    public String getFullPath() {
        if (this instanceof Directory)
            return fullPath + "/";
        else if (this instanceof File)
            return fullPath;
        else throw new RuntimeException("Entry format error");
    }
}
