package Book.tests.setters_test;

import Book.Book;
import Exceptions.NumberTooLongException;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class BookSoldCountTest {
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

    // @Test(expected = Error.class)
    // public void sold_count_null_test() {
    // test_book.setSold_count(null); //
    // }
    @AfterClass
    public static void print_log() {
        System.out.println(watchedLog);
    }
}