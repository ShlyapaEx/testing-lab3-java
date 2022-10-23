package EBook.tests;

import org.junit.Test;
import EBook.EBook;
import Exceptions.MaxFileSizeExtendedException;
import Exceptions.WrongFileTypeException;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class EBookConstructorTest {
    private static String watchedLog = "";
    Integer too_large_size = 1024 * 1024 * 1024 + 1;
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
    public void create_ok_ebook_test() {
        EBook ok_eBook = new EBook("Surname", "FirstName", "Title", 2001, 150000, "pdf", 1024);
        assertTrue(ok_eBook.getAuthor_surname().equals("Surname"));
        assertTrue(ok_eBook.getAuthor_firstname().equals("FirstName"));
        assertTrue(ok_eBook.getTitle().equals("Title"));
        assertTrue(ok_eBook.getRelease_year() == 2001);
        assertTrue(ok_eBook.getSold_count() == 150000);
        assertTrue(ok_eBook.getFile_format().equals("pdf"));
        assertTrue(ok_eBook.getFile_size() == 1024);
    }

    @Test(expected = WrongFileTypeException.class)
    public void wrong_file_format_ebook_test() {
        EBook wrong_file_type_ebook = new EBook("Surname", "FirstName", "Title", 2001, 150000, "docx", 1024);
    }

    @Test(expected = MaxFileSizeExtendedException.class)
    public void too_large_file_ebook_test() {

        EBook too_large_file_ebook = new EBook("Surname", "FirstName", "Title", 2001, 150000, "pdf", too_large_size);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_file_size_test() {
        EBook negative_size_eBook = new EBook("Surname", "FirstName", "Title", 2001, 150000, "pdf", -1);
    }

    @AfterClass
    public static void print_log() {
        System.out.println(watchedLog);
    }
}
