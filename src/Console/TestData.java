package Console;

import Book.Book;
import EBook.EBook;
import Library.Library;

public class TestData {
    public static Book test_book1 = new Book("John", "Catrine", "How to cook", 2001, 100);
    public static Book test_book2 = new Book("Bob", "Kek", "How to read", 2010, 123);
    public static Book test_book3 = new Book("Anthony", "Lepoop", "How to ride a bike", 2023, 666);
    public static Book test_book4 = new Book("Martin", "Robart", "Anime is not art!", 2022, 1337);
    public static Book test_book5 = new Book("Rozetka", "Petrovich", "ElectroCUTE <3", 1990, 444);
    public static Book book1 = new Book("Popov", "Ivan", "Как заработать миллион 123", 2000, 111111110);
    public static EBook ebook1 = new EBook("Popov", "Ivan", "Как заработать миллион 123", 2000, 111111110, "pdf", 300);
    public static EBook ebook2 = new EBook("Second", "Book", "Unique Name", 2010, 321123, "epub", 666);
    public static Library library = new Library(1, "Zelenograd-Francisco-12", "Gor");

}
