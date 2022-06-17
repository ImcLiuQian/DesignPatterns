package com.liutian.designPatterns.factory;

public abstract class Pizza {
    protected String name;//名字

    //准备原材料，不通披萨不一样，因此，这里做成抽象方法
    public abstract void prepare();

    public void bake() {}
    public void cut() {}
    public void box() {}

    public void setName(String name) {
        this.name = name;
    }
}
