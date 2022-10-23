package Library.tests;

import org.junit.runner.Description;
import static org.junit.Assert.assertTrue;

import Library.Library;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class LibraryConstructorTest {
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
    public void negative_number_library_test() {
        Library negative_number_library = new Library(-1, "City", "Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void bad_city_test() {
        Library bad_city_library = new Library(1, "%^&*", "Street");
    }

    @Test()
    public void good_library_test() {
        Library good_library = new Library(1, "City", "Street");
        assertTrue(good_library.getLibrary_number() == 1);
        assertTrue(good_library.getLibrary_city().equals("City"));
        assertTrue(good_library.getLibrary_street().equals("Street"));
    }

    @AfterClass
    public static void print_log() {
        System.out.println(watchedLog);
    }
}
