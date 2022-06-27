package com.liutian.designPatterns.interpreter.language;

import com.liutian.designPatterns.interpreter.treevisitior.Visitor;

// <primitive command> := go | right | left
public class PrimitiveCommandNode extends Node {
    private String name;
    private Executor executor;
    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
//        if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
//            throw new ParseException(name + " is undefined");
//        }
        executor = context.createExecutor(name);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public void execute() {
        if (executor == null) {
            throw new ExecuteException(name + ": is not defined");
        } else {
            executor.execute();
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
