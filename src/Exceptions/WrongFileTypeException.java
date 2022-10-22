package Exceptions;

public class WrongFileTypeException extends RuntimeException {
    public WrongFileTypeException(Throwable err) {
        super(err);
    }

    public WrongFileTypeException() {
    }

    public WrongFileTypeException(String string) {
        super(string);
    }
}
