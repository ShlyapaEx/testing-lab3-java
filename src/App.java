import java.util.HashSet;
import java.util.Set;

import Book.Book;
import EBook.EBook;
import Library.Library;

public class App {
    public static void main(String[] args) throws Exception {
        Set<String> co_authors = new HashSet<String>();
        co_authors.add("Mango");// Adding object in arraylist
        co_authors.add("Mango");
        co_authors.add("Banana");
        co_authors.add("Grapes");
        // Book null_book;
        Book test_book1 = new Book("John", "Catrine", "How to cook", 2001, 100);
        Book test_book2 = new Book("Bob", "Kek", "How to read", 2010, 123);
        Book test_book3 = new Book("Anthony", "Lepoop", "How to ride a bike", 2023, 666);
        Book test_book4 = new Book("Martin", "Robart", "Anime is not art!", 2022, 1337);
        Book test_book5 = new Book("Rozetka", "Petrovich", "ElectroCUTE <3", 1990, 444);
        Book book1 = new Book("Popov", "Ivan", "Как заработать миллион 123", 2000, 111111110);
        EBook ebook1 = new EBook("Popov", "Ivan", "Как заработать миллион 123", 2000, 111111110, "pdf", 300);
        EBook ebook2 = new EBook("Second", "Book", "Unique Name", 2010, 321123, "epub", 666);
        Library library = new Library(1, "Zelenograd-Francisco-12", "Gor");
        library.addBook(book1);
        library.addBook(ebook1);
        library.addBook(ebook2);
        library.setLibrary_city("   fdsfsd fsdfds    ");
        // EBook ebook43242 = new EBook(null_book, "pdf", 200);
        ebook2.setAuthor_firstname("Nika");
        // System.out.println(book1);
        // System.out.println(ebook1);
        System.out.println(library);
    }
}
