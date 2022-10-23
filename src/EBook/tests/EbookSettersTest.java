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

public class EbookSettersTest {
    EBook test_ebook = new EBook("Surname", "FirstName", "Title", 2001, 150000, "pdf", 1024);
    Integer too_large_size = 1024 * 1024 * 1024 + 1;
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
    public void set_negative_file_size_test() {
        test_ebook.setFile_size(-1);
    }

    @Test(expected = MaxFileSizeExtendedException.class)
    public void set_too_large_file_size_test() {
        test_ebook.setFile_size(too_large_size);
    }

    @Test(expected = WrongFileTypeException.class)
    public void set_docx_file_type_test() {
        test_ebook.setFile_format("docx");
    }

    @Test
    public void set_epub_file_type_test() {
        test_ebook.setFile_format(" epub  ");
        assertTrue(test_ebook.getFile_format().equals("epub"));
    }

    @Test
    public void set_150_file_size_test() {
        test_ebook.setFile_size(150);
        assertTrue(test_ebook.getFile_size() == 150);
    }

    @AfterClass
    public static void print_log() {
        System.out.println(watchedLog);
    }
}
