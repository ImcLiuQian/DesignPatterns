package com.liutian.designPatterns.command.command;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommand implements Command{
    //命令集合
    private Stack commands = new Stack();

    @Override
    public void excute() {
        Iterator it = commands.iterator();
        while (it.hasNext()) {
            Command command = (Command) it.next();
            command.excute();
        }
    }
    //添加命令
    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }
    //删除最后一条命令
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }
    //删除所有命令
    public void clear() {
        commands.clear();
    }
}
