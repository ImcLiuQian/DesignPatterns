package com.liutian.designPatterns.command.drawer;

import java.awt.*;

public interface Drawable {
    void init();
    void draw(int x, int y);
    void setColor(Color color);
}

