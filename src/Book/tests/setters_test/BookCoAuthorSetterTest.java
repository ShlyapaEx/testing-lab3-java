package Book.tests.setters_test;

import Book.Book;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class BookCoAuthorSetterTest {
    Book test_book1 = new Book("authorNameOne", "authorSurnameOne", "TitleOne", 2001, 101);
    Book test_book2 = new Book("authorNameTwo", "authorSurnameTwo", "TitleTwo", 2002, 102);
    // Book test_book3 = new Book("authorNameThree", "authorSurnameThree",
    // "TitleThree", 2003, 103);

    // @Before
    // public void co_author_initialize() {
    // test_book1.addCo_author(test_book2);
    // }
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

    @Test
    public void add_valid_co_author_test() {
        test_book1.addCo_author(test_book2);
        String test_book2_author_full_name = test_book2.getAuthor_surname() + " " + test_book2.getAuthor_firstname();
        assertTrue(test_book1.getCo_authors().contains(test_book2_author_full_name));
    }

    @Test
    public void delete_valid_co_author_test() {
        test_book1.addCo_author(test_book2);
        String test_book2_author_full_name = test_book2.getAuthor_surname() + " " + test_book2.getAuthor_firstname();
        test_book1.removeCo_author(test_book2_author_full_name);
        assertFalse(test_book1.getCo_authors().contains(test_book2_author_full_name));
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_duplicated_co_author_test() {
        test_book1.addCo_author(test_book2);
        test_book1.addCo_author(test_book2);
    }

    @Test(expected = NullPointerException.class)
    public void add_null_Co_Author_test() {
        test_book1.addCo_author(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void delete_not_existent_co_author_test() {
        test_book2.removeCo_author("Good Man");
    }

    @AfterClass
    public static void print_log() {
        System.out.println(watchedLog);
    }
}
