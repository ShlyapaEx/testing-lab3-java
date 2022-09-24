package Exceptions;

public class StringTooLongException extends RuntimeException {
    public StringTooLongException(Throwable err) {
        super(err);
    }

    public StringTooLongException() {
    }
}
