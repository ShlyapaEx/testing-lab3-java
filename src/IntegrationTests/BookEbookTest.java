package IntegrationTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import Book.Book;
import EBook.EBook;
import Exceptions.WrongFileTypeException;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class BookEbookTest {
    private static String watchedLog = "";
    static Book test_book1 = new Book("John", "Catrine", "How to cook", 2001, 100);
    static Book null_Book;
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

    // Проверка на правильное создание электронной книги из обычной
    @Test
    public void create_ebook_from_book_test() {
        EBook test_ebook = new EBook(test_book1, "pdf", 300);
        assertTrue(test_ebook.getAuthor_firstname().equals(test_book1.getAuthor_firstname()));
        assertTrue(test_ebook.getAuthor_surname().equals(test_book1.getAuthor_surname()));
        assertTrue(test_ebook.getTitle().equals(test_book1.getTitle()));
        assertTrue(test_ebook.getRelease_year() == test_book1.getRelease_year());
        assertTrue(test_ebook.getSold_count() == test_book1.getSold_count());
        assertTrue(test_ebook.getFile_format().equals("pdf"));
        assertTrue(test_ebook.getFile_size() == 300);
    }

    @Test(expected = WrongFileTypeException.class)
    public void create_ebook_from_book_with_docx_filetype_test() {
        EBook test_ebook = new EBook(test_book1, "docx", 300);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_ebook_from_book_with_negative_filesize_test() {
        EBook test_ebook = new EBook(test_book1, "pdf", -300);
    }

    @AfterClass
    public static void print_log() {
        System.out.println(watchedLog);
    }
}
