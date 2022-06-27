package com.liutian.designPatterns.state;

public class EmergencyState implements State{
    private static EmergencyState singleton = new EmergencyState();
    private EmergencyState() {}
    public static EmergencyState getInstance() {
        return singleton;
    }
    @Override
    public void doClock(Context context, int hour) {
        context.callSecurityCenter("按下警铃(紧急情况)");
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("按下警铃(紧急情况)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃(紧急情况)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("按下警铃(紧急情况)");
    }
}
