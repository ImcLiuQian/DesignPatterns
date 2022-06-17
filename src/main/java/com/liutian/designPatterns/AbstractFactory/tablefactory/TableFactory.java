package com.liutian.designPatterns.AbstractFactory.tablefactory;

import com.liutian.designPatterns.AbstractFactory.factory.Factory;
import com.liutian.designPatterns.AbstractFactory.factory.Link;
import com.liutian.designPatterns.AbstractFactory.factory.Page;
import com.liutian.designPatterns.AbstractFactory.factory.Tray;

public class TableFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
