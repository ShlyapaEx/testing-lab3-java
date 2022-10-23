package Library.tests;

import org.junit.runner.Description;

import Book.Book;

import static org.junit.Assert.assertTrue;

import Library.Library;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class LibrarySettersTest {
    private static String watchedLog = "";
    Library test_library1 = new Library(1, "City", "Street");
    Book null_book;

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

    // Перенести это в интеграционное тестирование
    @Test(expected = NullPointerException.class)
    public void add_null_book() {
        test_library1.addBook(null_book);
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_special_symbols_only_city() {
        test_library1.setLibrary_city("(!@#");
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_special_symbols_only_street() {
        test_library1.setLibrary_street("(!@#");
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_negative_library_number() {
        test_library1.setLibrary_number(-1);
    }

    @Test
    public void set_library_city_with_spaces() {
        test_library1.setLibrary_city("    library city     ");
        assertTrue(test_library1.getLibrary_city().equals("library city"));
    }

    @AfterClass
    public static void print_log() {
        System.out.println(watchedLog);
    }
}
