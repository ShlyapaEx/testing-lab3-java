package Book.tests.setters_test;

import Book.Book;
import Exceptions.NumberTooLongException;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookSoldCountTest {
    Book test_book = new Book("authorName", "authorSurname", "Title", 2001, 100);

    @Test(expected = IllegalArgumentException.class)
    public void set_negative_sold_count_test() {
        test_book.setSold_count(-1);
    }

    @Test(expected = NumberTooLongException.class)
    public void set_too_large_sold_count_test() {
        test_book.setSold_count(10000000001L);
    }

    @Test
    public void set_zero_sold_count_test() {
        test_book.setSold_count(0);
        assertTrue(test_book.getSold_count() == 0);
    }
}