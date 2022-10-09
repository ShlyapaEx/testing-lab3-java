package Book.tests.setters_test;

import Book.Book;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import org.junit.Test;

public class BookYearTest {
    Book test_book = new Book("authorName", "authorSurname", "Title", 2001, 100);

    private static String watchedLog = "";

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            watchedLog += description + " " + "failed!\n";
        }

        @Override
        protected void succeeded(Description description) {
            watchedLog += description + " " + "success!\n";
        }
    };

    @Test(expected = IllegalArgumentException.class)
    public void set_negative_year_test() {
        test_book.setRelease_year(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    // @Test()
    public void set_too_big_year() {
        // try {
        test_book.setRelease_year(2102);

        // // fail();

        // } catch (IllegalArgumentException e) {
        // succeeded();
        // }
        // System.out.print("set_too_big_year test failed!\n");

        // }
        // System.out.print("set_too_big_year test ok\n");
        // System.out.print("Success");
    }

    @Test
    public void set_twenty_twenty_two_year_test() {
        test_book.setRelease_year(2022);
        assertTrue(test_book.getRelease_year() == 2022);
        fail();
    }

    // @Test(expected = Error.class)
    // public void year_null_test() {
    // test_book.setRelease_year(null); //
    // }
    @AfterClass
    public static void print_log() {
        System.out.println(watchedLog);
    }
}
