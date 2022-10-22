package EBook;

import java.util.Objects;

import Book.Book;

public class EBook extends Book {

    private String file_format;

    public EBook(String author_surname, String author_firstname, String title, int release_year, int sold_count,
            String file_format) {
        super(author_surname, author_firstname, title, release_year, sold_count);
        this.file_format = file_format;
    }

    public String getFile_format() {
        return this.file_format;
    }

    public void setFile_format(String file_format) {
        this.file_format = file_format;
    }

    public EBook file_format(String file_format) {
        setFile_format(file_format);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EBook)) {
            return false;
        }
        EBook EBook = (EBook) o;
        return Objects.equals(file_format, EBook.file_format);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(file_format);
    }

    @Override
    public String toString() {
        return "{" +
                " file_format='" + getFile_format() + "'" +
                "}";
    }

}
