package com.liutian.designPatterns.visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 将带有指定后缀名的文件汇集起来
 */
public class FileFindVisitor extends Visitor{
    private ArrayList<File> foundFiles = new ArrayList<>();
    public String suffix;

    public FileFindVisitor(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public void visit(File file) {
        String fileName = file.getName();
        int i = fileName.indexOf(suffix);
        if (i == -1) {//如果没有这样的字符
            return;
        }
        foundFiles.add(file);
    }

    @Override
    public void visit(Directory directory) {
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (com.liutian.designPatterns.visitor.Entry) it.next();
            entry.accept(this);
        }
    }

    public Iterator<File> getFoundFiles() {
        return foundFiles.iterator();
    }

    public String getSuffix() {
        return suffix;
    }
}
