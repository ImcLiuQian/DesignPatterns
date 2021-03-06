package com.liutian.designPatterns.visitor.eleArrayList;

import com.liutian.designPatterns.visitor.Directory;
import com.liutian.designPatterns.visitor.File;
import com.liutian.designPatterns.visitor.ListVisitor;

public class Main {
    public static void main(String[] args) {
        Directory root1 = new Directory("root1");
        root1.add(new File("diary.html", 10));
        root1.add(new File("index.html", 20));

        Directory root2 = new Directory("root1");
        root2.add(new File("diary.html", 1000));
        root2.add(new File("index.html", 2000));

        ElementArrayList list = new ElementArrayList();
        list.add(root1);
        list.add(root2);
        list.add(new File("etc.html", 1234));

        list.accept(new ListVisitor());
    }
}
