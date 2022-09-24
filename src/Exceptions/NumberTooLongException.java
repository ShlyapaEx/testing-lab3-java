package Exceptions;

public class NumberTooLongException extends RuntimeException {
    public NumberTooLongException(Throwable err) {
        super(err);
    }

    public NumberTooLongException() {
    }
}