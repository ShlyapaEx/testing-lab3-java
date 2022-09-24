package Book.tests.setters_test;

import Book.Book;
import Exceptions.StringTooLongException;
import static org.junit.Assert.*;

import org.junit.Test;

public class BookSurnameSetterTest {
    Book test_book = new Book("authorName", "authorSurname", "Title", 2001, 100);

    @Test(expected = NullPointerException.class)
    public void set_null_surname_test() {
        test_book.setAuthor_surname(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_zero_symbols_surname_test() {
        test_book.setAuthor_surname("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_special_symbols_surname_test() {
        test_book.setAuthor_surname("!@#$%^&*(");
    }

    @Test(expected = StringTooLongException.class)
    public void set_one_hundred_twenty_nine_length_surname_test() {
        test_book.setAuthor_surname("a".repeat(129));
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_surname_with_space_symbol() {
        test_book.setAuthor_surname("f f");
    }

    @Test()
    public void set_ten_letters_surname_test() {
        test_book.setAuthor_surname("asdfzxcvgb");
        assertTrue(test_book.getAuthor_surname().equals("asdfzxcvgb"));
    }
}
