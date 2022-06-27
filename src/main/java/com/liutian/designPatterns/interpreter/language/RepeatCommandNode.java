package com.liutian.designPatterns.interpreter.language;

import com.liutian.designPatterns.interpreter.treevisitior.Visitor;

// <repeat command> ::= repeat <number> <command list>
public class RepeatCommandNode extends Node {
    private int number;
    private Node commandListNode;
    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public void execute() {
        for (int i = 0; i < number; i++) {
            commandListNode.execute();
        }
    }

    @Override
    public String toString() {
        return "[repeat " + number + " " + commandListNode + "]";
    }

    public int getNumber() {
        return number;
    }

    public Node getCommandListNode() {
        return commandListNode;
    }
}
