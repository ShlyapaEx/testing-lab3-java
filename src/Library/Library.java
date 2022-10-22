package Library;

import java.util.ArrayList;

import Book.Book;

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
        city_and_street_ok(library_city);
        this.library_city = library_city;

        // Улица, на которой расположена библиотека
        city_and_street_ok(library_street);
        this.library_street = library_street;

        // Список книг, которые есть в библиотеке
        this.books = new ArrayList<Book>();
    }

    // Метод, проверяющий число на правильность
    private static void number_ok(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException("Library number must be greater than zero!");
        }
    }

    // Метод, проверяющий город и улицу на правильность
    private static void city_and_street_ok(String city_or_street) {
        if (!city_or_street.matches("[а-яА-Яa-zA-Z0-9]+(?:[\s-][а-яА-Яa-zA-Z0-9]+)*$")) {
            throw new IllegalArgumentException("Illegal city or street name!");
        }

    }

    public Integer getLibrary_number() {
        return this.library_number;
    }

    public void setLibrary_number(Integer library_number) {
        this.library_number = library_number;
    }

    public String getLibrary_city() {
        return this.library_city;
    }

    public void setLibrary_city(String library_city) {
        this.library_city = library_city;
    }

    public String getLibrary_street() {
        return this.library_street;
    }

    public void setLibrary_street(String library_street) {
        this.library_street = library_street;
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        if (this.books.contains(book)) {
            this.books.remove(book);
        } else {
            throw new IllegalArgumentException("This book doesn't exist in this library!");
        }
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