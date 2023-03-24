package com.example.appenglish.models;

public class Exam extends Model{

    public String question;

    @Override
    public String getTableName() {
        return "exams";
    }
}
