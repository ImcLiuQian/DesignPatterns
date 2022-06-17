package com.liutian.designPatterns.visitor;

public interface Element {
    void accept(Visitor v);
}
