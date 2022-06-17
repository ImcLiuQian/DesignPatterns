package com.liutian.designPatterns.visitor;

/**
 * 1.实现获取文件大小
 * 2.将原来的geiSize()替换成SizeVisitor，或者调用时，打印其输出，或者放到
 */
public class SizeVisitor extends Visitor{

    @Override
    public void visit(File file) {

    }

    @Override
    public void visit(Directory directory) {

    }
}
