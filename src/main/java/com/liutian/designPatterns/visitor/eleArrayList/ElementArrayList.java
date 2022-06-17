package com.liutian.designPatterns.visitor.eleArrayList;

import com.liutian.designPatterns.visitor.Element;
import com.liutian.designPatterns.visitor.Entry;
import com.liutian.designPatterns.visitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 基于ArrayList编写一个具有Element接口的类，使得
 */
public class ElementArrayList extends ArrayList<Entry> implements Element {
    @Override
    public void accept(Visitor v) {
        Iterator<Entry> it = this.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            entry.accept(v);
        }
    }
}
