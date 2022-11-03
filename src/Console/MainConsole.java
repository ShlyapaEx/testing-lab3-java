package Console;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import Book.Book;
import EBook.EBook;
import Library.Library;

public class MainConsole {
    static Console console = System.console();
    static Scanner scanner = new Scanner(console.reader());
    static Scanner button_press_scanner = new Scanner(System.in);
    static ArrayList<Book> books_memory = new ArrayList<Book>();

    public static void main(String[] args) throws IOException, InterruptedException {

        // String name = scanner.nextLine();
        // System.out.println(name);
        add_test_data();
        clear_console();
        System.out.println(Messages.greetings);
        display_main_menu();
        // while (true) {

        // }
    }

    /** Функция, отображающая главное меню программы */
    public static void display_main_menu() throws IOException, InterruptedException {
        try {
            clear_console();
            System.out.println(Messages.menu_header);
            System.out.println("1: " + Messages.book_main_menu_button);
            System.out.println("2: " + Messages.library_main_menu_button);
            String pressed_button = scanner.nextLine();
            switch (pressed_button.trim()) {
                case "1":
                    display_book_menu();
                    break;
                case "2":
                    display_library_menu();
                    break;
                default:
                    System.out.println(Messages.no_item_in_menu);
                    button_press_scanner.nextLine();
                    display_main_menu();
                    break;
            }
        } catch (Exception e) {
            error_handling(e);
        }
    }

    public static void display_book_menu() throws IOException, InterruptedException {
        try {
            clear_console();
            System.out.println(Messages.create_book_menu_button);

            System.out.println("1: " + Messages.create_book_menu_button);
            System.out.println("2: " + Messages.delete_book_menu_button);
            System.out.println("3: " + Messages.list_book_menu_button);

            String pressed_button = scanner.nextLine();
            switch (pressed_button.trim()) {
                case "1":
                    create_book_form();
                    break;
                case "2":
                    // display_library_menu();
                    success_and_return();
                    break;
                case "3":
                    list_book_form();
                    // display_library_menu();
                    break;
                default:
                    System.out.println(Messages.no_item_in_menu);
                    button_press_scanner.nextLine();
                    display_book_menu();
            }
        } catch (Exception e) {
            error_handling(e);
        }
    }

    public static void create_book_form() throws IOException, InterruptedException {
        try {
            clear_console();
            System.out.println(Messages.create_book_menu_button + "\n");

            System.out.println(Messages.type_choice_book_form);
            System.out.println("1: Paper Book");
            System.out.println("2: EBook");
            String book_type_choice = scanner.nextLine();
            switch (book_type_choice.trim()) {
                case "1":
                    book_type_choice = "Book";
                    break;
                case "2":
                    book_type_choice = "EBook";
                    break;
                default:
                    System.out.println(Messages.no_item_in_menu);
                    button_press_scanner.nextLine();
                    create_book_form();
                    break;
            }
            clear_console();
            System.out.println(Messages.enter_surname_book_form);
            String surname = scanner.nextLine();
            System.out.println(Messages.enter_firstname_book_form);
            String firstname = scanner.nextLine();
            System.out.println(Messages.enter_title_book_form);
            String title = scanner.nextLine();
            System.out.println(Messages.enter_release_year_book_form);
            Integer release_year = Integer.parseInt(scanner.nextLine());
            System.out.println(Messages.enter_sold_count_book_form);
            Integer sold_count = Integer.parseInt(scanner.nextLine());
            Book new_book = new Book(surname, firstname, title, release_year, sold_count);

            if (book_type_choice.equals("EBook")) {
                System.out.println(Messages.enter_file_type_book_form);
                String file_type = scanner.nextLine();
                System.out.println(Messages.enter_file_size_book_form);
                Integer file_size = 0;
                file_size = Integer.parseInt(scanner.nextLine());

                EBook new_ebook = new EBook(new_book, file_type, file_size);
                books_memory.add(new_ebook);
                success_and_return();
            }

            books_memory.add(new_book);
            success_and_return();
        } catch (Exception e) {
            error_handling(e);
        }
    }

    public static void list_book_form() throws IOException, InterruptedException {
        clear_console();
        System.out.println(Messages.list_book_menu_button + "\n");
        for (int i = 0; i < books_memory.size(); i++) {
            System.out.println("" + (i + 1) + ". " + books_memory.get(i) + "\n");
        }
        success_and_return();
    }

    public static void display_library_menu() throws IOException, InterruptedException {
        clear_console();
        System.out.println(Messages.create_library_menu_button);
        success_and_return();
    }

    public static void success_and_return() throws IOException, InterruptedException {
        System.out.println(Messages.success);
        button_press_scanner.nextLine();
        display_main_menu();
    }

    public static void add_test_data() throws IOException, InterruptedException {
        TestData.test_book1.addCo_author(TestData.test_book2);
        TestData.test_book1.addCo_author(TestData.test_book3);
        TestData.test_book4.addCo_author(TestData.test_book5);
        TestData.test_book4.addCo_author(TestData.ebook1);
        TestData.test_book4.addCo_author(TestData.ebook2);

        books_memory.add(TestData.test_book1);
        books_memory.add(TestData.test_book2);
        books_memory.add(TestData.test_book3);
        books_memory.add(TestData.test_book4);
        books_memory.add(TestData.test_book5);
        books_memory.add(TestData.ebook1);
        books_memory.add(TestData.ebook2);
    }

    public static void error_handling(Exception e) throws IOException, InterruptedException {
        System.out.println(e.getMessage());
        System.out.println("Press ENTER to try again");
        button_press_scanner.nextLine();
        display_book_menu();
    }

    public static void clear_console() throws IOException, InterruptedException {
        // Clears Screen in java
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

    }
}
