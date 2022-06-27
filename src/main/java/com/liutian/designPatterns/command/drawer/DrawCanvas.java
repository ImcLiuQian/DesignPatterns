package com.liutian.designPatterns.command.drawer;

import com.liutian.designPatterns.command.command.ColorCommand;
import com.liutian.designPatterns.command.command.MacroCommand;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {
    //颜色
    private Color color;
    //要绘制的圆点的半径
    private int radius;
    //命令的历史记录
    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.WHITE);
        this.history = history;
        init();
    }

    //重新全部绘制
    public void paint(Graphics g) {
        history.excute();
    }

    @Override
    public void init() {//设置默认红色，每个点的半径是6
        color = Color.red;
        radius = 6;
        history.append(new ColorCommand(this, color));
    }

    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
