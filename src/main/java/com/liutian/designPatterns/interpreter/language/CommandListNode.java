package com.liutian.designPatterns.interpreter.language;

import com.liutian.designPatterns.interpreter.treevisitior.Visitor;

import java.util.ArrayList;
import java.util.Iterator;

// <command list> ::= <command>* end
public class CommandListNode extends Node {
    private ArrayList<CommandNode> list = new ArrayList();

    @Override
    public void parse(Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing 'end'");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                CommandNode commendNode = new CommandNode();
                commendNode.parse(context);
                list.add(commendNode);
            }
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public void execute() {
        Iterator<CommandNode> it = list.iterator();
        while (it.hasNext()) {
            ((CommandNode) it.next()).execute();
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public ArrayList<CommandNode> getList() {
        return list;
    }
}
