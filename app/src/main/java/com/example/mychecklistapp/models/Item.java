package com.example.mychecklistapp.models;

public class Item {
    private String name;
    private String detail;
    private int path;

    public Item(String name, String detail,int path) {
        this.name = name;
        this.detail = detail;
        this.path=path;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }
    public int getPath(){ return path;}
}
