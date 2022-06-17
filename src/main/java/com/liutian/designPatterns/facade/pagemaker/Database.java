package com.liutian.designPatterns.facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() {}
    protected static Properties getProperties(String dbname) {
        String fileName = dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(fileName));
        } catch (IOException e) {
            System.out.println("Warning: " + fileName + " is not found");
        }
        return prop;
    }
}
