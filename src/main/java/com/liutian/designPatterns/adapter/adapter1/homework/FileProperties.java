package com.liutian.designPatterns.adapter.adapter1.homework;

import java.io.*;
import java.util.Properties;

/**
 * Adapter
 */
public class FileProperties extends Properties implements FileIO {

    @Override
    public void readFromFile(String filename) throws IOException {
        File file = new File(filename);
        FileInputStream inputStream = new FileInputStream(file);
        super.load(inputStream);
        super.list(System.out);
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        File file = new File(filename);
        String storeHeader = "written by FileProperties";
        FileOutputStream outputStream = new FileOutputStream(file);
        super.store(outputStream, storeHeader);
    }

    @Override
    public void setValue(String key, String value) {
        super.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        String property = super.getProperty(key);
        return property;
    }
}
