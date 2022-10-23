package Library;

import java.util.ArrayList;

import Book.Book;
import Exceptions.StringTooLongException;

public class Library {
    private Integer library_number;
    private String library_city;
    private String library_street;
    private ArrayList<Book> books = new ArrayList<Book>();

    public Library(Integer library_number, String library_city, String library_street) {

        // Номер библиотеки
        number_ok(library_number);
        this.library_number = library_number;

        // Город, в котором расположена библиотека
        city_ok(library_city.trim());
        this.library_city = library_city.trim();

        // Улица, на которой расположена библиотека
        street_ok(library_street.trim());
        this.library_street = library_street.trim();

        // Список книг, которые есть в библиотеке
        this.books = new ArrayList<Book>();
    }

    public Integer getLibrary_number() {

        return this.library_number;
    }

    public String getLibrary_city() {
        return this.library_city;
    }

    public String getLibrary_street() {
        return this.library_street;
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public void setLibrary_number(Integer library_number) {
        number_ok(library_number);
        this.library_number = library_number;
    }

    public void setLibrary_city(String library_city) {
        city_ok(library_city.trim());
        this.library_city = library_city.trim();
    }

    public void setLibrary_street(String library_street) {
        street_ok(library_street.trim());
        this.library_street = library_street.trim();
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new NullPointerException("Book can't be null!");
        }
        this.books.add(book);

    }

    public void removeBook(Book book) {
        if (this.books.contains(book)) {
            this.books.remove(book);
        } else {
            throw new IllegalArgumentException("This book doesn't exist in this library!");
        }
    }

    // Метод, проверяющий число на правильность
    private static void number_ok(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException("Library number must be greater than zero!");
        }
    }

    // Метод, проверяющий длину строки
    private static void length_ok(String checked_string) {
        if (checked_string.length() > 128) {
            throw new StringTooLongException("String '" + checked_string + "' is too long!");
        }
    }

    private static void city_ok(String libraty_city) {
        if (!string_check(libraty_city)) {
            throw new IllegalArgumentException("Library city '" + libraty_city + "' is not acceptable!");
        }
    }

    private static void street_ok(String library_street) {
        if (!string_check(library_street)) {
            throw new IllegalArgumentException("Library street '" + library_street + "' is not acceptable!");
        }
    }

    // Метод, проверяющий город и улицу на правильность
    private static boolean string_check(String string) {
        length_ok(string);
        if (!string.matches("[а-яА-Яa-zA-Z0-9]+(?:[\s-][а-яА-Яa-zA-Z0-9]+)*$")) {
            return false;
        }
        return true;

    }

    @Override
    public String toString() {
        return "{" +
                " library_number='" + getLibrary_number() + "'" +
                ", library_city='" + getLibrary_city() + "'" +
                ", library_street='" + getLibrary_street() + "'" +
                ", books='" + getBooks() + "'" +
                "}";
    }
}