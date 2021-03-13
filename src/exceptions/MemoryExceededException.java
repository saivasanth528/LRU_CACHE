package exceptions;

public class MemoryExceededException extends RuntimeException {
    public MemoryExceededException(String message) {
        super(message);
    }
}
