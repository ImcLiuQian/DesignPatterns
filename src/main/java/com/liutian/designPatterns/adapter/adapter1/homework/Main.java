package com.liutian.designPatterns.adapter.adapter1.homework;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\29255\\Desktop\\test.txt";
        FileIO fileIO = new FileProperties();

        fileIO.readFromFile(fileName);
        fileIO.setValue("year", "2004");
        fileIO.setValue("month", "4");
        fileIO.setValue("day", "21");
        fileIO.writeToFile("C:\\Users\\29255\\Desktop\\test1.txt");
    }
}
