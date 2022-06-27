package com.liutian.designPatterns.interpreter.language;

import com.liutian.designPatterns.interpreter.treevisitior.Visitor;

public class CommandNode extends Node {
    private Node node;
    @Override
    public void parse(Context context) throws ParseException {
        if (context.currentToken().equals("repeat")) {
            node = new RepeatCommandNode();
            node.parse(context);
        } else {
            node = new PrimitiveCommandNode();
            node.parse(context);
        }
    }

    @Override
    public void execute() {
        node.execute();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return node.toString();
    }

    public Node getNode() {
        return node;
    }
}
