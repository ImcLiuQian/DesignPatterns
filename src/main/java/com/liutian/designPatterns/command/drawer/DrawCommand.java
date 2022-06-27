package com.liutian.designPatterns.command.drawer;

import com.liutian.designPatterns.command.command.Command;

import java.awt.*;

public class DrawCommand implements Command {

    //绘制对象
    protected Drawable drawable;
    //绘制位置
    private Point position;

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void excute() {
        drawable.draw(position.x, position.y);
    }
}
