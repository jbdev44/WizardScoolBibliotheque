package com.wizardschool.bibliotakeary.controller;

        import com.wizardschool.bibliotakeary.model.Book;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Map;

@RestController
public class BookController {
    /*@Autowired
    BookRepository bookRepository;
    /* idem que*/
    BookRepository bookRepository = BookRepository.getInstance();/*
    */

    @RequestMapping("/")
    public String maFonction() {
        return "Bienvenue sur ma bibliotheque de Wizard a la Wizard Corporate School";
    }


    @GetMapping("/book")
    public List<Book> index(){
        return bookRepository.fetchBooks();
    }

    @GetMapping("/book/{id}")
    public Book show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return bookRepository.getBookById(blogId);
    }

    @PostMapping("/book/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookRepository.searchBooks(searchTerm);
    }

    @PostMapping("/book")
    public Book create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String author = body.get("author");
        String description = body.get("description");
        return bookRepository.createBook(id, title, author, description);
    }

    @PutMapping("/book/{id}")
    public Book update(@PathVariable String id, @RequestBody Map<String, String> body){
        int bookId = Integer.parseInt(id);
        String title = body.get("title");
        String author = body.get("author");
        String description = body.get("description");
        return bookRepository.updateBook(bookId, title, author, description);
    }

    @DeleteMapping("book/{id}")
    public boolean delete(@PathVariable String id){
        int bookId = Integer.parseInt(id);
        return bookRepository.delete(bookId);
    }


}