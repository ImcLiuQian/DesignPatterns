package com.liutian.designPatterns.interpreter.treevisitior;

import com.liutian.designPatterns.interpreter.language.*;

import java.util.ArrayList;

public class ProgramVisitor extends Visitor {
    public StringBuilder javaCode = new StringBuilder();

    private int rptOccurNumber = 0;
    private StringBuilder separator = new StringBuilder();

    {
        separator.append("\t\t");
    }

    @Override
    public void visit(ProgramNode pNode) {
        javaCode.append("public class " + "TestProgram" + " {\n");
        javaCode.append("\tpublic static void main(String[] args) {\n");
        pNode.accept(this);
        javaCode.append("\t}\n");
        javaCode.append("}");
    }

    @Override
    public void visit(CommandListNode clNode) {
        ArrayList<CommandNode> list = clNode.getList();
        for (CommandNode cn : list) {
            cn.accept(this);
        }
    }

    @Override
    public void visit(CommandNode cNode) {
        Node node = cNode.getNode();
        node.accept(this);
    }

    @Override
    public void visit(RepeatCommandNode rNode) {
        int number = rNode.getNumber();
        Node cmdList = rNode.getCommandListNode();
        String indexName = "i" + rptOccurNumber++;
        javaCode.append(separator);
        javaCode.append("for (int " + indexName + " = 0; " + indexName + " < " + number + "; " + indexName + "++) {\n");
        separator.append("\t");
        cmdList.accept(this);
        //去掉后面的\t
        separator.deleteCharAt(separator.length() - 1);
        javaCode.append(separator);
        javaCode.append("}\n");
    }

    @Override
    public void visit(PrimitiveCommandNode pcNode) {
        String token = pcNode.getName();
        javaCode.append(separator + token + "();\n");
    }

    public String getJavaCode() {
        return javaCode.toString();
    }
}
