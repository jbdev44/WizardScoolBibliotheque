package com.wizardschool.bibliotakeary.controller;

import com.wizardschool.bibliotakeary.model.Book;

import java.util.List;
import java.util.ArrayList;

public class BookRepository {
    //list of Book posts
    private List<Book> books;

    private static BookRepository instance = null;
    public static BookRepository getInstance(){
        if(instance == null){
            instance = new BookRepository();
        }
        return instance;
    }


    public BookRepository(){
        books = new ArrayList<Book>();
        books.add(new Book(1, "Harry Potter t.1 : Harry Potter à l'école des sorciers","J. K. Rowling",
                "Amitié, surprises, dangers, humour, Harry découvre ses pouvoirs et la vie à Poudlard. Le premier volume des aventures du jeune héros vous ensorcelle aussitôt !"));
        books.add(new Book(2, "Voyage au bout de la nuit","Louis-Ferdinand Céline",
                "Bardamu, qu'il me fait alors gravement et un peu triste, nos pères nous valaient bien, n'en dis pas de mal !... - T'as raison, Arthur, pour ça t'as raison ! Haineux et dociles, violés, volés, étripés et couillons toujours, ils nous valaient bien ! Tu peux le dire ! Nous ne changeons pas ! Ni de chaussettes, ni de maîtres, ni d'opinions, ou bien si tard, que ça n'en vaut plus la peine. On est nés fidèles, on en crève nous autres ! Soldats gratuits, héros pour tout le monde et singes parlants, mots qui souffrent, on est nous les mignons du Roi Misère. C'est lui qui nous possède ! "));
        books.add(new Book(3, "à la recherche du temps perdu : Intégrale t.1 à t.7","Marcel Proust",
                "Que celui qui pourrait écrire un tel livre serait heureux, pensais-je, quel labeur devant lui ! Pour en donner une idée, c'est aux arts les plus élevés et les plus différents qu'il faudrait emprunter des comparaisons ; car cet écrivain, qui d'ailleurs pour chaque caractère en ferait apparaître les faces opposées, pour montrer son volume, devrait préparer son livre minutieusement, avec de perpétuels regroupements de forces, comme une offensive, le supporter comme une fatigue, l'accepter comme une règle, le construire comme une église, le suivre comme un régime, le vaincre comme un obstacle, le conquérir comme une amitié, le suralimenter comme un enfant, le créer comme un monde sans laisser de côté ces mystères qui n'ont probablement"));
        books.add(new Book(4, "Cent ans de solitude","Gabriel García Márquez",
                "Une épopée vaste et multiple, un mythe haut en couleur plein de rêve et de réel. Histoire à la fois minutieuse et délirante d'une dynastie: la fondation, par l'ancêtre, d'un village sud-américain isolé du reste du monde; les grandes heures marquées par la magie et l'alchimie; la décadence; le déluge et la mort des animaux. Ce roman proliférant, merveilleux et doré comme une enluminure, est à sa façon un Quichotte sud-américain: même sens de la parodie, même rage d'écrire, même fête cyclique des soleils et des mots.\n" +
                        "Cent Ans de solitude compte parmi les chefs d'oeuvre de la littérature mondiale du XXe siècle. L'auteur a obtenu le prix Nobel de littérature en 1982."));
        books.add(new Book(5, "Le seigneur des anneaux t.1 : la fraternité de l'anneau","J.R.R. Tolkien",
                "Dans les vertes prairies du Comté, les Hobbits, ou Demi-hommes, vivaient en paix... Jusqu'au jour fatal où l'un d'entre eux, au cours de ses voyages, entra en possession de l'Anneau Unique aux immenses pouvoirs. Pour le reconquérir, Sauron, le seigneur Sombre, va déchaîner toutes les forces du Mal. Frodo, le Porteur de l'Anneau, Gandalf, le magicien, et leurs intrépides compagnons réussiront-ils à écarter la menace qui pèse sur la Terre du Milieu?"));
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
                    b.getDescription().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchedBooks.add(b);
            }
        }

        return searchedBooks;
    }

    // create Book
    public Book createBook(int id, String title, String author, String content) {
        Book newBook = new Book(id, title, author, content);
        books.add(newBook);
        return newBook;
    }

    // update Book
    public Book updateBook(int id, String title, String content, String s) {
        for(Book b: books) {
            if(b.getId() == id) {
                int BookIndex = books.indexOf(b);
                b.setTitle(title);
                b.setDescription(content);
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