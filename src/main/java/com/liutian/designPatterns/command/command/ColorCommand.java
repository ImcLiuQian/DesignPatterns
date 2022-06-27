package com.liutian.designPatterns.command.command;

import com.liutian.designPatterns.command.drawer.Drawable;

import java.awt.*;

public class ColorCommand implements Command{
    //绘制对象
    protected Drawable drawable;
    //颜色
    private Color color;
    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }
    //执行
    @Override
    public void excute() {
        drawable.setColor(this.color);
    }
}
