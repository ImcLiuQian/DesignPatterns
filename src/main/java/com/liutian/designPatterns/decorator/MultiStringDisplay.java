package com.liutian.designPatterns.decorator;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * 习题
 */
public class MultiStringDisplay extends Display{
    protected int colLength;
    protected int rowLength;
    private ArrayList<String> content = new ArrayList<>();

    public MultiStringDisplay() {}

    public void add(String str) {
        content.add(str);
        rowLength++;
        colLength = colLength > str.getBytes(StandardCharsets.UTF_8).length ? colLength : str.getBytes(StandardCharsets.UTF_8).length;
    }

    @Override
    public int getColumns() {
        return colLength;
    }

    @Override
    public int getRows() {
        return rowLength;
    }

    @Override
    public String getRowText(int row) {
        StringBuilder builder = new StringBuilder(content.get(row));
        while (builder.length() < colLength) {//填充空格' '
            builder.append(' ');
        }
        return builder.toString();
    }
}
