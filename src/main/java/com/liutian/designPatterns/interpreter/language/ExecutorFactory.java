package com.liutian.designPatterns.interpreter.language;

/**
 * 生成基本命令的接口(FactoryMethod模式中的Creator角色)
 */
public interface ExecutorFactory {
    Executor createExecutor(String name);
}
