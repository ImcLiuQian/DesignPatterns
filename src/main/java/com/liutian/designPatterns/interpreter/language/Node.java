package com.liutian.designPatterns.interpreter.language;

import com.liutian.designPatterns.interpreter.treevisitior.Visitor;

public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
    public abstract void accept(Visitor v);
    public abstract void execute();
}