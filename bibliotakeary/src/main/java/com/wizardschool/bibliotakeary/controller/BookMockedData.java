package com.wizardschool.bibliotakeary.controller;

import com.wizardschool.bibliotakeary.model.Book;

import java.util.List;
import java.util.ArrayList;

public class BookMockedData {
    //list of Book posts
    private List<Book> books;

    private static BookMockedData instance = null;
    public static BookMockedData getInstance(){
        if(instance == null){
            instance = new BookMockedData();
        }
        return instance;
    }


    public BookMockedData(){
        books = new ArrayList<Book>();
        books.add(new Book(1, "Go up, up and away with your Google Assistant",
                "With holiday travel coming up, and 2018 just around the corner, " +
                        "you may be already thinking about getaways for next year. Consider " +
                        "the Google Assistant your new travel buddy, ready at the drop of a hat—or a passport"));
        books.add(new Book(2, "Get local help with your Google Assistant",
                "No matter what questions you’re asking—whether about local traffic or " +
                        "a local business—your Google Assistant should be able to help. And starting " +
                        "today, it’s getting better at helping you, if you’re looking for nearby services " +
                        "like an electrician, plumber, house cleaner and more"));
        books.add(new Book(3, "The new maker toolkit: IoT, AI and Google Cloud Platform",
                "Voice interaction is everywhere these days—via phones, TVs, laptops and smart home devices " +
                        "that use technology like the Google Assistant. And with the availability of maker-friendly " +
                        "offerings like Google AIY’s Voice Kit, the maker community has been getting in on the action " +
                        "and adding voice to their Internet of Things (IoT) projects."));
        books.add(new Book(4, "Learn more about the world around you with Google Lens and the Assistant",
                "Looking at a landmark and not sure what it is? Interested in learning more about a movie as " +
                        "you stroll by the poster? With Google Lens and your Google Assistant, you now have a helpful " +
                        "sidekick to tell you more about what’s around you, right on your Pixel."));
        books.add(new Book(5, "7 ways the Assistant can help you get ready for Turkey Day",
                "Thanksgiving is just a few days away and, as always, your Google Assistant is ready to help. " +
                        "So while the turkey cooks and the family gathers, here are some questions to ask your Assistant."));
    }

    // return all books
    public List<Book> fetchBooks() {
        return books;
    }

    // return Book by id
    public Book getBookById(int id) {
        for(Book b: books) {
            if(b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    // search Book by text
    public List<Book> searchBooks(String searchTerm) {
        List<Book> searchedBooks = new ArrayList<Book>();
        for(Book b: books) {
            if(b.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    b.getContent().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchedBooks.add(b);
            }
        }

        return searchedBooks;
    }

    // create Book
    public Book createBook(int id, String title, String content) {
        Book newBook = new Book(id, title, content);
        books.add(newBook);
        return newBook;
    }

    // update Book
    public Book updateBook(int id, String title, String content) {
        for(Book b: books) {
            if(b.getId() == id) {
                int BookIndex = books.indexOf(b);
                b.setTitle(title);
                b.setContent(content);
                books.set(BookIndex, b);
                return b;
            }

        }

        return null;
    }

    // delete Book by id
    public boolean delete(int id){
        int bookIndex = -1;
        for(Book b: books) {
            if(b.getId() == id) {
                bookIndex = books.indexOf(b);
                continue;
            }
        }
        if(bookIndex > -1){
            books.remove(bookIndex);
        }
        return true;
    }
}