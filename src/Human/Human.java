package Human;

import Exceptions.StringTooLongException;

public class Human {
    private String human_name;
    private String human_surname;

    public Human(String human_name, String human_surname) {
        human_name = human_name.trim();
        name_ok(human_name);
        this.human_name = human_name;

        human_surname = human_surname.trim();
        name_ok(human_surname);
        this.human_surname = human_surname;
    }

    public String getHuman_name() {
        return this.human_name;
    }

    public void setHuman_name(String human_name) {
        name_ok(human_name);
        this.human_name = human_name;
    }

    public String getHuman_surname() {
        return this.human_surname;
    }

    public void setHuman_surname(String human_surname) {
        name_ok(human_surname);
        this.human_surname = human_surname;
    }

    // Метод, проверяющий имя на правильность
    private static void name_ok(String checked_name) {
        length_ok(checked_name);
        if (!checked_name.matches("[а-яА-ЯёЁa-zA-Z]+$"))
            throw new IllegalArgumentException("Only cyrillic and latin letters allowed");
    }

    // Метод, проверяющий длину строки
    private static void length_ok(String checked_string) {
        if (checked_string.length() > 128) {
            throw new StringTooLongException();
        }
    }

    @Override
    public String toString() {
        return "{" +
                " human_name='" + getHuman_name() + "'" +
                ", human_surname='" + getHuman_surname() + "'" +
                "}";
    }

}
