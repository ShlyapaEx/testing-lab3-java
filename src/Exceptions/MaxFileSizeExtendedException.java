package Exceptions;

public class MaxFileSizeExtendedException extends RuntimeException {
    public MaxFileSizeExtendedException(Throwable err) {
        super(err);
    }

    public MaxFileSizeExtendedException() {
    }

}
