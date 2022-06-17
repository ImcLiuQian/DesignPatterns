package com.liutian.designPatterns.composite;

public class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries");
        Directory rootdir = new Directory("root");
        Directory bindir = new Directory("bin");
        Directory tmpdir = new Directory("tmp");
        Directory usrdir = new Directory("usr");
        rootdir.add(bindir);
        rootdir.add(tmpdir);
        rootdir.add(usrdir);
        Directory vidir = new Directory("vidir");
        String viFullPath1 = vidir.getFullPath();
        System.out.println("viFullPath1 = " + viFullPath1);
        bindir.add(vidir);
        String viFullPath2 = vidir.getFullPath();
        System.out.println("viFullPath2 = " + viFullPath2);
        bindir.add(new File("vi", 10000));
        bindir.add(new File("latex", 20000));
        rootdir.printList();

        System.out.println();
        System.out.println("Making user entries");
        Directory yuki = new Directory("yuki");
        Directory hanako = new Directory("hanako");
        Directory tomura = new Directory("tomura");
        usrdir.add(yuki);
        usrdir.add(hanako);
        usrdir.add(tomura);
        yuki.add(new File("diary.html", 100));
        yuki.add(new File("Composite.java", 200));
        hanako.add(new File("memo.tex", 300));
        tomura.add(new File("game.doc", 400));

        File fileTest = new File("junk.mail", 500);

//        tomura.add(new File("junk.mail", 500));
        tomura.add(fileTest);
        rootdir.printList();

        String fullPath = fileTest.getFullPath();
        System.out.println("fullPath = " + fullPath);
        System.out.println();
        String tomuraFullPath = tomura.getFullPath();
        System.out.println("tomuraFullPath = " + tomuraFullPath);
        tomura.printList();
    }
}
