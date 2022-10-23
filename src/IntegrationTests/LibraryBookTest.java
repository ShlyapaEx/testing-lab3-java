package IntegrationTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Book.Book;
import Library.Library;

public class LibraryBookTest {
    Library null_library;
    Book null_book;
    static Library test_library = new Library(1, "City", "Street");
    static Book test_book1 = new Book("John", "Catrine", "How to cook", 2001, 100);
    static Book test_book2 = new Book("Bob", "Kek", "How to read", 2010, 123);
    // static Book test_book3 = new Book("Anthony", "Lepoop", "How to ride a bike",
    // 2023, 666);
    // static Book test_book4 = new Book("Martin", "Robart", "Anime is not an art!",
    // 2022, 1337);
    // static Book test_book5 = new Book("Rozetka", "Petrovich", "ElectroCUTE <3",
    // 1990, 444);

    @BeforeClass
    public static void test_init() {
        test_library.addBook(test_book1);

        // test_book1.addCo_author(test_book2);
        // test_book1.addCo_author(test_book3);
        // test_book2.addCo_author(test_book5);
        // test_book3.addCo_author(test_book1);
        // test_book4.addCo_author(test_book1);
        // test_book4.addCo_author(test_book2);
        // test_book5.addCo_author(test_book3);
        // test_book5.addCo_author(test_book5);
    }

    // Тест, добавляющий в библиотеку 50 книг
    @Test
    public void add_50_books_to_library_test() {
        for (int i = 0; i < 50; i++) {
            String author_name = "AuthorName";
            String author_surname = "AuthorSurname";
            String book_title = "BookTitle";
            Integer release_year = 2000 + i;
            Integer sold_count = i * 200;
            Book temp_book = new Book(author_name, author_surname, book_title, release_year, sold_count);
            test_library.addBook(temp_book);
            assertTrue(test_library.getBooks().contains(temp_book));
        }
    }

    @Test
    public void delete_existing_book_test() {
        test_library.removeBook(test_book1);
        assertFalse(test_library.getBooks().contains(test_book1));
    }

    // Тест, добавляющий null книгу в нормальную библиотеку
    @Test(expected = NullPointerException.class)
    public void null_book_to_library_test() {
        test_library.addBook(null_book);
    }

    // Тест, добавляющий null книгу в null библиотеку
    @Test(expected = NullPointerException.class)
    public void null_book_to_null_library_test() {
        null_library.addBook(null_book);
    }

    // Тест, удаляющий книгу, которой и так нет в библотеке
    @Test(expected = IllegalArgumentException.class)
    public void remove_non_existent_book_test() {
        test_library.removeBook(test_book2);
    }
}
