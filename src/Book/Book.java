package Book;

import java.util.ArrayList;

import Exceptions.StringTooLongException;
import Exceptions.NumberTooLongException;

import Human.Human;

public class Book {
    // private String author_surname;
    // private String author_firstname;
    private Human author;
    private String title;
    private int release_year;
    private long sold_count;
    private ArrayList<Human> co_authors;

    public Book(String author_surname, String author_firstname, String title, int release_year, int sold_count) {

        // Фамилия автора
        // name_ok(author_surname);
        // this.author_surname = author_surname;

        // // Имя автора
        // name_ok(author_firstname);
        // this.author_firstname = author_firstname;

        // Автор книги
        this.author = new Human(author_firstname, author_surname);

        // Название книги
        string_ok(title.trim());
        this.title = title.trim();

        // Год выпуска
        year_ok(release_year);
        this.release_year = release_year;

        // Тираж
        number_ok(sold_count);
        this.sold_count = sold_count;

        // Соавторы
        this.co_authors = new ArrayList<>();
    }

    // Метод, возвращающий автора полностью
    public Human getAuthor() {
        return this.author;
    }

    // Метод, возвращающий фамилию автора
    public String getAuthor_surname() {
        // return this.author_surname;
        return this.author.getHuman_surname();

    }

    // Метод, возвращающий имя автора
    public String getAuthor_firstname() {
        // return this.author_firstname;
        return this.author.getHuman_name();
    }

    // Метод, возвращающий название книги
    public String getTitle() {
        return this.title;
    }

    // Метод, возвращающий год выпуска
    public int getRelease_year() {
        return this.release_year;
    }

    // Метод, возвращающий тираж
    public long getSold_count() {
        return this.sold_count;
    }

    // Метод, возвращающий список соавторов
    public ArrayList<Human> getCo_authors() {
        return this.co_authors;
    }

    // Метод, устанавливающий фамилию автора
    public void setAuthor_surname(String author_surname) {
        // name_ok(author_surname.trim());
        // this.author_surname = author_surname.trim();
        this.author.setHuman_surname(author_surname);
    }

    // Метод, устанавливающий имя автора
    public void setAuthor_firstname(String author_firstname) {
        // name_ok(author_firstname.trim());
        // this.author_firstname = author_firstname.trim();
        this.author.setHuman_name(author_firstname);
    }

    // Метод, устанавливающий название
    public void setTitle(String title) {
        string_ok(title.trim());
        this.title = title.trim();
    }

    // Метод, устанавливающий год выпуска
    public void setRelease_year(int release_year) {
        year_ok(release_year);
        this.release_year = release_year;
    }

    // Метод, устанавливающий тираж
    public void setSold_count(long sold_count) {
        number_ok(sold_count);
        this.sold_count = sold_count;
    }

    // Метод, добавляющий соавтора, который является автором другой книги
    public void addCo_author(Book book) {

        // Проверка на то, что автор не может являться соавтором своей книги
        if (this.author.getHuman_surname()
                .equals(book.getAuthor_surname()) && this.getAuthor_firstname().equals(book.getAuthor_firstname())) {
            throw new IllegalArgumentException("You can't make co_author from author of a book");
        }

        // Проверка на существование соавтора перед добавлением
        // String co_author_full_name = book.getAuthor_surname() + " " +
        // book.getAuthor_firstname();
        if (!this.co_authors.contains(book.getAuthor())) {
            this.co_authors.add(book.getAuthor());
        } else
            throw new IllegalArgumentException("This co_author already exists in this book");
    }

    // Метод, удаляющий соавтора из списка соавторов
    public void removeCo_author(Human co_author) {
        if (this.co_authors.contains(co_author)) {
            this.co_authors.remove(co_author);
        } else {
            throw new IllegalArgumentException("This co_author doesn't exist in this book");
        }
    }

    // Метод, проверяющий длину строки
    private static void length_ok(String checked_string) {
        if (checked_string.length() > 128) {
            throw new StringTooLongException();
        }
    }

    // Метод, проверяющий строку на правильность
    private static void string_ok(String checked_string) {
        length_ok(checked_string);
        // if (!checked_string.matches("[а-яА-ЯёЁa-zA-Z0-9\\s!@#$&()-`.+,\\]+$")) {
        // throw new IllegalArgumentException("Only numbers, spaces, cyrillic and latin
        // letters allowed");
        // }
    }

    // Метод, проверяющий число на правильность
    private static void number_ok(long number) {
        if (number < 0)
            throw new IllegalArgumentException("Only numbers greater than zero allowed");
        // Если число больше 10 миллиардов
        if (number > 10000000000L) {
            throw new NumberTooLongException();
        }
    }

    private static void year_ok(Integer year) {
        if (year < 0)
            throw new IllegalArgumentException("Only positive numbers or zero allowed");
        if (year > 2100) {
            throw new IllegalArgumentException("Wrong year");
        }
    }

    @Override
    public String toString() {
        return "{" +
                " author_surname='" + getAuthor_surname() + "'" +
                ", author_firstname='" + getAuthor_firstname() + "'" +
                ", title='" + getTitle() + "'" +
                ", release_year='" + getRelease_year() + "'" +
                ", sold_count='" + getSold_count() + "'" +
                ", co_authors='" + getCo_authors() + "'" +
                " }";
    }
}