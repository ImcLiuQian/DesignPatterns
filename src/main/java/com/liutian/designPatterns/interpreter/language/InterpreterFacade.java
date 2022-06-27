package com.liutian.designPatterns.interpreter.language;

/**
 * 使解释器更好用的类(Facade模式中的Facade角色)
 */
public class InterpreterFacade implements Executor{
    private ExecutorFactory factory;
    private Context context;
    private Node programNode;

    public InterpreterFacade(ExecutorFactory factory) {
        this.factory = factory;
    }

    public boolean parse(String text) {
        boolean ok = true;
        this.context = new Context(text);
        this.context.setExecutorFactory(factory);
        this.programNode = new ProgramNode();
        try {
            programNode.parse(context);
            System.out.println(programNode);
        } catch (ParseException e) {
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }

    public void execute() {
        try {
            programNode.execute();
        } catch (ExecuteException e) {
            e.printStackTrace();
        }
    }
}
