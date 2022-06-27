package com.liutian.designPatterns.interpreter.language;

import com.liutian.designPatterns.interpreter.treevisitior.Visitor;

// <program> ::= program <command>
public class ProgramNode extends Node{
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public void accept(Visitor v) {
        v.visit((CommandListNode) commandListNode);
    }

    @Override
    public void execute() {
        commandListNode.execute();
    }

    @Override
    public String toString() {
        return "[program " + commandListNode + "]";
    }
}
