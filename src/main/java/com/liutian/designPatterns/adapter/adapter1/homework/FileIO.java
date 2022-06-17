package com.liutian.designPatterns.adapter.adapter1.homework;

import java.io.IOException;

/**
 * Target
 */
public interface FileIO {
    void readFromFile(String filename) throws IOException;
    void writeToFile(String filename) throws IOException;
    void setValue(String key, String value);
    String getValue(String key);
}
