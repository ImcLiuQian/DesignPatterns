package com.liutian.designPatterns.facade;

import com.liutian.designPatterns.facade.pagemaker.PageMaker;

public class Main {
    public static void main(String[] args) {
//        PageMaker.makeWelcomePage("hyuki@hyuki.com", "welcome.html");
        PageMaker.makeLinkPage("linkPage.html");
    }
}
