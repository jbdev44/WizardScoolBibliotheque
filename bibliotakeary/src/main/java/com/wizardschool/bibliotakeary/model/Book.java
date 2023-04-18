package com.wizardschool.bibliotakeary.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String title;
    private String author;
    private String description;

    public Book() {  }

    public Book(int id, String title, String author, String description) {
        this.setId(id);
        this.setTitle(title);
        this.setAuthor(author);
        this.setDescription(description);
    }

    private void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + description + '\'' +
                '}';
    }
}