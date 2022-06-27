package com.liutian.designPatterns.interpreter.language;

/**
 * 运行时的异常类
 */
public class ExecuteException extends RuntimeException{
    public ExecuteException(String msg) {
        super(msg);
    }
}
