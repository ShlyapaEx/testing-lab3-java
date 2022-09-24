package Book.tests.setters_test;

import Book.Book;
import static org.junit.Assert.*;

import org.junit.Test;

public class BookYearTest {
    Book test_book = new Book("authorName", "authorSurname", "Title", 2001, 100);

    @Test(expected = IllegalArgumentException.class)
    public void set_negative_year_test() {
        test_book.setRelease_year(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_special_symbols_title_test() {
        test_book.setRelease_year(2102);
    }

    @Test
    public void set_twenty_twenty_two_year_test() {
        test_book.setRelease_year(2022);
        assertTrue(test_book.getRelease_year() == 2022);
    }

}
