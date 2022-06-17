package com.liutian.designPatterns.decorator;

public class UpDownBorder extends Border{
    protected UpDownBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        return display.getColumns();
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        return null;
    }
}
