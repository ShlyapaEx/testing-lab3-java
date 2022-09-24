package Book.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import Book.Book;

public class BookConstructorTest {
    Book test_book = new Book("authorName", "authorSurname", "Title", 2001, 100);

    @Test(expected = NullPointerException.class)
    public void null_first_name_test() {
        Book null_first_name_book = new Book(null, "Surname", "Title", 2001, 100);
    }

    @Test(expected = NullPointerException.class)
    public void null_surname_test() {
        Book null_surname_book = new Book("authorName", null, "Title", 2001, 100);
    }

    @Test(expected = NullPointerException.class)
    public void null_title_test() {
        Book null_title_book = new Book("authorName", "Surname", null, 2001, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zero_symbols_first_name_test() {
        Book zero_symbols_first_name_book = new Book("", "Surname", "Title", 2001, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zero_symbols_surname_test() {
        Book zero_symbols_surname_book = new Book("authorName", "", "Title", 2001, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zero_symbols_title_test() {
        Book zero_symbols_title_book = new Book("authorName", "Surname", "", 2001, 100);
    }

    @Test
    public void all_fields_constructor_book_test() {
        Book test_book = new Book("authorName", "authorSurname", "Title", 2001, 100);
        assertTrue(test_book.getAuthor_surname().equals("authorName"));
        assertTrue(test_book.getAuthor_firstname().equals("authorSurname"));
        assertTrue(test_book.getTitle().equals("Title"));
        assertTrue(test_book.getRelease_year() == 2001);
        assertTrue(test_book.getSold_count() == 100);
    }

}
