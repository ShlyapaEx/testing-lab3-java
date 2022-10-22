package EBook;

import Book.Book;
import Config.Config;
import Exceptions.MaxFileSizeExtendedException;
import Exceptions.WrongFileTypeException;

public class EBook extends Book {

    private String file_format;
    private Integer file_size;

    public EBook(String author_surname, String author_firstname, String title, int release_year, int sold_count,
            String file_format, Integer file_size) {
        super(author_surname, author_firstname, title, release_year, sold_count);

        // Формат файла электронной книги
        format_ok(file_format.trim());
        this.file_format = file_format.trim();

        // Размер файла электронной книги
        file_size_ok(file_size);
        this.file_size = file_size;
    }

    public Integer getFile_size() {
        return this.file_size;
    }

    public Integer setFile_size(Integer file_size) {
        file_size_ok(file_size);
        return this.file_size = file_size;
    }

    public String getFile_format() {
        return this.file_format;
    }

    public void setFile_format(String file_format) {
        format_ok(file_format.trim());
        this.file_format = file_format.trim();
    }

    private static void format_ok(String file_format) {
        if (!Config.allowed_formats.contains(file_format.trim())) {
            throw new WrongFileTypeException("File format '" + file_format + "' is not allowed!");
        }
    }

    private static void file_size_ok(Integer file_size) {
        if (file_size > Config.max_file_size) {
            throw new MaxFileSizeExtendedException();
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
                " file_format='" + getFile_format() + "'" +
                "}";
    }

}
