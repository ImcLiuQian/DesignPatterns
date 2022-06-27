package com.liutian.designPatterns.memento;

import com.liutian.designPatterns.memento.game.Gamer;
import com.liutian.designPatterns.memento.game.Memento;

import java.io.File;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Gamer gamer = null;
        Memento memento;
        //读取存档
        String memFilePath = "game.json";
        File memFile = new File(memFilePath);
        if (!memFile.exists()) {
            gamer = new Gamer(100);//最初所持金钱数为100
            memento = gamer.createMemento();
            memento.toJsonFile(memFilePath);
        } else {
            memento = Memento.createFromJsonFile(memFilePath);
            gamer = new Gamer();
            gamer.restoreMemento(memento);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);//显示掷骰子的次数
            System.out.println("当前状态：" + gamer);//显示主人公现在的状态
            gamer.bet();
            System.out.println("所持金钱为" + gamer.getMoney() + "元。");
            //决定如何处理Memento
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("    (所持金钱增加了许多，因此保存游戏当前的状态) ");
                memento = gamer.createMemento();
                memento.toJsonFile(memFilePath);
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("    (所持金钱减少了许多，因此将游戏恢复至以前的状态) ");
                gamer.restoreMemento(memento);
            }
            //等待一段时间
            Thread.sleep(100);
            System.out.println();
        }
    }
}

