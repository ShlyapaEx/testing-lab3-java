package IntegrationTests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import Book.Book;
import EBook.EBook;
import Library.Library;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class LibraryEbookTest {
    private static String watchedLog = "";
    static EBook test_ebook1 = new EBook("Popov", "Ivan", "Как заработать миллион 123", 2000, 111111110, "pdf", 300);
    static Book test_ebook2 = new EBook("Bob", "Kek", "How to read", 2010, 123, "epub", 1234567);
    static EBook null_ebook;
    static Library test_library = new Library(1, "City", "Street");

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

    // Тест на добавку электронной книги в библиотеку
    @Test
    public void add_ebook_to_library_test() {
        test_library.addBook(test_ebook1);
        assertTrue(test_library.getBooks().contains(test_ebook1));
    }

    // Тест на удаление несуществующей электронной книги из библиотеки
    @Test(expected = IllegalArgumentException.class)
    public void remove_non_existent_ebook_test() {
        test_library.removeBook(test_ebook2);
    }

    // Тест на добавку null электронной книги в библиотеку
    @Test(expected = NullPointerException.class)
    public void add_null_ebook_to_library_test() {
        test_library.addBook(null_ebook);
    }

    @AfterClass
    public static void print_log() {
        System.out.println(watchedLog);
    }
}
