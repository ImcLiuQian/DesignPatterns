package com.liutian.designPatterns.state;

public interface Context {
    void setClock(int hour);
    void changeState(State instance);
    void recordLog(String msg);
    void callSecurityCenter(String msg);
}
