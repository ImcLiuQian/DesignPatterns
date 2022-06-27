package com.liutian.designPatterns.memento.game;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties({"serialVersionUID", "number", "mapepr", "writer", "reader", "buf"})
public class Memento implements Serializable {
    private static final long serialVersionUID = 1L;
    private int number;
    int money;//所持金钱
    @JsonProperty("fruits")
    ArrayList<String> fruits;//所获得的水果
    public int getMoney() {
        return money;
    }
    public Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList();
    }
    void addFruit(String fruit) {
        fruits.add(fruit);
    }
    List getFruits() {
        return (List) fruits.clone();
    }

    protected int getNumber() {
        return number;
    }
    @JsonIgnore
    static ObjectMapper mapepr = new ObjectMapper();
    @JsonIgnore
    FileWriter writer;
    @JsonIgnore
    static FileReader reader;
    @JsonIgnore
    static char[] buf = new char[1024];


    public void toJsonFile(String filePath) {
        String json = null;
        try {
            json = mapepr.writeValueAsString(this);
            System.out.println(json);
            writer = new FileWriter(filePath);
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Memento createFromJsonFile(String filePath) {
        Memento memento;
        try {
            reader = new FileReader(filePath);
            reader.read(buf);
            String memJson = buf.toString();
            mapepr.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            memento = mapepr.readValue(memJson, Memento.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return memento;
    }
}
