package com.liutian.designPatterns.interpreter.treevisitior;

import com.liutian.designPatterns.interpreter.language.*;

public abstract class Visitor {
    public abstract void visit(ProgramNode pNode);
    public abstract void visit(CommandListNode clNode);
    public abstract void visit(CommandNode cNode);
    public abstract void visit(RepeatCommandNode rNode);
    public abstract void visit(PrimitiveCommandNode pcNode);
}
