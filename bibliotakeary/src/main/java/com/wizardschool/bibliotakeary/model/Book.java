package com.wizardschool.bibliotakeary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String title;
    private String content;

    public Book() {  }

    public Book(int id, String title, String content) {
        this.setId(id);
        this.setTitle(title);
        this.setContent(content);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}