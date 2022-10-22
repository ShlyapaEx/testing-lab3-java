package Book.tests.setters_test;

import Book.Book;
import Exceptions.StringTooLongException;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class BookTitleSetterTest {
    Book test_book = new Book("authorName", "authorSurname", "Title", 2001, 100);
    private static String watchedLog = "";

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            watchedLog += description + " " + "failed!\n";
            // System.out.println(watchedLog);
        }

        @Override
        protected void succeeded(Description description) {
            watchedLog += description + " " + "success!\n";
            // System.out.println(watchedLog);
        }
    };

    @Test(expected = NullPointerException.class)
    public void set_null_title_test() {
        test_book.setTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_zero_symbols_title_test() {
        test_book.setTitle("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_special_symbols_title_test() {
        test_book.setTitle("!@#$%^&*(");
    }

    @Test(expected = StringTooLongException.class)
    public void set_one_hundred_twenty_nine_length_title_test() {
        test_book.setTitle("a".repeat(129));
    }

    @Test()
    public void set_letters_numbers_title_test() {
        test_book.setTitle("asdfzxcvgb 123");
        assertTrue(test_book.getTitle().equals("asdfzxcvgb 123"));
    }

    @AfterClass
    public static void print_log() {
        System.out.println(watchedLog);
    }
}
