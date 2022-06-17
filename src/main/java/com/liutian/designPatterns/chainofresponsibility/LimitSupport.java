package com.liutian.designPatterns.chainofresponsibility;

/**
 * 解决编号小于limit值的问题
 */
public class LimitSupport extends Support {
    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit) {
            return true;
        } else
            return false;
    }
}
