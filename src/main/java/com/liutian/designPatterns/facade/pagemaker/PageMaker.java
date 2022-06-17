package com.liutian.designPatterns.facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PageMaker {
    private PageMaker() {}
    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title(username + "欢迎来到" + username + " 的主页");
            writer.paragraph("等着你的邮件哦！");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void makeLinkPage(String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");

            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Link Page");

            Set<Object> useraddrs = mailprop.keySet();
            for (Object useraddr : useraddrs) {
                writer.mailto((String) useraddr, mailprop.getProperty((String) useraddr));
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
