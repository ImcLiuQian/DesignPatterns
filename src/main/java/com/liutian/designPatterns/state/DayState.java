package com.liutian.designPatterns.state;

public class DayState implements State{
    private static DayState singleton = new DayState();
    private int hour;
    private DayState() {}
    public static State getInstance() {
        return singleton;
    }
    @Override
    public void doClock(Context context, int hour) {//设置时间
        this.hour = hour;
        if (hour < 9 || hour >= 17) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {//使用金库
        if (this.hour == 12) {
            context.callSecurityCenter("紧急情况");
        } else {
            context.recordLog("使用金库(白天)");
        }
    }

    @Override
    public void doAlarm(Context context) {//按下警铃
        if (this.hour == 12) {
            context.callSecurityCenter("紧急情况");
        } else {
            context.callSecurityCenter("按下警铃(白天)");
        }
        context.changeState(EmergencyState.getInstance());
        context.recordLog("解决问题中······");
    }

    @Override
    public void doPhone(Context context) {//显示表示类的文字
        if (this.hour == 12) {
            context.callSecurityCenter("呼叫留言电话······");
        } else {
            context.callSecurityCenter("正常通话(白天)");
        }
    }

    @Override
    public String toString() {
        return "[白天]";
    }
}
