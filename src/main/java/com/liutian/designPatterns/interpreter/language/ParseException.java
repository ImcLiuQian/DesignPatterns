package com.liutian.designPatterns.interpreter.language;

public class ParseException extends RuntimeException{
    public ParseException(String message) {
        super(message);
    }
}
