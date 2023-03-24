package com.example.appenglish.models;

public class Book extends Model {

    public String title;
    public String content;

    public int level;

    @Override
    public String getTableName() {
        return "books";
    }
}
