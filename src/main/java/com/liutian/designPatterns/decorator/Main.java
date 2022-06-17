package com.liutian.designPatterns.decorator;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
//        Display b1 = new StringDisplay("Hello, world.");
//        Display b2 = new SideBorder(b1, '#');
//        Display b3 = new FullBorder(b2);
//        b1.show();
//        b2.show();
//        b3.show();
//        Display b4 =
//                new SideBorder(
//                        new FullBorder(
//                                new FullBorder(
//                                        new SideBorder(
//                                                new FullBorder(
//                                                        new StringDisplay("你好， 世界")
//                                                ),
//                                                '*'
//                                        )
//                                )
//                        ),
//                        '/'
//                );
//        b4.show();

        //习题测试用例，暂时先不要用中文
        MultiStringDisplay md = new MultiStringDisplay();
        md.add("Good Morning.");
        md.add("Good Afternoon.");
        md.add("Good Night, see you tomorrow.");
        md.show();

        Display d1 = new SideBorder(md, '#');
        d1.show();

        Display d2 = new FullBorder(md);
        d2.show();
    }
}
