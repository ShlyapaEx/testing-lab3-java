import java.util.HashSet;
import java.util.Set;

import Book.Book;
import EBook.EBook;

public class App {
    public static void main(String[] args) throws Exception {
        Set<String> co_authors = new HashSet<String>();
        co_authors.add("Mango");// Adding object in arraylist
        co_authors.add("Mango");
        co_authors.add("Banana");
        co_authors.add("Grapes");

        Book book1 = new Book("Popov", "Ivan", "Как заработать миллион 123", 2000, 111111110);
        EBook ebook1 = new EBook("Popov", "Ivan", "Как заработать миллион 123", 2000, 111111110, "pdf");

        System.out.println(book1);
        System.out.println(ebook1);
    }
}
