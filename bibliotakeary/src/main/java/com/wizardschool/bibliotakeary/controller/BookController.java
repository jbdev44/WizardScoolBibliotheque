package com.wizardschool.bibliotakeary.controller;

        import com.wizardschool.bibliotakeary.model.Book;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Map;

@RestController
public class BookController {

    BookMockedData bookMockedData = BookMockedData.getInstance();
    @RequestMapping("/")
    public String maFonction() {
        return "Bienvenue sur ma bibliotheque de Wizard a la Wizard Corporate School";
    }


    @GetMapping("/book")
    public List<Book> index(){
        return bookMockedData.fetchBooks();
    }

    @GetMapping("/book/{id}")
    public Book show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return bookMockedData.getBookById(blogId);
    }

    @PostMapping("/book/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookMockedData.searchBooks(searchTerm);
    }

    @PostMapping("/blog")
    public Book create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String content = body.get("content");
        return bookMockedData.createBook(id, title, content);
    }

    @PutMapping("/book/{id}")
    public Book update(@PathVariable String id, @RequestBody Map<String, String> body){
        int bookId = Integer.parseInt(id);
        String title = body.get("title");
        String content = body.get("content");
        return bookMockedData.updateBook(bookId, title, content);
    }

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id){
        int bookId = Integer.parseInt(id);
        return bookMockedData.delete(bookId);
    }


}