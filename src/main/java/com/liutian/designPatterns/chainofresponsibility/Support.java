package com.liutian.designPatterns.chainofresponsibility;

import java.util.ArrayList;

public abstract class Support {
    private static ArrayList<Support> supports = new ArrayList<>();

    public static void add(Support support) {
        supports.add(support);
    }

    public static void supportListResolve(Trouble trouble) {
        for (Support support : supports) {
            if (support.resolve(trouble)) {
                support.done(trouble);
                return;
            }
        }
        fail(trouble);
    }

    private String name;//解决问题的实例的名字
    public Support next;//要推卸给的对象

    public Support(String name) {//生成解决问题的实例
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble) {//解决问题的步骤
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {//如果为空，说明所有责任链都走完了，还没有解决问题，那么直接fail
            fail(trouble);
        }
    }

    protected abstract boolean resolve(Trouble trouble);
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resplved by [" + this.name + "].");
    }
    protected static void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
