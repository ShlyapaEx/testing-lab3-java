import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import Book.Book;
import EBook.EBook;
import Library.Library;

public class SystemTest {

    private static String watchedLog = "";

    @Rule
    // public ExpectedException thrown = ExpectedException.none();
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

    @Test(timeout = 100)
    public void full_test() {
        // Тестирование работы конструкторов //

        Book test_book1 = new Book("authorNameOne", "authorSurnameOne", "TitleOne", 2001, 101);
        Book test_book2 = new Book("authorNameTwo", "authorSurnameTwo", "TitleTwo", 2002, 102);
        EBook test_ebook = new EBook("Surname", "FirstName", "Title", 2001, 150000, "pdf", 1024);
        Library test_library = new Library(1, "City", "Street");

        // Тестирование работы функции добавления соавторов //
        // Для обычной книги
        test_book1.addCo_author(test_ebook);
        test_book1.addCo_author(test_book2);
        assertThrows(IllegalArgumentException.class, () -> test_book1.addCo_author(test_book2));

        assertTrue(test_book1.getCo_authors().contains("Surname FirstName"));
        assertTrue(test_book1.getCo_authors().contains("authorNameTwo authorSurnameTwo"));

        // Для электронной книги
        test_ebook.addCo_author(test_book1);
        test_ebook.addCo_author(test_book2);
        assertThrows(IllegalArgumentException.class, () -> test_ebook.addCo_author(test_book1));

        assertTrue(test_ebook.getCo_authors().contains("authorNameOne authorSurnameOne"));
        assertTrue(test_ebook.getCo_authors().contains("authorNameTwo authorSurnameTwo"));

        // Тестирование работы функции удаления соавторов //
        // Для обычной книги
        test_book1.removeCo_author("Surname FirstName");
        test_book1.removeCo_author("authorNameTwo authorSurnameTwo");
        assertThrows(IllegalArgumentException.class, () -> test_book1.removeCo_author("Surname FirstName"));

        assertFalse(test_book1.getCo_authors().contains("Surname FirstName"));
        assertFalse(test_book1.getCo_authors().contains("authorNameTwo authorSurnameTwo"));

        // Для электронной книги
        test_ebook.removeCo_author("authorNameOne authorSurnameOne");
        test_ebook.removeCo_author("authorNameTwo authorSurnameTwo");
        assertThrows(IllegalArgumentException.class,
                () -> test_ebook.removeCo_author("authorNameOne authorSurnameOne"));

        assertFalse(test_ebook.getCo_authors().contains("authorNameOne authorSurnameOne"));
        assertFalse(test_ebook.getCo_authors().contains("authorNameTwo authorSurnameTwo"));

        // Тестирование работы сеттеров //
        // Для обычной книги
        test_book1.setAuthor_firstname("TestFirstnameSetter");
        test_book1.setAuthor_surname("TestSurnameSetter");
        test_book1.setTitle("TitleSetter");
        test_book1.setRelease_year(2030);
        test_book1.setSold_count(2000);

        assertTrue(test_book1.getAuthor_firstname().equals("TestFirstnameSetter"));
        assertTrue(test_book1.getAuthor_surname().equals("TestSurnameSetter"));
        assertTrue(test_book1.getTitle().equals("TitleSetter"));
        assertTrue(test_book1.getRelease_year() == 2030);
        assertTrue(test_book1.getSold_count() == 2000);

        // Для электронной книги
        test_ebook.setAuthor_firstname("TestFirstnameSetter");
        test_ebook.setAuthor_surname("TestSurnameSetter");
        test_ebook.setTitle("TitleSetter");
        test_ebook.setRelease_year(2030);
        test_ebook.setSold_count(2000);
        test_ebook.setFile_format("pdf");
        test_ebook.setFile_size(400);

        assertTrue(test_ebook.getAuthor_firstname().equals("TestFirstnameSetter"));
        assertTrue(test_ebook.getAuthor_surname().equals("TestSurnameSetter"));
        assertTrue(test_ebook.getTitle().equals("TitleSetter"));
        assertTrue(test_ebook.getRelease_year() == 2030);
        assertTrue(test_ebook.getSold_count() == 2000);
        assertTrue(test_ebook.getFile_format().equals("pdf"));
        assertTrue(test_ebook.getFile_size() == 400);

        // Для библиотеки
        test_library.setLibrary_city("CitySetter");
        test_library.setLibrary_number(1234);
        test_library.setLibrary_street("StreetSetter");

        assertTrue(test_library.getLibrary_city().equals("CitySetter"));
        assertTrue(test_library.getLibrary_number() == 1234);
        assertTrue(test_library.getLibrary_street().equals("StreetSetter"));

        // Тестирование добавления книг в библиотеку //
        test_library.addBook(test_book1);
        test_library.addBook(test_book2);
        test_library.addBook(test_ebook);

        assertTrue(test_library.getBooks().contains(test_book1));
        assertTrue(test_library.getBooks().contains(test_book2));
        assertTrue(test_library.getBooks().contains(test_ebook));

        // Тестирование удаления книг из библиотеки //
        test_library.removeBook(test_book1);
        test_library.removeBook(test_book2);
        test_library.removeBook(test_ebook);

        assertFalse(test_library.getBooks().contains(test_book1));
        assertFalse(test_library.getBooks().contains(test_book2));
        assertFalse(test_library.getBooks().contains(test_ebook));
    }

    @Test(timeout = 500)
    public void performance_test() {

        System.out.println("Starting performance test...");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            full_test();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Performance test took " + (endTime - startTime) + " milliseconds");

    }

    @AfterClass
    public static void print_log() {
        System.out.println(watchedLog);
    }
}
