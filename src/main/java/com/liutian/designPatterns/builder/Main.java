package com.liutian.designPatterns.builder;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        if (args[0].equals("plain")) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String res = textBuilder.getRes();
            System.out.println(res);
        } else if (args[0].equals("html")) {
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String res = htmlBuilder.getRes();
            System.out.println(res);
        } else if (args[0].equals("json")) {
            JsonBuilder jsonBuilder = new JsonBuilder();
            Director director = new Director(jsonBuilder);
            director.construct();
            String res = director.getRes();
            System.out.println("res = " + res);
        } else {
            usage();
            System.exit(0);
        }
    }

    public static void usage() {
        System.out.println("Usage: java Main plain  编写纯文本文档");
        System.out.println("Usage: java Main html   编写HTML文档");
    }
}
