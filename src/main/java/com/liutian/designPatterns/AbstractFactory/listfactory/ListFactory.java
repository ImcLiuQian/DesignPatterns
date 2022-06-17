package com.liutian.designPatterns.AbstractFactory.listfactory;

import com.liutian.designPatterns.AbstractFactory.factory.Factory;
import com.liutian.designPatterns.AbstractFactory.factory.Link;
import com.liutian.designPatterns.AbstractFactory.factory.Page;
import com.liutian.designPatterns.AbstractFactory.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
